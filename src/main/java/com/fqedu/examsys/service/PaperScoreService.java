package com.fqedu.examsys.service;

import com.fqedu.examsys.vo.PaperScore;

import java.util.List;

public interface PaperScoreService {

    /**
     *
     * @param sortId
     * @param subId
     * @param page
     * @param limit
     * @return
     */
    public List<PaperScore> findAll(Integer sortId, Integer subId, Integer page, Integer limit);

    public List<PaperScore> findListBySubId(Integer subId);
}
