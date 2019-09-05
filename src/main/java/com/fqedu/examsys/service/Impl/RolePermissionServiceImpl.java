package com.fqedu.examsys.service.impl;

import com.fqedu.examsys.dao.RolePermissionDao;
import com.fqedu.examsys.entity.RolePermission;
import com.fqedu.examsys.service.RolePermissionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired(required = false)
    private RolePermissionDao rolePermissionDao;

    @Override
    public List<RolePermission> findByPage(String roleName, String resourceName, Integer limit, Integer page) {
        PageHelper.startPage(limit, page);

        List<RolePermission> list = rolePermissionDao.findRolePerm(roleName,resourceName);

        return list;
    }

    @Override
    public void deleteRolePerm(Integer rolePermissionId) {
        rolePermissionDao.deleteRolePerm(rolePermissionId);
    }

    @Override
    public Integer deleteManyRolePerm(int[] idArr) {
        return rolePermissionDao.deleteManyRolePerm(idArr);
    }


    @Override
    public void insertRolPer(Integer rid, Integer pid) {
        rolePermissionDao.insertRolPer(rid, pid);
    }

    @Override
    public void deleteRolPer(Integer rid) {
        rolePermissionDao.deleteRolPer(rid);
    }

}
