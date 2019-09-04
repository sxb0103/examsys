package com.fqedu.examsys.dao;

import com.fqedu.examsys.entity.Role;

import java.util.List;


public interface RoleDao {

    /**
     *
     * @return
     */
    public List<Role> findAllRole();
}
