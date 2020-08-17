package com.oracle.hrb.tusousou.controller;


import com.oracle.hrb.tusousou.pojo.Result;
import com.oracle.hrb.tusousou.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/goods")
@RestController
public class GoodsController {


    @Autowired
    private GoodsService goodsService;


    @RequestMapping("/findByVarietyId.do")
    public Result findByVarietyId(Integer id) {
        Result result = new Result();
        result.addMap("goods", goodsService.findByVarietyId(id));
        return result;


    }


}
