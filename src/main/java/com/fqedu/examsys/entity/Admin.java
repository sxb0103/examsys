package com.fqedu.examsys.entity;

import lombok.Data;

@Data
public class Admin {

    //主键id
    private Integer id;

    private String account;

    private String admName;

    private String password;

    //权限id
    private Integer rid;


}