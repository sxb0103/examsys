package com.fqedu.examsys.service;

import com.fqedu.examsys.entity.User;

public interface UserService {


    /**
     * 前端页面登陆
     *
     * @param userName
     * @param password
     * @return
     */
    public User LoginUser(String userName, String password);

    /**
     * 注册
     * @param account
     * @param userName
     * @param password
     * @param address
     * @param phone
     */
    public void addUser(String account,
                        String userName,
                        String password,
                        String address,
                        String phone);
}
