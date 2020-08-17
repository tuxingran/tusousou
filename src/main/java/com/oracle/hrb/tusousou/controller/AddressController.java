package com.oracle.hrb.tusousou.controller;

import com.oracle.hrb.tusousou.pojo.Address;
import com.oracle.hrb.tusousou.pojo.Result;
import com.oracle.hrb.tusousou.pojo.User;
import com.oracle.hrb.tusousou.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/address")
@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;


    @RequestMapping("/findByUserId.do")
    public Result findByUserId(HttpSession session) {

        Result result = new Result();

        User user = (User) session.getAttribute("user");
        Integer id = user.getId();
        List<Address> addresses = addressService.findByUserId(id);
        result.addMap("addresses", addresses);
        return result;

    }

    @RequestMapping("/add.do")
    public Result add(Address address, HttpSession session) {
        Result result = new Result();
        User user = (User) session.getAttribute("user");
        address.setUser(user);
        addressService.add(address);
        result.addMap("address", address);
        return result;


    }

    @RequestMapping("/delete.do")
    public Result delete(Integer id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Result result = new Result();
        addressService.delete(id,user);
        return result;
    }

    @RequestMapping("/update.do")
    public Result update(HttpSession session, Address address) {
        Result result = new Result();
        User user = (User) session.getAttribute("user");
        address.setUser(user);
        addressService.update(address);
        return result;


    }

}
