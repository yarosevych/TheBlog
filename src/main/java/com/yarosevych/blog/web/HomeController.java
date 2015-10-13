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
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @RequestMapping("/posts")
    public String getAllPosts(Map<String, Object> map) throws SQLException{
        List<Post> escapedPosts = postService.getAllPosts();
        for(Post post : escapedPosts) {
            post.setTopic(HtmlUtils.htmlEscape(post.getTopic()));
            post.setBody(HtmlUtils.htmlEscape(post.getBody()));
        }
        map.put("postList", escapedPosts);
        map.put("post", new Post());

        List<User> escapedUsers = userService.getallUsers();
        for(User user : escapedUsers) {
            user.setNickname(HtmlUtils.htmlEscape(user.getNickname()));
        }
        map.put("userList", escapedUsers);
        map.put("user", new User());
        return "home";
    }

}
