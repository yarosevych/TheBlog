package com.yarosevych.blog.dao;

import com.yarosevych.blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final UserRowMapper USER_ROW_MAPPER = new UserRowMapper();

    public void addUser(String nickname) throws SQLException {
        String sql = "CALL addUser(" + nickname + ")";
        jdbcTemplate.update(sql);
    }

    public User getUserById(Integer id) throws SQLException {
        String sql = "CALL getUserById(" + id + ")";
        return jdbcTemplate.query(sql, USER_ROW_MAPPER).get(0);
    }

    public List<User> getAllUsers() throws SQLException {
        String sql = "CALL getAllUsers()";
        return jdbcTemplate.query(sql, USER_ROW_MAPPER);
    }
}
