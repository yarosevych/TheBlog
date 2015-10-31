package com.yarosevych.blog.web;

import com.yarosevych.blog.domain.Post;
import com.yarosevych.blog.domain.User;
import com.yarosevych.blog.service.PostService;
import com.yarosevych.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String getAllPosts(Map<String, Object> map) throws SQLException{
        List<Post> posts= postService.getAllPosts();
        List<Post> escapedPosts = new ArrayList<>();
        for(Post post : posts) {
            post.setTopic(HtmlUtils.htmlEscape(post.getTopic()));
            post.setBody(HtmlUtils.htmlEscape(post.getBody()));
            escapedPosts.add(post);
        }
        map.put("postList", escapedPosts);
        map.put("post", new Post());
        return "home";
    }
}
