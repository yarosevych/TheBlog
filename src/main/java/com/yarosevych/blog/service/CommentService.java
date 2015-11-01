package com.yarosevych.blog.service;

import com.yarosevych.blog.dao.CommentDao;
import com.yarosevych.blog.domain.Comment;
import com.yarosevych.blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {

    @Autowired
    CommentDao commentDao;



    public static final String BODY = "body";
    public static final String POST_ID = "postId";
    public static final String NICKNAME = "nickname";

    public List<Comment> getAllComments(Integer postId) throws SQLException {
        return commentDao.getAllComments(postId);
    }

    public void addComment(Map <String, Object> parsedComment) throws SQLException {
        User user = new User((String)parsedComment.get(NICKNAME));
        Comment comment = new Comment();
        comment.setText(HtmlUtils.htmlEscape((String) parsedComment.get(BODY)));
        comment.setPostId((Integer) parsedComment.get(POST_ID));
        comment.setUser(user);
        commentDao.addComment(comment);
    }

    public void deleteComment(Integer commentId) throws SQLException {
        commentDao.deleteComment(commentId);
    }
}
