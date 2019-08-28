package com.fqedu.examsys.dao;

import com.angus.entity.SelectSheet;

public interface SelectSheetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SelectSheet record);

    int insertSelective(SelectSheet record);

    SelectSheet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SelectSheet record);

    int updateByPrimaryKey(SelectSheet record);
}