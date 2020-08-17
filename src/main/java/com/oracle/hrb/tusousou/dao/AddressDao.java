package com.oracle.hrb.tusousou.dao;

import com.oracle.hrb.tusousou.pojo.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDao {

    void add(Address address);

    void update(Address address);

    void delete(Integer id);

    Address findById(Integer id);

    List<Address> findAll();

    List<Address> findByUserId(Integer id);


}
