package com.fqedu.examsys.entity;

import lombok.Data;

@Data
public class Permission {

    private Integer pid;

    private String resourceName;

    private Integer parentId;

    private String permissionName;

    private String resourceType;

    private String url;


}