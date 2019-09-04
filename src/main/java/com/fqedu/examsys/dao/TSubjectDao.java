package com.fqedu.examsys.dao;

import com.fqedu.examsys.entity.TSubject;

import java.util.List;

public interface TSubjectDao {

    public List<TSubject> findSubBySortId(Integer sortId);
}
