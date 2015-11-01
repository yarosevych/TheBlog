package com.yarosevych.blog.web;

import com.yarosevych.blog.domain.Post;
import com.yarosevych.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.apache.commons.io.IOUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;

import static com.yarosevych.blog.util.JsonParser.*;

@Controller
public class PostFormController {

    @Autowired
    PostService postService;

    @RequestMapping("/newPost")
    public String displayPostForm(){
        return "postForm";
    }

    @RequestMapping(method=RequestMethod.GET, value = "/posts", params="new")
    public String createPost(Model model) {
        model.addAttribute("post", new Post());
        return "postForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addPost/add")
    public String addPost(HttpServletRequest request) throws IOException, SQLException {
        String json = IOUtils.toString(request.getInputStream(), Charset.forName("UTF-8"));
        postService.addPost(parseAddPost(json));
        return "home";
    }

}
