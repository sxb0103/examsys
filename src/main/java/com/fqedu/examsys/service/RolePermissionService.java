package com.fqedu.examsys.service;

import com.fqedu.examsys.entity.RolePermission;

import java.util.List;
import java.util.Map;

public interface RolePermissionService {

    /**
     * 分页展示权限角色关系的查询
     * @param roleName
     * @param resourceName
     * @param limit
     * @param page
     * @return
     */
    public List<RolePermission> findByPage(String roleName, String resourceName, Integer limit, Integer page);

    /**
     * 删除信息
     * @param rolePermissionId
     */
    public void deleteRolePerm(Integer rolePermissionId);

    /**
     * 批量删除
     * @param idArr
     * @return
     */
    public Integer deleteManyRolePerm(int[] idArr);


    public void insertRolPer(Integer rid, Integer pid);

    public void deleteRolPer(Integer rid);
}
