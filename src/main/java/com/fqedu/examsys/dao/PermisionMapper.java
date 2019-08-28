package com.fqedu.examsys.dao;

import com.angus.entity.Permision;

public interface PermisionMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Permision record);

    int insertSelective(Permision record);

    Permision selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Permision record);

    int updateByPrimaryKey(Permision record);
}