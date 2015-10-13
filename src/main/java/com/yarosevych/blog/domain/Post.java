package com.yarosevych.blog.domain;

import java.util.Date;

public class Post {
    private Integer id;
    private String topic;
    private String body;
    private Date postDateTime;
    private Integer userId;

    public Post(){}

    public Post(String topic, String body) {
        this.topic = topic;
        this.body = body;
    }

    public Post(Integer id, String topic, String body, Date postDateTime, Integer userId) {
        this.id = id;
        this.topic = topic;
        this.body = body;
        this.postDateTime = postDateTime;
        this.userId = userId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
