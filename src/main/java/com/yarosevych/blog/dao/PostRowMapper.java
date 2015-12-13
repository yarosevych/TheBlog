package com.yarosevych.blog.dao;

import com.yarosevych.blog.domain.Post;
import com.yarosevych.blog.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostRowMapper implements RowMapper<Post> {
    private final String ID = "id";
    private final String TOPIC = "topic";
    private final String BODY = "BODY";
    private final String DATE_TIME = "postDateTime";
    private final String USER_ID = "userId";
    private final String NICKNAME = "nickname";

    @Override
    public Post mapRow(ResultSet resultSet, int i) throws SQLException {
        Integer id = resultSet.getInt(ID);
        String topic = resultSet.getString(TOPIC);
        String body = resultSet.getString(BODY);
        java.util.Date dateTime = resultSet.getTimestamp(DATE_TIME);
        Integer userId = resultSet.getInt(USER_ID);
        String nickname = resultSet.getString(NICKNAME);
        User user = new User(userId, nickname);
        Post post = new Post(id, topic, body, dateTime, user);
        return post;
    }
}
