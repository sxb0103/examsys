package com.fqedu.examsys.entity;

import lombok.Data;

@Data
public class Permision {

    private Integer pid;

    private String resoureName;

    private Integer parentId;

    private String penmisionName;

    private String resoureType;

    private String url;


}