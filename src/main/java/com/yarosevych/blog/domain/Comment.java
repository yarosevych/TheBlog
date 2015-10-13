package com.yarosevych.blog.domain;

import java.util.Date;

public class Comment {
    private Integer id;
    private String text;
    private Date commentDateTime;
    private Integer userId;
    private Integer postId;

    public Comment(){}

    public Comment(Integer id, String text, Date commentDateTime, Integer userId, Integer postId) {
        this.id = id;
        this.text = text;
        this.commentDateTime = commentDateTime;
        this.userId = userId;
        this.postId = postId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }
}
