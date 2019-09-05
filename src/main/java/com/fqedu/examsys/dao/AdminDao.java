package com.fqedu.examsys.dao;


import com.fqedu.examsys.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AdminDao {
    /**
     * 根据登陆时用户的账号获取数据库中的所有信息
     * @param account 用户账号
     * @return 返回值 Admin对象
     */
    public Admin findByAccount(String account);

    /**
     * 根据登陆时的用户账号获取用户角色信息
     * @param account
     * @return
     */
    public List<String> findRoleAccount(String account);

    /**
     * 根据登陆时的用户账号获取用户权限信息
     * @param account
     * @return
     */
    public List<String> findPermAccount(String account);

    /**
     * 根据前端传入的 账号 姓名 角色名称 进行查询所有信息
     * @param account 账号
     * @param admName 姓名
     * @param roleName 角色名称
     * @return 返回 List集合
     */
    public List<Admin> findAdminAll(@Param("account") String account, @Param("admName") String admName, @Param("roleName") String roleName);

    /**
     * 根据 id删除用户信息
     * @param id 用户 id
     */
    public void deleteAdmin(Integer id);

    /**
     * 批量删除
     * @param idArr
     * @return
     */
    public Integer deleteManyAdmin(int[] idArr);

    /**
     * 根据 id查询一个人的信息
     * @param id 用户id
     */
    public Admin findById(Integer id);

    /**
     * 根据 id修改个人信息
     * @param admin
     */
    public void updateAdmin(Admin admin);

    /**
     * 修改密码
     * @param password
     */
    public void updatePassword(@Param("password") String password, @Param("id") Integer id);

    /**
     * 查询密码
     * @param password
     */
    public Admin findPassword(String password);

    /**
     * 添加用户
     * @param
     */
    public void addAdmin(Map<String, Object> data);

    /**
     * 查询一个用户的所有信息
     * @return
     */
    public Admin findAdmin();

}