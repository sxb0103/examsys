package com.fqedu.examsys.service.impl;

import com.fqedu.examsys.dao.UserDao;
import com.fqedu.examsys.entity.User;
import com.fqedu.examsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User LoginUser(String userName, String password) {

        User user = userDao.findByUserName(userName);


        if (userName == "") {
            throw new RuntimeException("账号不能为空");
        }
        if (password == "") {
            throw new RuntimeException("密码不能为空");
        }
        if (user == null) {
            throw new RuntimeException("账号错误");
        }

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("账号或者密码错误");
        }


        return user;

    }

    @Override
    public void addUser(String account, String userName, String password, String address, String phone) {
        User user1 = userDao.findOneUser();
        if (user1.getAccount().equals(account)) {
            throw new RuntimeException("账号已存在");
        }
        userDao.addUser(account, userName, password, address, phone);
    }
}
