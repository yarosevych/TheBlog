package com.yarosevych.blog.service;

import com.yarosevych.blog.dao.CommentDao;
import com.yarosevych.blog.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentDao commentDao;

    public List<Comment> getAllComments(Integer postId) throws SQLException {
        return commentDao.getAllComments(postId);
    }

    public void addComment(Comment comment) throws SQLException {
        commentDao.addComment(comment);
    }

    public void deleteComment(Integer commentId) throws SQLException {
        commentDao.deleteComment(commentId);
    }
}
