package com.oracle.hrb.tusousou.dao;

import com.oracle.hrb.tusousou.pojo.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDao {


    List<Goods> findAll();

    List<Goods> findByVarietyId(Integer id);
}
