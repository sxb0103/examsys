package com.fqedu.examsys.dao;

import com.angus.entity.TSubject;

public interface TSubjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TSubject record);

    int insertSelective(TSubject record);

    TSubject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TSubject record);

    int updateByPrimaryKey(TSubject record);
}