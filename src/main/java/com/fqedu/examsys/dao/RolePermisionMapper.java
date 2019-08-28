package com.fqedu.examsys.dao;

import com.angus.entity.RolePermision;

public interface RolePermisionMapper {
    int deleteByPrimaryKey(Integer rolePermisionId);

    int insert(RolePermision record);

    int insertSelective(RolePermision record);

    RolePermision selectByPrimaryKey(Integer rolePermisionId);

    int updateByPrimaryKeySelective(RolePermision record);

    int updateByPrimaryKey(RolePermision record);
}