package com.faq.mapper;

import com.faq.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginDao {
    public List<User> getUser(User user);
    public User getUserById(User user);
    public int insertUser(User user);
    public int updateUser(User user);
    public int deleteUser(User user);
    public int getUserCountByTel(User user);
    public int updatePasswoed(User user);
}
