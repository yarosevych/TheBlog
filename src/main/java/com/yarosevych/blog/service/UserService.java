package com.yarosevych.blog.service;

import com.yarosevych.blog.dao.UserDao;
import com.yarosevych.blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public void addUser(String nickname) throws SQLException {
        userDao.addUser(nickname);
    }

    public List<User> getallUsers() throws SQLException {
        return userDao.getAllUsers();
    }
}
