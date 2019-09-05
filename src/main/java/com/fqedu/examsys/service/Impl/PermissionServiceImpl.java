package com.fqedu.examsys.service.impl;

import com.fqedu.examsys.dao.PermisionDao;
import com.fqedu.examsys.entity.Permission;
import com.fqedu.examsys.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermisionDao permisionDao;

    @Override
    public List<Permission> moveMenu(Integer id) {

        List<Permission> list = permisionDao.moveMenu(id);
        return list;
    }

}
