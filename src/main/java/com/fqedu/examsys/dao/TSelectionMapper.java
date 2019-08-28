package com.fqedu.examsys.dao;

import com.angus.entity.TSelection;

public interface TSelectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TSelection record);

    int insertSelective(TSelection record);

    TSelection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TSelection record);

    int updateByPrimaryKey(TSelection record);
}