package com.yarosevych.blog.web;

import com.yarosevych.blog.service.PostService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;

import static com.yarosevych.blog.util.JsonParser.parsePost;

@Controller
public class PostFormController {

    @Autowired
    private PostService postService;

    @RequestMapping("/newPost")
    public String displayPostForm() {
        return "postForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addPost/add")
    public String addPost(HttpServletRequest request) throws IOException, SQLException {
        String json = IOUtils.toString(request.getInputStream(), Charset.forName("UTF-8"));
        postService.addPost(parsePost(json));
        return "home";

    }
}
