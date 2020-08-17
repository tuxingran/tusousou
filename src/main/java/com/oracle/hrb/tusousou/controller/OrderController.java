package com.oracle.hrb.tusousou.controller;

import com.oracle.hrb.tusousou.pojo.Address;
import com.oracle.hrb.tusousou.pojo.Order;
import com.oracle.hrb.tusousou.pojo.Result;
import com.oracle.hrb.tusousou.pojo.User;
import com.oracle.hrb.tusousou.service.AddressService;
import com.oracle.hrb.tusousou.service.OrderService;
import com.oracle.hrb.tusousou.service.UserService;
import com.oracle.hrb.tusousou.util.GetDate;
import com.oracle.hrb.tusousou.util.GetString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/order")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;

    @RequestMapping("/findByUserId.do")
    public Result findByUserId(HttpSession session) {
        Result result = new Result();
        User user = (User) session.getAttribute("user");
        Integer id = user.getId();
        List<Order> orders = orderService.findByUserId(id);
        result.addMap("orders", orders);
        return result;

    }

    @RequestMapping("/accept.do")
    public Result accept(int id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();
        Result result = new Result();
        orderService.accept(id, userId);
        return result;


    }

    @RequestMapping("/delete.do")
    public Result delete(Integer id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();
        Result result = new Result();
        orderService.delete(id, userId,user);
        return result;
    }

    @RequestMapping("/getUserAndAddress.do")
    public Result getUserAndAddress(HttpSession session) {
        Result result = new Result();
        User user = (User) session.getAttribute("user");
        List<Address> addresses = addressService.findByUserId(user.getId());
        result.addMap("user", user);
        result.addMap("addresses", addresses);
        return result;

    }

    @RequestMapping("/getUserByPhone.do")
    public Result getUserByPhone(String phone) {
        Result result = new Result();
        User user = userService.findByPhone(phone);
        if (user == null) {
            result.setOk(false);
            return result;
        }
        List<Address> addresses = addressService.findByUserId(user.getId());
        result.addMap("user", user);
        result.addMap("addresses", addresses);
        return result;

    }

    @RequestMapping("/add.do")
    public Result add(String t_phone, HttpSession session, Integer sendAddress, Integer weight, Integer t_address, Integer To, String goods, double finprice, int sousou) {
        Result result = new Result();
        User to = userService.findByPhone(t_phone);
        if (to == null) {
            result.setOk(false);
            result.setMsg("1");
            return result;
        }
        Order order = new Order();
        order.setDate(GetDate.getDate());
        order.setGoods(goods);
        order.setNum(GetString.getString());
        order.setSender((User) session.getAttribute("user"));
        order.setTo(to);
        Address toAddress = new Address();
        toAddress.setId(t_address);
        order.setToAddress(toAddress);
        Address send = new Address();
        send.setId(sendAddress);
        order.setSenderAddress(send);
        order.setWeight(weight);
        order.setPrice(finprice);
        int flag = orderService.add(order, finprice, sousou);
        if (flag == 2) {
            result.setOk(false);
            result.setMsg("2");
            return result;
        }
        if (flag == 3) {
            result.setOk(false);
            result.setMsg("3");
            return result;
        }
        return result;

    }


}
