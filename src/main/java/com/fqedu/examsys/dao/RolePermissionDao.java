package com.fqedu.examsys.dao;


import com.fqedu.examsys.entity.RolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePermissionDao {

    /**
     * 查询权限角色关系的所有信息
     * @param roleName
     * @param resourceName
     * @return
     */
    public List<RolePermission> findRolePerm(@Param("roleName") String roleName, @Param("resourceName") String resourceName);

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

    public void insertRolPer(@Param("rid") Integer rid,@Param("pid") Integer pid);

    public void deleteRolPer(Integer rid);
}