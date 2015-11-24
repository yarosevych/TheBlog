package com.yarosevych.blog.dao;

import com.sun.xml.internal.bind.v2.TODO;
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

//    TODO: 1. Switch to stored procedure in the whole class.
    public User getUserById(Integer id) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Integer userId = resultSet.getInt(1);
            String nickname = resultSet.getString(2);
            return new User(userId, nickname);
        } finally {
            connection.close();
        }


    }

    public List<User> getAllUsers() throws SQLException {
        Connection connection = dataSource.getConnection();
        List<User> users = new ArrayList<>();
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
