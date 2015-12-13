package com.yarosevych.blog.dao;

import com.yarosevych.blog.domain.Comment;
import com.yarosevych.blog.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentRowMapper implements RowMapper<Comment> {

    private final String ID = "id";
    private final String BODY = "body";
    private final String DATE_TIME = "commentDateTime";
    private final String USER_ID = "userId";
    private final String NICKNAME = "nickname";
    private final String POST_ID = "postId";

    @Override
    public Comment mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt(USER_ID));
        user.setNickname(resultSet.getString(NICKNAME));
        Comment comment = new Comment();
        comment.setId(resultSet.getInt(ID));
        comment.setText(resultSet.getString(BODY));
        comment.setCommentDateTime(resultSet.getTimestamp(DATE_TIME));
        comment.setPostId(resultSet.getInt(POST_ID));
        comment.setUser(user);
        return comment;
    }
}
