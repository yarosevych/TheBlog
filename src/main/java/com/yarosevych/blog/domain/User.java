package com.yarosevych.blog.domain;


public class User {
    private Integer id;
    private String nickname;

    public User() {
    }

    public User(String nickname) {
        this.nickname = nickname;
    }

    public User(Integer id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
