package com.obs.dao;

import com.obs.Entities.User;

import java.util.List;

public interface UserDao {

    //List listAllUsers();
    boolean deleteUser (User user);
    boolean saveOrUpdateUser(User user);
    User getUser(String userId);
}
