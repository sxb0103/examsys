package com.fqedu.examsys.service;

import com.fqedu.examsys.entity.TSort;

import java.util.List;

public interface TSortService {

    public List<TSort> findAllSort();

    public void updateSortByPaperId(Integer paperId,Integer userId,Integer shortScore);
}
