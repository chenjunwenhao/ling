package com.faq.service.impl;

import com.faq.entity.User;
import com.faq.mapper.LoginDao;
import com.faq.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public List<User> getUser(User user){
        return loginDao.getUser(user);
    }
    @Override
    public int insertUser(User user){return loginDao.insertUser(user);}
    @Override
    public int updateUser(User user){return loginDao.updateUser(user);}
    @Override
    public int deleteUser(User user){return loginDao.deleteUser(user);}
    @Override
    public User getUserById(User user){return  loginDao.getUserById(user);}
    @Override
    public int getUserCountByTel(User user){return  loginDao.getUserCountByTel(user);}
    @Override
    public int updatePasswoed(User user){return loginDao.updatePasswoed(user);}
}
