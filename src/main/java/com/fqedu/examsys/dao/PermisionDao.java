package com.fqedu.examsys.dao;


import com.fqedu.examsys.entity.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermisionDao {

    /**
     *  动态获取菜单
     * @param
     * @param
     * @return
     */
    public List<Permission> moveMenu(Integer id);

}