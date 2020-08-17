package com.oracle.hrb.tusousou.service;

import com.oracle.hrb.tusousou.dao.NewsDao;
import com.oracle.hrb.tusousou.dao.NewsTypeDao;
import com.oracle.hrb.tusousou.dao.UserDao;
import com.oracle.hrb.tusousou.pojo.News;
import com.oracle.hrb.tusousou.pojo.User;
import com.oracle.hrb.tusousou.util.GetDate;
import com.oracle.hrb.tusousou.util.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

@Service
public class UserService {
    @Autowired
    private Jedis jedis;

    @Autowired
    private NewsTypeDao newsTypeDao;

    @Autowired
    private NewsDao newsDao;


    public UserService() {

    }

    @Autowired
    private UserDao userDao;

    @Transactional
    public int add(User user) {

        System.out.println("add方法操作了数据库");

        User byPhone = userDao.findByPhone(user.getPhone());
        if (byPhone != null) {
            return 2;
        }
        User byEmail = userDao.findByEmail(user.getE_mail());
        if (byEmail != null) {
            return 3;
        }
        userDao.add(user);
        return 0;

    }

    @Transactional
    public User login(User user) {

        User u = userDao.findByPhone(user.getPhone());
        if (u == null) {
            return null;
        }
        if (!u.getPassword().equals(user.getPassword())) {
            return null;
        }
        return u;
    }

    @Cacheable(value = "user", key = "#id.toString()")
    public User getUser(Integer id) {
        System.out.println("getUser方法操作了数据库");
        return userDao.findById(id);

    }


    public User update(User user) {
        System.out.println("update方法调用了");
        userDao.update(user);
        String str = "user::" + user.getId();
        jedis.set(str.getBytes(), SerializeUtil.serialize(userDao.findById(user.getId())));
        News news = new News();
        news.setDate(GetDate.getDate());
        news.setUser(user);
        news.setNewsType(newsTypeDao.findById(4));
        newsDao.add(news);
        return user;

    }

    public User findByPhone(String phone) {
        User user = userDao.findByPhone(phone);
        if (user == null) {
            return null;
        }
        return user;
    }

    @Transactional
    public int update2(User user) {
        System.out.println("update2方法调用了");
        User byPhone = userDao.findByPhone(user.getPhone());
        if (byPhone != null && byPhone.getId() != user.getId()) {
            return 2;
        }
        User byEmail = userDao.findByEmail(user.getE_mail());
        if (byEmail != null && byEmail.getId() != user.getId()) {
            return 3;
        }
        userDao.update(user);
        String str = "user::" + user.getId();
        jedis.set(str.getBytes(), SerializeUtil.serialize(userDao.findById(user.getId())));
        News news = new News();
        news.setDate(GetDate.getDate());
        news.setUser(user);
        news.setNewsType(newsTypeDao.findById(4));
        newsDao.add(news);
        return 0;
    }

    @Transactional
    public int bring(User user, String phone) {
        User u = userDao.findById(user.getId());
        User byPhone = userDao.findByPhone(phone);
        if (byPhone == null) {
            return 2;
        }
        if (u.getMoney() < user.getMoney()) {
            return 1;
        }

        u.setMoney(u.getMoney() - user.getMoney());
        byPhone.setMoney(byPhone.getMoney() + user.getMoney());
        userDao.update(u);
        userDao.update(byPhone);
        String str = "user::" + user.getId();
        jedis.set(str.getBytes(), SerializeUtil.serialize(userDao.findById(user.getId())));
        String str2 = "user::" + byPhone.getId();
        jedis.set(str2.getBytes(), SerializeUtil.serialize(userDao.findById(byPhone.getId())));
        News news = new News();
        news.setDate(GetDate.getDate());
        news.setUser(u);
        news.setNewsType(newsTypeDao.findById(2));
        newsDao.add(news);
        return 0;


    }

    @Transactional
    public int invest(User user, String password) {
        User u = userDao.findById(user.getId());
        if (!u.getPassword().equals(password)) {
            return 1;
        }
        if (u.getMoney() < user.getMoney()) {
            return 2;
        }
        u.setMoney(u.getMoney() - user.getMoney());
        u.setSouMoney(u.getSouMoney() + user.getSouMoney());
        userDao.update(u);
        String str = "user::" + user.getId();
        jedis.set(str.getBytes(), SerializeUtil.serialize(userDao.findById(user.getId())));
        News news = new News();
        news.setDate(GetDate.getDate());
        news.setUser(u);
        news.setNewsType(newsTypeDao.findById(1));
        newsDao.add(news);
        return 0;
    }

    public void sendEmail(String path, String title, String msg) throws Exception {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");// 连接协议
        properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
        properties.put("mail.smtp.port", 465);// 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
        // 得到回话对象
        Session session = Session.getInstance(properties);
        // 获取邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人邮箱地址
        message.setFrom(new InternetAddress("1316980941@qq.com"));
        // 设置收件人邮箱地址
        message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(path)});
        //message.setRecipient(Message.RecipientType.TO, new InternetAddress("xxx@qq.com"));//一个收件人
        // 设置邮件标题
        message.setSubject(title);
        // 设置邮件内容
        message.setText(msg);
        // 得到邮差对象
        Transport transport = session.getTransport();
        // 连接自己的邮箱账户
        transport.connect("1316980941@qq.com", "pgqlahmtpfykbacf");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码
        // 发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();

    }

}
