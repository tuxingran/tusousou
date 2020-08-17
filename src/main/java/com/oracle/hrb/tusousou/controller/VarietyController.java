package com.oracle.hrb.tusousou.controller;

import com.oracle.hrb.tusousou.pojo.Result;
import com.oracle.hrb.tusousou.service.AddressService;
import com.oracle.hrb.tusousou.service.PriceService;
import com.oracle.hrb.tusousou.service.VarietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping("/variety")
@RestController
public class VarietyController {
    @Autowired
    private AddressService addressService;

    @Autowired
    private PriceService priceService;


    @Autowired
    private VarietyService varietyService;

    @RequestMapping("/findAll.do")
    public Result findByUserId(HttpSession session) {

        Result result = new Result();

        result.addMap("varieties", varietyService.findAll());
        return result;

    }


}
