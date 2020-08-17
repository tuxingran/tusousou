package com.oracle.hrb.tusousou.dao;

import com.oracle.hrb.tusousou.pojo.Variety;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VarietyDao {


    List<Variety> findAll();

    Variety findById(Integer id);


}
