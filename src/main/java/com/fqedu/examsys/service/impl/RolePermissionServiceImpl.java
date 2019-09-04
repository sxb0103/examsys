package com.fqedu.examsys.service.impl;

import com.fqedu.examsys.dao.RolePermissionDao;
import com.fqedu.examsys.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired(required = false)
    public RolePermissionDao rolePermissionDao;

    /**
     *
     * @param rid
     * @param pid
     */
    @Override
    public void insertRolPer(Integer rid, Integer pid) {
        rolePermissionDao.insertRolPer(rid, pid);
    }

    @Override
    public void deleteRolPer(Integer rid) {
        rolePermissionDao.deleteRolPer(rid);
    }
}
