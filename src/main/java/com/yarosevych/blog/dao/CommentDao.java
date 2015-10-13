package com.yarosevych.blog.dao;

import com.yarosevych.blog.domain.Comment;
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
public class CommentDao {
    @Autowired
    DataSource dataSource;

    public void addComment(Comment comment) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO posts (text, commentDateTime, postId, userId) values (?,NOW(),?,?)");
        preparedStatement.setString(1, comment.getText());
        preparedStatement.setInt(2, comment.getPostId());
        preparedStatement.setInt(3, comment.getUserId());
        preparedStatement.executeUpdate();
        if (connection != null) {
            connection.close();
        }
    }

    public void deleteComment(Integer id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE * FROM comments WHERE id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        if (connection != null) {
            connection.close();
        }
    }

    public List<Comment> getAllComments(Integer postId) throws SQLException {
        List<Comment> comments = new ArrayList<Comment>();
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM comments WHERE postId=?");
        preparedStatement.setInt(1, postId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            comments.add(new Comment(resultSet.getInt(1), resultSet.getString(2), resultSet.getTimestamp(3),
                    resultSet.getInt(4), resultSet.getInt(5)));
        }
        if (connection != null) {
            connection.close();
        }
        return comments;
    }
}
