package com.yarosevych.blog.web;

import com.yarosevych.blog.domain.Post;
import com.yarosevych.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String getAllPosts(Map<String, Object> map) throws SQLException {
        List<Post> posts = postService.getAllPosts();
        map.put("postList", posts);
        return "home";
    }
}
