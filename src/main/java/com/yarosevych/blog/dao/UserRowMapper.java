package com.yarosevych.blog.dao;

import com.yarosevych.blog.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    private static final String ID = "id";
    private static final String NICKNAME = "nickname";

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt(ID));
        user.setNickname(resultSet.getString(NICKNAME));
        return user;
    }
}
