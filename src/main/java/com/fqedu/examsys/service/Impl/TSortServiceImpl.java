package com.fqedu.examsys.service.impl;

import com.fqedu.examsys.dao.TSortDao;
import com.fqedu.examsys.entity.TSort;
import com.fqedu.examsys.service.TSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TSortServiceImpl implements TSortService {

    @Autowired(required = false)

    public TSortDao tSortDao;

    @Override
    public List<TSort> findAllSort() {

        return tSortDao.findAllSort();
    }

    /**
     *
     * @param paperId
     * @param userId
     * @param shortScore
     */
    @Override
    public void updateSortByPaperId(Integer paperId, Integer userId, Integer shortScore) {
        tSortDao.updateSortByPaperId(paperId, userId, shortScore);
    }
}
