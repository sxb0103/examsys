package com.fqedu.examsys.dao;

import com.angus.entity.TShortAnswer;

public interface TShortAnswerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TShortAnswer record);

    int insertSelective(TShortAnswer record);

    TShortAnswer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TShortAnswer record);

    int updateByPrimaryKey(TShortAnswer record);
}