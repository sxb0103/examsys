package com.fqedu.examsys.entity;

import lombok.Data;

@Data
public class Admin {
    private Integer id;

    private String account;

    private String admName;

    private String password;

    private Integer rid;


}