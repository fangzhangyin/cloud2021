package com.main.Service.imp;


import com.main.DAO.UserDAO;
import com.main.Entity.User;
import com.main.Service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImp implements UserService {
    @Resource
    private UserDAO userDAO;

    public int create(User user) {
        return userDAO.create(user);
    }

    public User Byid(int id) {
        return userDAO.Byid(id);
    }
}
