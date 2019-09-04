package com.fqedu.examsys.service.impl;

import com.fqedu.examsys.dao.TRadioDao;
import com.fqedu.examsys.entity.TRadio;
import com.fqedu.examsys.service.TRadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TRadioServiceImpl implements TRadioService {

    @Autowired(required = false)
    public TRadioDao tRadioDao;

    /**
     *
     * @param tRadios
     */
    @Override
    public void insertTRadioAll(List<TRadio> tRadios) {
        tRadioDao.insertTRadioAll(tRadios);
    }
}
