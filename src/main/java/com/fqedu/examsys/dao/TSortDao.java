package com.fqedu.examsys.dao;

import com.fqedu.examsys.entity.TSort;

import java.util.List;

public interface TSortDao {

    public List<TSort> findAllSort();

    public void updateSortByPaperId(Integer paperId,Integer userId,Integer shortScore);

}
