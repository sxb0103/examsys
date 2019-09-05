package com.fqedu.examsys.entity;

import lombok.Data;

@Data
public class User {
    /** id */
    private Integer id;
    /** 账号 */
    private String account;
    /** 姓名 */
    private String userName;
    /** 密码 */
    private String password;
    /** 地址*/
    private String address;
    /** 手机号*/
    private String phone;
}