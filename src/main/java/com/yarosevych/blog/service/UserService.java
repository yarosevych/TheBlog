package com.yarosevych.blog.service;

import com.yarosevych.blog.dao.UserDao;
import com.yarosevych.blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void addUser(String nickname) throws SQLException {
        userDao.addUser(HtmlUtils.htmlEscape(nickname));
    }

    public User getUserById(Integer id) throws SQLException {
        return userDao.getUserById(id);
    }

    public List<User> getallUsers() throws SQLException {
        return userDao.getAllUsers();
    }
}
