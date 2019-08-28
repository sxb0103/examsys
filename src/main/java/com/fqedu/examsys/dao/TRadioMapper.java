package com.fqedu.examsys.dao;

import com.angus.entity.TRadio;

public interface TRadioMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TRadio record);

    int insertSelective(TRadio record);

    TRadio selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TRadio record);

    int updateByPrimaryKey(TRadio record);
}