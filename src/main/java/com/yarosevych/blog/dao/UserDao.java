package com.yarosevych.blog.dao;

import com.yarosevych.blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        if (connection != null) {
            connection.close();
        }
    }


    public User getUserById(Integer id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM users WHERE id=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (connection != null) {
            connection.close();
        }
        return new User(resultSet.getInt(1), resultSet.getString(2));
    }

    public User getUserByNick(String nickname) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM users WHERE nickname=?");
        preparedStatement.setString(1, nickname);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (connection != null) {
            connection.close();
        }
        if (!resultSet.next()) {  //also returns false if there are no rows in the ResultSet
            return null;
        } else {
            return new User(resultSet.getInt(1), resultSet.getString(2));
        }
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
        return users;
    }
}
