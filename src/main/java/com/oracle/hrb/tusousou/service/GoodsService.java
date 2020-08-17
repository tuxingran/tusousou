package com.oracle.hrb.tusousou.service;

import com.oracle.hrb.tusousou.dao.*;
import com.oracle.hrb.tusousou.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class GoodsService {
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

    @Autowired
    private GoodsDao goodsDao;

    @Cacheable(value = "goods", key = "#id.toString()")
    public List<Goods> findByVarietyId(Integer id) {
        return goodsDao.findByVarietyId(id);
    }

    public List<Goods> findAll() {
        return goodsDao.findAll();

    }


}
