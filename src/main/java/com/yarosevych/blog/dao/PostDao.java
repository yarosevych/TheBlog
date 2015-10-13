package com.yarosevych.blog.dao;

import com.yarosevych.blog.domain.Post;
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
public class PostDao {

    @Autowired
    DataSource dataSource;

    public void addPost(Post post) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO posts (topic, body, postDateTime, userId) values (?,?,NOW(),?)");
        preparedStatement.setString(1, post.getTopic());
        preparedStatement.setString(2, post.getBody());
        preparedStatement.setInt(3, post.getUserId());
        preparedStatement.executeUpdate();
        if (connection != null) {
            connection.close();
        }
    }

    public Post getPost(Integer id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM posts WHERE id=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (connection != null) {
            connection.close();
        }
        return new Post(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                resultSet.getTimestamp(4), resultSet.getInt(5));
    }

    public List<Post> getAllPosts() throws SQLException {
        List<Post> posts = new ArrayList<Post>();
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM posts");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            posts.add(new Post(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                    resultSet.getTimestamp(4), resultSet.getInt(5)));
        }
        if (connection != null) {
            connection.close();
        }
        return posts;
    }

    public List<Post> getPostsByUser(Integer userId) throws SQLException {
        List<Post> posts = new ArrayList<Post>();
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM posts WHERE userId=?");
        preparedStatement.setInt(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            posts.add(new Post(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                    resultSet.getTimestamp(4), resultSet.getInt(5)));
        }
        if (connection != null) {
            connection.close();
        }
        return posts;
    }
}
