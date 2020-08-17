package com.oracle.hrb.tusousou.pojo;

import java.io.Serializable;

public class User implements Serializable {

    private Integer id;
    private String name;
    private String password;
    private String sex;
    private String e_mail;
    private String phone;
    private double money;
    private int souMoney;
    private String touxiang;
    private String date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getSouMoney() {
        return souMoney;
    }

    public void setSouMoney(int souMoney) {
        this.souMoney = souMoney;
    }

    public String getTouxiang() {
        return touxiang;
    }

    public void setTouxiang(String touxiang) {
        this.touxiang = touxiang;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User(Integer id, String name, String password, String sex, String e_mail, String phone, double money, int souMoney, String touxiang, String date) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.e_mail = e_mail;
        this.phone = phone;
        this.money = money;
        this.souMoney = souMoney;
        this.touxiang = touxiang;
        this.date = date;
    }

    public User(String name, String password, String sex, String e_mail, String phone, double money, int souMoney, String touxiang, String date) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.e_mail = e_mail;
        this.phone = phone;
        this.money = money;
        this.souMoney = souMoney;
        this.touxiang = touxiang;
        this.date = date;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", phone='" + phone + '\'' +
                ", money=" + money +
                ", souMoney=" + souMoney +
                ", touxiang='" + touxiang + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
