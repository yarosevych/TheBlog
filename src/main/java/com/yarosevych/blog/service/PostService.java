package com.yarosevych.blog.service;

import com.yarosevych.blog.dao.PostDao;
import com.yarosevych.blog.dao.UserDao;
import com.yarosevych.blog.domain.Post;
import com.yarosevych.blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
        User user = new User(HtmlUtils.htmlEscape(userAndPost.get(NICKNAME)));
        String topic = HtmlUtils.htmlEscape(userAndPost.get(TOPIC));
        String body = HtmlUtils.htmlEscape(userAndPost.get(BODY));
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
