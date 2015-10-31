package com.yarosevych.blog.service;

import com.yarosevych.blog.dao.PostDao;
import com.yarosevych.blog.dao.UserDao;
import com.yarosevych.blog.domain.Post;
import com.yarosevych.blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class PostService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PostDao postDao;

    public static final String NICKNAME = "nickname";
    public static final String TOPIC = "topic";
    public static final String BODY = "body";

    public void addPost(Map<String, String> userAndPost) throws SQLException {
        User user = new User(userAndPost.get(NICKNAME));
        String topic = userAndPost.get(TOPIC);
        String body = userAndPost.get(BODY);
        Post post = new Post(topic, body, user);
        postDao.addPost(post);
    }

    public Post getPost(Integer id) throws SQLException {
        return postDao.getPost(id);
    }

    public List<Post> getAllPosts() throws SQLException {
        return postDao.getAllPosts();
    }

    public List<Post> getPostsByUser(Integer id) throws SQLException {
        return postDao.getPostsByUser(id);
    }
}
