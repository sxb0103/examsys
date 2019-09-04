package com.fqedu.examsys.service.impl;

import com.fqedu.examsys.dao.PaperAnswerDao;
import com.fqedu.examsys.service.PaperAnswerServic;
import com.fqedu.examsys.vo.PaperAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperAnswerServiceImpl implements PaperAnswerServic {

    @Autowired(required = false)
    public PaperAnswerDao paperAnswerDao;

    @Override
    public List<PaperAnswer> findByPaperUserId(Integer paperId, Integer userId) {
        List<PaperAnswer> paperAnswerList = paperAnswerDao.findByPaperUserId(paperId, userId);
        return paperAnswerList;
    }
}
