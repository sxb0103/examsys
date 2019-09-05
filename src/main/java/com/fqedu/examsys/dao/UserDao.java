package com.fqedu.examsys.dao;


import com.fqedu.examsys.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    /**
     * 根据登陆时用户的账号获取数据库中的所有信息
     * @param userName 用户名
     * @return 返回值 Admin对象
     */
    public User findByUserName(String userName);

    /**
     * 注册
     * @param account
     * @param userName
     * @param password
     * @param address
     * @param phone
     */
    public void addUser(@Param("account") String account,
                        @Param("userName") String userName,
                        @Param("password") String password,
                        @Param("address") String address,
                        @Param("phone") String phone);

    /**
     * 查询一个人的所有信息
     * @return
     */
    public User findOneUser();
}