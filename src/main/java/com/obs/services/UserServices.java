package com.obs.services;

import com.obs.Entities.User;

import java.util.List;

public interface UserServices {

    //List<User> listAllUsers();
    boolean deleteUser (User user);
    boolean saveOrUpdateUser(User user);
    User getUser(String userId);
}
