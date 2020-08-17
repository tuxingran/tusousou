package com.oracle.hrb.tusousou.service;

import com.oracle.hrb.tusousou.dao.*;
import com.oracle.hrb.tusousou.pojo.Variety;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class VarietyService {
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private PriceDao priceDao;
    @Autowired
    private Jedis jedis;
    @Autowired
    private NewsTypeDao newsTypeDao;

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private VarietyDao varietyDao;


    @Cacheable(value = "variety")
    public List<Variety> findAll() {
        return varietyDao.findAll();

    }


}
