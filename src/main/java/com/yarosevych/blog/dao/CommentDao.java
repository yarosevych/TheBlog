package com.yarosevych.blog.dao;

import com.yarosevych.blog.domain.Comment;
import com.yarosevych.blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CommentDao {

    @Autowired
    DataSource dataSource;

    public void addComment(Comment comment) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL addComment (?,?,?)");
            callableStatement.setString(1, comment.getText());
            callableStatement.setInt(2, comment.getPostId());
            callableStatement.setString(3, comment.getUser().getNickname());
            callableStatement.executeUpdate();
        } finally {
            connection.close();
        }
    }

    public void deleteComment(Integer id) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL deleteComment(?)");
            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();
        } finally {
            connection.close();
        }
    }

    public List<Comment> getAllComments(Integer postId) throws SQLException {
        List<Comment> comments = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL getCommentsForPost(?)");
            callableStatement.setInt(1, postId);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(4));
                user.setNickname(resultSet.getString(5));
                Comment comment = new Comment();
                comment.setId(resultSet.getInt(1));
                comment.setText(resultSet.getString(2));
                comment.setCommentDateTime(resultSet.getTimestamp(3));
                comment.setUser(user);
                comment.setPostId(postId);
                comments.add(comment);
            }
            return comments;
        } finally {
            connection.close();
        }
    }
}
