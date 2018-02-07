package com.obs.services.impl;

import com.obs.Entities.User;
import com.obs.dao.UserDao;
import com.obs.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServicesImpl implements UserServices{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> listAllUsers() {
        return userDao.listAllUsers();
    }

    @Override
    public boolean deleteUser(User user) {
        return userDao.deleteUser(user);
    }

    @Override
    public boolean saveOrUpdateUser(User user) {
        return userDao.saveOrUpdateUser(user);
    }

    @Override
    public User getUser(String userId) {
        return userDao.getUser(userId);
    }

    @Override
    public User userLogin(String username, String pwd) {
        return userDao.userLogin(username,pwd);
    }
}
