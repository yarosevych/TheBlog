package com.yarosevych.blog.domain;

import java.util.Date;

public class Comment {
    private Integer id;
    private String text;
    private Date commentDateTime;
    private Integer postId;
    private User user;

    public Comment() {
    }

    public Comment(Integer id, String text, Date commentDateTime, Integer postId, User user) {
        this.id = id;
        this.text = text;
        this.commentDateTime = commentDateTime;
        this.postId = postId;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCommentDateTime() {
        return commentDateTime;
    }

    public void setCommentDateTime(Date commentDateTime) {
        this.commentDateTime = commentDateTime;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
