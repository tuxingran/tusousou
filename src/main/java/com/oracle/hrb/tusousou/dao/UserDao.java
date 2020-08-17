package com.oracle.hrb.tusousou.dao;

import com.oracle.hrb.tusousou.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    void add(User user);

    void update(User user);

    void delete(Integer id);

    User findById(Integer id);

    List<User> findAll();

    User findByName(String name);

    User findByPhone(String phone);

    User findByEmail(String email);


}
