package com.fqedu.examsys.dao;

import org.apache.ibatis.annotations.Param;



public interface RolePermissionDao {

    public void insertRolPer(@Param("rid") Integer rid,@Param("pid") Integer pid);

    public void deleteRolPer(Integer rid);
}
