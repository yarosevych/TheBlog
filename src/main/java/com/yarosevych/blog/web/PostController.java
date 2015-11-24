package com.yarosevych.blog.web;

import com.yarosevych.blog.domain.Comment;
import com.yarosevych.blog.service.CommentService;
import com.yarosevych.blog.service.PostService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;

import static com.yarosevych.blog.util.JsonParser.parseAddComment;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.GET, value="/postId={postId}")
    public String showPost(@PathVariable("postId") Integer postId, Model model) throws SQLException {
        model.addAttribute("post", postService.getPost(postId));
        model.addAttribute("commentsList", commentService.getAllComments(postId));
        model.addAttribute("comment", new Comment());
        return "post";
    }

    @RequestMapping(method = RequestMethod.POST, value="/deleteComment/{commentId}")
    public String deleteComment(@PathVariable("commentId") Integer commentId) throws SQLException {
        commentService.deleteComment(commentId);
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addComment/add")
    public String addComment(HttpServletRequest request) throws IOException, SQLException {
        String json = IOUtils.toString(request.getInputStream(), Charset.forName("UTF-8"));
        commentService.addComment(parseAddComment(json));
        return "home";
    }
}
