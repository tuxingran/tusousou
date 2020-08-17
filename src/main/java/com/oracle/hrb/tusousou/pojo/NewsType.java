package com.oracle.hrb.tusousou.pojo;

import java.io.Serializable;

public class NewsType implements Serializable {


    private Integer id;
    private String context2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContext2() {
        return context2;
    }

    public void setContext2(String context2) {
        this.context2 = context2;
    }

    @Override
    public String toString() {
        return "NewsType{" +
                "id=" + id +
                ", context2='" + context2 + '\'' +
                '}';
    }

    public NewsType(Integer id) {
        this.id = id;
    }

    public NewsType() {
    }
}
