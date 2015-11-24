package com.yarosevych.blog.dao;

import com.yarosevych.blog.domain.Post;
import com.yarosevych.blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostDao {

    @Autowired
    private DataSource dataSource;

    public void addPost(Post post) throws SQLException {
        Connection connection = dataSource.getConnection();
        try{
            CallableStatement callableStatement = connection.prepareCall("CALL addPost(?,?,?)");
            callableStatement.setString(1, post.getTopic());
            callableStatement.setString(2, post.getBody());
            callableStatement.setString(3, post.getUser().getNickname());
            callableStatement.executeUpdate();
        } finally {
            connection.close();
        }
    }

    public Post getPost(Integer id) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL getPostAndUser(?)");
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                String topic = resultSet.getString(2);
                String body = resultSet.getString(3);
                java.util.Date dateTime = resultSet.getTimestamp(4);
                Integer userId = (resultSet.getInt(5));
                String nickname = (resultSet.getString(6));
                User user = new User(userId, nickname);
                Post post = new Post(id, topic, body, dateTime, user);
                return post;
            } else {
                return null;
            }
        } finally {
            connection.close();
        }
    }

    public List<Post> getAllPosts() throws SQLException {
        List<Post> posts = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL getAllPosts()");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Integer userId = resultSet.getInt(5);
                String nickname = resultSet.getString(6);
                User user = new User(userId, nickname);

                Integer id = resultSet.getInt(1);
                String topic = resultSet.getString(2);
                String body = resultSet.getString(3);
                java.util.Date dateTime = resultSet.getTimestamp(4);
                Post post = new Post(id, topic, body, dateTime, user);
                posts.add(post);
            }
            return posts;
        } finally {
            connection.close();
        }
    }

    public List<Post> getPostsByUser(Integer userId) throws SQLException {
        List<Post> posts = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL getPostsByUser(?)");
            callableStatement.setInt(1, userId);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String topic = resultSet.getString(2);
                String body = resultSet.getString(3);
                java.util.Date dateTime = resultSet.getTimestamp(4);
                String nickname = (resultSet.getString(5));
                User user = new User(userId, nickname);
                Post post = new Post(id, topic, body, dateTime, user);
                posts.add(post);
            }
            return posts;
        } finally {
            connection.close();
        }
    }
}
