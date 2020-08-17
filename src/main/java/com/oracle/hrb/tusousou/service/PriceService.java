package com.oracle.hrb.tusousou.service;

import com.oracle.hrb.tusousou.dao.*;
import com.oracle.hrb.tusousou.pojo.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class PriceService {
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private PriceDao priceDao;
    @Autowired
    private Jedis jedis;
    @Autowired
    private VarietyDao varietyDao;

    @Autowired
    private NewsTypeDao newsTypeDao;

    @Autowired
    private NewsDao newsDao;


    @Cacheable(value = "price")
    public List<Price> findAll() {
        System.out.println("getPrice操作了数据库");
        return priceDao.findAll();

    }


}
