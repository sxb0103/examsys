package com.fqedu.examsys.service.impl;

import com.fqedu.examsys.dao.TSubjectDao;
import com.fqedu.examsys.entity.TSubject;
import com.fqedu.examsys.service.TSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TSubjectServiceImpl implements TSubjectService {

    @Autowired(required = false)
    TSubjectDao tSubjectDao;

    @Override
    public List<TSubject> findSubBySortId(Integer sortId) {
        return tSubjectDao.findSubBySortId(sortId);
    }
}
