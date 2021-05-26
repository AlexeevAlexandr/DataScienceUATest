package com.DataScienceUATest.service;

import com.DataScienceUATest.model.User;

import java.util.List;

public interface UserService {

    boolean isPresent(int id);

    User getUser(int id);

    List<User> getUsers();

    User createUser(User user);

    User updateUser(User user);
}
