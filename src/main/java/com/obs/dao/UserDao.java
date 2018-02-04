package com.obs.dao;

import com.obs.Entities.User;

import java.util.List;

public interface UserDao {

    List<User> listAllUsers();
    boolean deleteUser (User user);
    boolean saveOrUpdateUser(User user);
}
