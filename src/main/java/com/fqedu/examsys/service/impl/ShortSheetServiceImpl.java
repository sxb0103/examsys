package com.fqedu.examsys.service.impl;

import com.fqedu.examsys.dao.ShortSheetDao;
import com.fqedu.examsys.service.ShortSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortSheetServiceImpl implements ShortSheetService {

    @Autowired(required = false)
    public ShortSheetDao shortSheetDao;

    @Override
    public void updateShortSheet(Integer paperId, Integer userId, Integer shortId, Integer score) {

        shortSheetDao.updateShortSheet(paperId,userId,shortId,score);
    }
}
