package com.fqedu.examsys.dao;

import com.angus.entity.TPaper;

public interface TPaperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TPaper record);

    int insertSelective(TPaper record);

    TPaper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TPaper record);

    int updateByPrimaryKey(TPaper record);
}