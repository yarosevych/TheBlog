package com.yarosevych.blog.service;

import com.yarosevych.blog.dao.PostDao;
import com.yarosevych.blog.dao.UserDao;
import com.yarosevych.blog.domain.Post;
import com.yarosevych.blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class PostService {

    @Autowired
    UserDao userDao;

    @Autowired
    PostDao postDao;

    public void addPost(Map<String, String> nickAndPost) throws SQLException {
        String nickname = nickAndPost.get("nickname");
        Integer userId = userDao.getOrCreateUser(nickname);
        String topic = nickAndPost.get("topic");
        String body = nickAndPost.get("body");
        Post post = new Post(topic, body);
        post.setUserId(userId);
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
