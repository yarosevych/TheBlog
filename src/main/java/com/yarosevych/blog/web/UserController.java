package com.yarosevych.blog.web;

import com.yarosevych.blog.domain.Post;
import com.yarosevych.blog.domain.User;
import com.yarosevych.blog.service.PostService;
import com.yarosevych.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private PostService postService;

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/user={userId}")
    public String getPostsByUser(@PathVariable Integer userId, Model model) throws SQLException {
        model.addAttribute("user", userService.getUserById(userId));
        model.addAttribute("posts", postService.getPostsByUser(userId));
        model.addAttribute("post", new Post());
        return "user";
    }

    @RequestMapping("/users")
    public String getAllUsers(Model model) throws SQLException {
        List<User> users = userService.getallUsers();
        model.addAttribute("users", users);
        return "users";
    }
}
