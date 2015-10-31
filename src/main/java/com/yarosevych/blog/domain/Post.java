package com.yarosevych.blog.domain;

import java.util.Date;

public class Post {
    private Integer id;
    private String topic;
    private String body;
    private Date postDateTime;
    private User user;

    public Post(){}

    public Post(String topic, String body, User user) {
        this.topic = topic;
        this.body = body;
        this.user = user;
    }

    public Post(Integer id, String topic, String body, Date postDateTime, User user) {
        this.id = id;
        this.topic = topic;
        this.body = body;
        this.postDateTime = postDateTime;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getPostDateTime() {
        return postDateTime;
    }

    public void setPostDateTime(Date postDateTime) {
        this.postDateTime = postDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
