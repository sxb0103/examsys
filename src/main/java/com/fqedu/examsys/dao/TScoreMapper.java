package com.fqedu.examsys.dao;

import com.angus.entity.TScore;

public interface TScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TScore record);

    int insertSelective(TScore record);

    TScore selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TScore record);

    int updateByPrimaryKey(TScore record);
}