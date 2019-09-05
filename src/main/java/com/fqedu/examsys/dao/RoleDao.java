package com.fqedu.examsys.dao;

import com.fqedu.examsys.entity.Role;

import java.util.List;


public interface RoleDao {

    /**
     * 查找所有角色名称
     * @return
     */
    public List<Role> findRoleName();

    /**
     * 查询所有
     * @return
     */
    public List<Role> findRoleAll(String roleName);
    /**
     * 删除信息
     * @param rid
     */
    public void deleteRole(Integer rid);

    /**
     * 批量删除
     * @param idArr
     * @return
     */
    public Integer deleteManyRole(int[] idArr);

    /**
     * 根据 id查找角色表所有信息
     * @param rid
     * @return
     */
    public Role findByIdRole(Integer rid);

    /**
     * 修改角色表的内容
     * @param role
     */
    public void updateRole(Role role);

    /**
     * 添加角色表里的内容
     * @param role
     */
    public void addRole(Role role);


    /**
     *
     * @return
     */
    public List<Role> findAllRole();

}