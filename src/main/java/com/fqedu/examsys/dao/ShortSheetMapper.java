package com.fqedu.examsys.dao;

import com.angus.entity.ShortSheet;

public interface ShortSheetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShortSheet record);

    int insertSelective(ShortSheet record);

    ShortSheet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShortSheet record);

    int updateByPrimaryKey(ShortSheet record);
}