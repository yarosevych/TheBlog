package com.yarosevych.blog.dao;

import com.yarosevych.blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private DataSource dataSource;

    public void addUser(String nickname) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL addUser(?)");
            callableStatement.setString(1, nickname);
            callableStatement.executeUpdate();
        } finally {
            connection.close();
        }
    }

    public User getUserById(Integer id) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL getUserById(?)");
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                Integer userId = resultSet.getInt(1);
                String nickname = resultSet.getString(2);
                return new User(userId, nickname);
            } else {
                return null;
            }
        } finally {
            connection.close();
        }
    }

    public List<User> getAllUsers() throws SQLException {
        Connection connection = dataSource.getConnection();
        List<User> users = new ArrayList<>();
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL getAllUsers()");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Integer userId = resultSet.getInt(1);
                String nickname = resultSet.getString(2);
                users.add(new User(userId, nickname));
            }
        } finally {
            connection.close();
        }
        return users;
    }
}
