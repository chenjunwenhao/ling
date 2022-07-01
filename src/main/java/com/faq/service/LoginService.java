package com.faq.service;

import com.faq.entity.User;

import java.util.List;

public interface LoginService {
    public abstract List<User> getUser(User user);
    public int insertUser(User user);
    public int updateUser(User user);
    public int deleteUser(User user);
    public User getUserById(User user);
    public int getUserCountByTel(User user);
    public int updatePasswoed(User user);
}
