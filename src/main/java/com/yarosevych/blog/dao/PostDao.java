package com.yarosevych.blog.dao;

import com.yarosevych.blog.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final PostRowMapper POST_ROW_MAPPER = new PostRowMapper();

    public void addPost(Post post) throws SQLException {
        String sql = "CALL addPost(?,?,?)";
        jdbcTemplate.update(sql, new Object[]{post.getTopic(),
                post.getBody(),
                post.getUser().getNickname()});
    }

    public Post getPost(Integer id) throws SQLException {
        String sql = "CALL getPostAndUser(" + id +")";
        return jdbcTemplate.query(sql, POST_ROW_MAPPER).get(0);
    }

    public List<Post> getAllPosts() throws SQLException {
        String sql = "CALL getAllPosts()";
        return jdbcTemplate.query(sql, POST_ROW_MAPPER);
    }

    public List<Post> getPostsByUser(Integer userId) throws SQLException {
        String sql = "CALL getPostsByUser(" + userId + ")";
        return jdbcTemplate.query(sql, POST_ROW_MAPPER);
    }
}
