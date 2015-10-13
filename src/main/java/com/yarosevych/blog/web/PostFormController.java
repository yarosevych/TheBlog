package com.yarosevych.blog.web;

import com.yarosevych.blog.service.PostService;
import com.yarosevych.blog.util.BlogJsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;

import static com.yarosevych.blog.util.BlogJsonParser.*;

@Controller
public class PostFormController {

    @Autowired
    PostService postService;

    public String addPost(HttpServletRequest request) throws IOException, SQLException {
        String json = IOUtils.toString(request.getInputStream(), Charset.forName("UTF-8"));
        postService.addPost(parseAddPost(json));
        return "home";
    }

}
