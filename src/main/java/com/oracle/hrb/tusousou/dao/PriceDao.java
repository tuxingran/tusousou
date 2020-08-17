package com.oracle.hrb.tusousou.dao;

import com.oracle.hrb.tusousou.pojo.Price;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceDao {


    List<Price> findAll();
}
