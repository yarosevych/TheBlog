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
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO users (nickname) values (?)");
        preparedStatement.setString(1, nickname);
        preparedStatement.executeUpdate();
        connection.close();
    }

    public User getOrCreateUser(String nickname) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL createOrGetUser(?)");
            callableStatement.setString(1, nickname);
            ResultSet resultSet = callableStatement.executeQuery();
            User user = new User();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setNickname(nickname);
            }
            return user;
        } finally {
            connection.close();
        }
    }


    public User getUserById(Integer id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM users WHERE id=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
            connection.close();
        return new User(resultSet.getInt(1), resultSet.getString(2));
    }

    public List<User> getAllUsers() throws SQLException {
        Connection connection = dataSource.getConnection();
        List<User> users = new ArrayList<User>();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM users");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            users.add(new User(resultSet.getInt(1), resultSet.getString(2)));
        }
        connection.close();
        return users;
    }
}
