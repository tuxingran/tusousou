package com.oracle.hrb.tusousou.service;

import com.oracle.hrb.tusousou.dao.AddressDao;
import com.oracle.hrb.tusousou.dao.NewsDao;
import com.oracle.hrb.tusousou.dao.NewsTypeDao;
import com.oracle.hrb.tusousou.pojo.Address;
import com.oracle.hrb.tusousou.pojo.News;
import com.oracle.hrb.tusousou.pojo.NewsType;
import com.oracle.hrb.tusousou.pojo.User;
import com.oracle.hrb.tusousou.util.GetDate;
import com.oracle.hrb.tusousou.util.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Service
public class AddressService {
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private Jedis jedis;
    @Autowired
    private Scanner S1;

    @Autowired
    private NewsTypeDao newsTypeDao;

    @Autowired
    private NewsDao newsDao;


    public AddressService() {
        System.out.println("启动了AddressService");
    }

    @Cacheable(value = "address", key = "#id.toString()")
    public List<Address> findByUserId(Integer id) {

        System.out.println("address被调用");
        return addressDao.findByUserId(id);

    }

    public void add(Address address) {
        System.out.println(S1);
        addressDao.add(address);
        User user = address.getUser();
        String str = "address::" + user.getId();
        jedis.set(str.getBytes(), SerializeUtil.serialize(addressDao.findByUserId(user.getId())));
        News news = new News();
        news.setDate(GetDate.getDate());
        news.setUser(user);

        news.setNewsType(newsTypeDao.findById(5));
        newsDao.add(news);

    }

    public void delete(Integer id,User user) {

        int userId = addressDao.findById(id).getUser().getId();
        addressDao.delete(id);
        String str = "address::" + userId;
        jedis.set(str.getBytes(), SerializeUtil.serialize(addressDao.findByUserId(userId)));
        News news = new News();
        news.setDate(GetDate.getDate());
        news.setUser(user);
        news.setNewsType(newsTypeDao.findById(5));
        newsDao.add(news);
    }

    public void update(Address address) {
        addressDao.update(address);
        User user = address.getUser();
        String str = "address::" + user.getId();
        jedis.set(str.getBytes(), SerializeUtil.serialize(addressDao.findByUserId(user.getId())));
        News news = new News();
        news.setDate(GetDate.getDate());
        news.setUser(user);
        news.setNewsType(newsTypeDao.findById(5));
        newsDao.add(news);

    }

}
