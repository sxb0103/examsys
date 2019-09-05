package com.fqedu.examsys.entity;

import lombok.Data;

@Data
public class Admin {

    //主键id
    private Integer id;

    /** 账号 */
    private String account;

    /** 姓名 */
    private String admName;

    /** 密码 */
    private String password;

    /** 角色id */
    private Integer rid;

    /** 角色表的内容 */
    private Role role;

}