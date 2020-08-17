package com.oracle.hrb.tusousou.dao;

import com.oracle.hrb.tusousou.pojo.NewsType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsTypeDao {


    List<NewsType> findAll();

    NewsType findById(Integer id);

}
