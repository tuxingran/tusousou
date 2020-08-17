package com.oracle.hrb.tusousou.service;

import com.oracle.hrb.tusousou.dao.NewsDao;
import com.oracle.hrb.tusousou.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {


    @Autowired
    private NewsDao newsDao;


    public List<News> findByUserId(Integer id) {

        return newsDao.findByUserId(id);
    }

    public void update(Integer id) {
        newsDao.update(id);

    }

    public void delete(Integer id) {

        newsDao.delete(id);
    }


}
