package com.fqedu.examsys.service;

import com.fqedu.examsys.entity.Admin;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Map;

public interface AdminService {

    /**
     * 登陆
     *
     * @param account
     * @param password
     * @return
     */
    public Admin LoginAdmin(String account, String password);

    /**
     * 添加用户
     *
     * @param
     */
    public void addAdmin(String account, String admName, String password, Integer rid);

    /**
     * 用户管理 分页展示
     *
     * @param account  账号
     * @param admName  姓名
     * @param roleName 角色名称
     * @param limit    从第几行开始展示
     * @param page     页数
     * @return 返回 Map
     */
    public List<Admin> findByPage(String account, String admName, String roleName, Integer limit, Integer page);

    /**
     * 删除用户信息
     *
     * @param id 用户 id
     */
    public void deleteAdmin(Integer id);

    /**
     * 批量删除
     *
     * @param idArr
     */
    public Integer deleteManyAdmin(int[] idArr);

    /**
     * 查询一个人的所有信息
     *
     * @param id 用户 id
     * @return
     */
    public Admin findById(Integer id);

    /**
     * 修改信息
     * @param admin
     */
    public void updateAdmin(Admin admin);

    /**
     * 修改密码
     * @param password
     */
    public void updatePassword(String password, Integer id);

    /**
     * 查询个人的所有信息
     * @return
     */
    public Admin findAdmin();

}
