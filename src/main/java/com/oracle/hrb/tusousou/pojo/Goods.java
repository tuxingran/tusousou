package com.oracle.hrb.tusousou.pojo;

import java.io.Serializable;

public class Goods implements Serializable {
    private Integer id;
    private String name;
    private String introduce;
    private Variety variety;
    private double price;
    private String photo;

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

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Variety getVariety() {
        return variety;
    }

    public void setVariety(Variety variety) {
        this.variety = variety;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Goods(Integer id, String name, String introduce, Variety variety, double price, String photo) {
        this.id = id;
        this.name = name;
        this.introduce = introduce;
        this.variety = variety;
        this.price = price;
        this.photo = photo;
    }

    public Goods() {
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                ", variety=" + variety +
                ", price=" + price +
                ", photo='" + photo + '\'' +
                '}';
    }
}
