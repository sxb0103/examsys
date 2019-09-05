package com.fqedu.examsys.dao;

import com.fqedu.examsys.vo.PaperAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperAnswerDao {

    public List<PaperAnswer> findByPaperUserId(@Param("paperId") Integer paperId, @Param("userId") Integer userId);

}
