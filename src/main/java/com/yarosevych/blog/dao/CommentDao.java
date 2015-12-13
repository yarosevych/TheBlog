package com.yarosevych.blog.dao;

import com.yarosevych.blog.domain.Comment;
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
public class CommentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final CommentRowMapper COMMENT_ROW_MAPPER = new CommentRowMapper();

    public void addComment(Comment comment) throws SQLException {
        String sql = "CALL addComment(?,?,?)";
        jdbcTemplate.update(sql, new Object[] {comment.getText(),
                comment.getPostId(),
                comment.getUser().getNickname()});
    }

    public void deleteComment(Integer id) throws SQLException {
        String sql = "CALL deleteComment(" + id + ")";
        jdbcTemplate.update(sql);
    }

    public List<Comment> getAllComments(Integer postId) throws SQLException {
        String sql = "CALL getCommentsForPost(" + postId + ")";
        return jdbcTemplate.query(sql, COMMENT_ROW_MAPPER);
    }
}
