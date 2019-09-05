package com.fqedu.examsys.service;

import com.fqedu.examsys.entity.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {

    /**从数据库中查找所有角色名称
     * @return
     */
    public List<Role> findRoleName();


    /**
     * 查询所有
     * @return
     */
    public List<Role> findByPageRole(String roleName, Integer limit, Integer page);

    /**
     * 删除信息
     * @param id
     */
    public void deleteRole(Integer id);

    /**
     * 批量删除
     * @param idArr
     * @return
     */
    public Integer deleteManyRole(int[] idArr);

    /**
     * 根据 id查找角色表所有信息
     * @param id
     * @return
     */
    public Role findByIdRole(Integer id);

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


    public List<Role> findAllRole();

}
