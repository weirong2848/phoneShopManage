package com.service;

import com.entity.User;

import java.util.List;

public interface IUserService {

    List<User> slectUser();

    User selectUserByUsername(String username);

    void addUser(User user);

    void updateUser(User user);

    User selectUserByEmail(String email);
}
