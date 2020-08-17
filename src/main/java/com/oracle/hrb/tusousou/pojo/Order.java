package com.oracle.hrb.tusousou.pojo;

import java.io.Serializable;

public class Order implements Serializable {

    private Integer id;
    private String num;
    private String date;
    private String goods;
    private Integer weight;
    private double price;
    private User sender;
    private User to;
    private Address senderAddress;
    private Address ToAddress;
    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public Address getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(Address senderAddress) {
        this.senderAddress = senderAddress;
    }

    public Address getToAddress() {
        return ToAddress;
    }

    public void setToAddress(Address toAddress) {
        ToAddress = toAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Order(Integer id, String num, String date, String goods, Integer weight, double price, User sender, User to, Address senderAddress, Address toAddress, String state) {
        this.id = id;
        this.num = num;
        this.date = date;
        this.goods = goods;
        this.weight = weight;
        this.price = price;
        this.sender = sender;
        this.to = to;
        this.senderAddress = senderAddress;
        ToAddress = toAddress;
        this.state = state;
    }

    public Order(String num, String date, String goods, Integer weight, double price, User sender, User to, Address senderAddress, Address toAddress, String state) {
        this.num = num;
        this.date = date;
        this.goods = goods;
        this.weight = weight;
        this.price = price;
        this.sender = sender;
        this.to = to;
        this.senderAddress = senderAddress;
        ToAddress = toAddress;
        this.state = state;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", num='" + num + '\'' +
                ", date='" + date + '\'' +
                ", goods='" + goods + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", sender=" + sender +
                ", to=" + to +
                ", senderAddress=" + senderAddress +
                ", ToAddress=" + ToAddress +
                ", state=" + state +
                '}';
    }
}
