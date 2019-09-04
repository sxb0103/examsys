package com.fqedu.examsys.service;

import com.fqedu.examsys.entity.TSubject;

import java.util.List;

public interface TSubjectService {

    public List<TSubject> findSubBySortId(Integer sortId);

}
