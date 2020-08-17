package com.oracle.hrb.tusousou.controller;


import com.oracle.hrb.tusousou.pojo.News;
import com.oracle.hrb.tusousou.pojo.Result;
import com.oracle.hrb.tusousou.pojo.User;
import com.oracle.hrb.tusousou.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;


    @RequestMapping("/findByUserId.do")
    public Result findByUserId(HttpSession session) {
        Result result = new Result();
        User user = (User) session.getAttribute("user");
        Integer id = user.getId();
        List<News> news = newsService.findByUserId(id);
        result.addMap("news", news);
        return result;


    }

    @RequestMapping("/delete.do")
    public Result delete(Integer id) {
        Result result = new Result();
        newsService.delete(id);
        return result;


    }

    @RequestMapping("/update.do")
    public Result update(Integer id) {

        Result result = new Result();
        newsService.update(id);
        return result;
    }


}
