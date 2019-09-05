package com.fqedu.examsys.service;

import com.fqedu.examsys.entity.Permission;

import java.util.List;

public interface PermissionService {

    /**
     * 动态二级菜单的查询
     * @return
     */
    public List<Permission> moveMenu(Integer id);

}
