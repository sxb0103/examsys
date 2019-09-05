package com.fqedu.examsys.service.impl;

import com.fqedu.examsys.dao.RoleDao;
import com.fqedu.examsys.entity.Role;
import com.fqedu.examsys.service.RoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findRoleName() {

        List<Role> list = roleDao.findRoleName();

        if (list == null){
            throw new RuntimeException("没有数据");
        }
        return list;
    }

    @Override
    public List<Role> findByPageRole(String roleName, Integer limit, Integer page){
        PageHelper.startPage(limit, page);

        List<Role> list = roleDao.findRoleAll(roleName);

        return list;

    }


    @Override
    public void deleteRole(Integer id) {
        roleDao.deleteRole(id);
    }

    @Override
    public Integer deleteManyRole(int[] idArr) {
        return roleDao.deleteManyRole(idArr);
    }

    @Override
    public Role findByIdRole(Integer id) {
        Role byIdRole = roleDao.findByIdRole(id);

        return byIdRole;
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }


    public List<Role> findAllRole() {
        return roleDao.findAllRole();
    }
}
