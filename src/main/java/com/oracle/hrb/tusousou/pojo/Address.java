package com.oracle.hrb.tusousou.pojo;

import java.io.Serializable;

public class Address   implements Serializable {
    private Integer id;
    private User user;
    private String name;
    private String phone;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Address(Integer id, User user, String name, String phone, String address) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Address(User user, String name, String phone, String address) {
        this.user = user;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
