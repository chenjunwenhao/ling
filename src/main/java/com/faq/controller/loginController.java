package com.faq.controller;

import com.faq.entity.User;
import com.faq.service.LoginService;
import com.faq.utils.Cors;
import com.faq.utils.MD5Util;
import com.faq.utils.RedisUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("/login")
public class loginController extends Cors{

    @Autowired
    private LoginService loginService;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/getUser")
    public PageInfo<User> getUsers(User user,Integer pageIndex,Integer pageSize){
        //redisUtil.lSet("uname",0,"aaa");
        //redisUtil.incrBy("num",1);
        //System.out.print(redisUtil.get("num")+"=====================================================");
        List<User> list = new ArrayList<>();
        Page<User> page = PageHelper.startPage(pageIndex,pageSize);
        list =loginService.getUser(user);
        PageInfo<User> pageInfo= new PageInfo<User>(list);
        return pageInfo;
    }
    @RequestMapping("/getUserById")
    public User getUserById(User user){
        User userById = loginService.getUserById(user);
        return userById;
    }
    @RequestMapping("/registe")
    public String registe(User user){
        if(user.getId()!=null){
            loginService.updateUser(user);
            return "update";
        }
        int isExist = loginService.getUserCountByTel(user);
        if(isExist==1){
            return "exist";
        }
        int s;
        user.setPwd(MD5Util.getMD5("123"));
        user.setStatus("user");
        s = loginService.insertUser(user);
        if(s==1){
            return "success";
        }else{
            return "fail";
        }
    }
    @RequestMapping("delete")
    public String delete(User user){
        int isDelete = loginService.deleteUser(user);
        if(isDelete==1){
            return "success";
        }else {
            return "fail";
        }
    }
    @RequestMapping("/approval")
    public String approval(User user){
        user = loginService.getUserById(user);
        user.setStatus("user");
        int s;
        s= loginService.updateUser(user);
        if(s==1){
            return "success";
        }else{
            return "fail";
        }
    }
    @RequestMapping("/login")
    public User login(User user){
        user.setPwd(MD5Util.getMD5(user.getPwd()));
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        if(user.getTel().equals("admin")&&user.getPwd().equals(MD5Util.getMD5("admin"))){
            User userlogin = new User();
            //userlogin.setToken(MD5Util.getMD5(token));
            userlogin.setStatus("admin");
            return userlogin;
        }
        User userlogin = loginService.getUserById(user);
        if(userlogin==null){
            return null;
        }else{
            userlogin.setToken(MD5Util.getMD5(token));
            return userlogin;
        }
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    @RequestMapping("/updatePassword")
    public String updatePassword(User user){
        user.setPwd(MD5Util.getMD5(user.getPassword()));
        int isUpdatePass = loginService.updatePasswoed(user);
        if(isUpdatePass == 1){
            return "success";
        }
          return "fail";
    }
    @RequestMapping("/resetPassword")
    public String resetPassword(User user){
        user.setPwd(MD5Util.getMD5("123"));
        int isUpdatePass = loginService.updatePasswoed(user);
        if(isUpdatePass == 1){
            return "success";
        }
        return "fail";
    }
}
