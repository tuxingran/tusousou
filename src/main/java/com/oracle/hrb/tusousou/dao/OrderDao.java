package com.oracle.hrb.tusousou.dao;

import com.oracle.hrb.tusousou.pojo.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    List<Order> findByUserId(Integer id);

    void add(Order order);

    void delete(Integer id);

    void accept(Integer id);


}
