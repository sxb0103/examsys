package com.fqedu.examsys.service.impl;


import com.fqedu.examsys.dao.PaperScoreDao;
import com.fqedu.examsys.service.PaperScoreService;
import com.fqedu.examsys.vo.PaperScore;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperScoreServiceImpl implements PaperScoreService {

    @Autowired(required = false)
    public PaperScoreDao paperScoreDao;

    @Override
    public List<PaperScore> findAll(Integer sortId, Integer subId, Integer page, Integer limit) {

//        Integer sid = null;
//        Integer suid = null;
//        if (sortId == null) {
//            sid = 0;
//        }
//        if (subId == null) {
//            suid = 0;
//        }

        PageHelper.startPage(page, limit);
        List<PaperScore> paperScoreList = paperScoreDao.findAll(sortId, subId);
        return paperScoreList;
    }

    @Override
    public List<PaperScore> findListBySubId(Integer subId) {

        return paperScoreDao.findListBySubId(subId);
    }
}
