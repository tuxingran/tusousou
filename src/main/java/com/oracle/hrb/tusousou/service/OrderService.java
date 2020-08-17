package com.oracle.hrb.tusousou.service;

import com.oracle.hrb.tusousou.dao.NewsDao;
import com.oracle.hrb.tusousou.dao.NewsTypeDao;
import com.oracle.hrb.tusousou.dao.OrderDao;
import com.oracle.hrb.tusousou.dao.UserDao;
import com.oracle.hrb.tusousou.pojo.News;
import com.oracle.hrb.tusousou.pojo.Order;
import com.oracle.hrb.tusousou.pojo.User;
import com.oracle.hrb.tusousou.util.GetDate;
import com.oracle.hrb.tusousou.util.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private Jedis jedis;

    @Autowired
    private NewsTypeDao newsTypeDao;

    @Autowired
    private NewsDao newsDao;

    @Cacheable(value = "order", key = "#id.toString()")
    public List<Order> findByUserId(Integer id) {
        return orderDao.findByUserId(id);

    }

    @Transactional
    public int add(Order order, double finprice, int sousou) {
        User sender = order.getSender();
        User byId = userDao.findById(sender.getId());
        if (byId.getMoney() < finprice) {
            return 2;
        }
        if (byId.getSouMoney() < sousou) {
            return 3;

        }
        orderDao.add(order);
        byId.setMoney(byId.getMoney() - finprice);
        byId.setSouMoney(byId.getSouMoney() - sousou);
        userDao.update(byId);
        List<Order> orders = orderDao.findByUserId(sender.getId());
        String str = "order::" + sender.getId();
        jedis.set(str.getBytes(), SerializeUtil.serialize(orders));
        String str2 = "user::" + sender.getId();
        jedis.set(str2.getBytes(), SerializeUtil.serialize(userDao.findById(sender.getId())));
        News news = new News();
        news.setDate(GetDate.getDate());
        news.setUser(sender);
        news.setNewsType(newsTypeDao.findById(3));
        newsDao.add(news);
        return 0;

    }

    public void accept(Integer id, Integer userId) {

        orderDao.accept(id);
        updateRedis(userId);

    }

    public void delete(Integer id, Integer userId, User user) {
        orderDao.delete(id);
        updateRedis(userId);



    }

    public void updateRedis(Integer userId) {
        String str = "order::" + userId;
        jedis.set(str.getBytes(), SerializeUtil.serialize(orderDao.findByUserId(userId)));
    }

}
