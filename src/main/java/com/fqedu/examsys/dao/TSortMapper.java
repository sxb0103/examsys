package com.fqedu.examsys.dao;

import com.angus.entity.TSort;

public interface TSortMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TSort record);

    int insertSelective(TSort record);

    TSort selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TSort record);

    int updateByPrimaryKey(TSort record);
}