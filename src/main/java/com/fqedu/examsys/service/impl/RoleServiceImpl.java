package com.fqedu.examsys.service.impl;

import com.fqedu.examsys.dao.RoleDao;
import com.fqedu.examsys.entity.Role;
import com.fqedu.examsys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired(required = false)
    public RoleDao roleDao;


    public List<Role> findAllRole() {
        return roleDao.findAllRole();
    }
}
