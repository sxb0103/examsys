package com.fqedu.examsys.entity;

import lombok.Data;

import java.util.List;

@Data
public class Permission {

    /** 权限id */
    private Integer pid;

    /** 资源名称 */
    private String resourceName;

    /** 父类id */
    private Integer parentId;

    /** 权限名称 */
    private String permissionName;

    /** 资源类型 */
    private String resourceType;

    /** 资源路径 */
    private String url;

    /** 自连接查询，Permission父类，childPermission相当于子类*/
    private List<Permission> childPermissions;
}