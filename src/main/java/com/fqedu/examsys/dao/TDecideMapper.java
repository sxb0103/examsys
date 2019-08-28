package com.fqedu.examsys.dao;

import com.angus.entity.TDecide;

public interface TDecideMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TDecide record);

    int insertSelective(TDecide record);

    TDecide selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TDecide record);

    int updateByPrimaryKey(TDecide record);
}