package com.fqedu.examsys.dao;

import com.fqedu.examsys.vo.PaperScore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperScoreDao {

    public List<PaperScore> findAll(@Param("sortId") Integer sortId, @Param("subId") Integer subId);

    public List<PaperScore> findListBySubId(Integer subId);
}
