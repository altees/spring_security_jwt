package com.user.mangment.service;

import com.user.mangment.entities.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);

    List<User> getAllUser();

}
