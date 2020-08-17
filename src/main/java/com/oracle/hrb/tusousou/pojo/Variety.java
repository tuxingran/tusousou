package com.oracle.hrb.tusousou.pojo;

import java.io.Serializable;

public class Variety implements Serializable {
    private Integer id;
    private String name;
    private String photo;
    private String photo2;


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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public Variety() {
    }

    @Override
    public String toString() {
        return "Variety{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", photo2='" + photo2 + '\'' +
                '}';
    }
}
