package com.fqedu.examsys.entity;

import lombok.Data;

@Data
public class RolePermission {
    /** 角色权限id */
    private Integer rolePermissionId;
    /** 角色id */
    private Integer rid;
    /** 权限id */
    private Integer pid;

    private Role role;

    private Permission permission;
}