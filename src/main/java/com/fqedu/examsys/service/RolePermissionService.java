package com.fqedu.examsys.service;



public interface RolePermissionService {

    /**
     *
     * @param rid
     * @param pid
     */
    public void insertRolPer(Integer rid, Integer pid);

    public void deleteRolPer(Integer rid);
}
