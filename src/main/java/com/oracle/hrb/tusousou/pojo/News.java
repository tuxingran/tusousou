package com.oracle.hrb.tusousou.pojo;

public class News {

    private Integer id;
    private String date;
    private NewsType newsType;
    private User user;
    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public NewsType getNewsType() {
        return newsType;
    }

    public void setNewsType(NewsType newsType) {
        this.newsType = newsType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public News(Integer id, String date, NewsType newsType, User user, String state) {
        this.id = id;
        this.date = date;
        this.newsType = newsType;
        this.user = user;
        this.state = state;
    }

    public News(String date, NewsType newsType, User user, String state) {
        this.date = date;
        this.newsType = newsType;
        this.user = user;
        this.state = state;
    }

    public News() {
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", newsType=" + newsType +
                ", user=" + user +
                ", state='" + state + '\'' +
                '}';
    }
}
