package com.oracle.hrb.tusousou.dao;

import com.oracle.hrb.tusousou.pojo.News;
import com.oracle.hrb.tusousou.pojo.NewsType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsDao {


    List<News> findAll();

    List<News> findByUserId(Integer id);

    void update(Integer id);

    void add(News news);

    void delete(Integer id);

}
