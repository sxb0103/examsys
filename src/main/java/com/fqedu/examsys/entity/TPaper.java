package com.fqedu.examsys.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TPaper {

    //
    private Integer id;

    private String paperName;

    private Integer sortId;

    private Integer subId;

    private String radioId;

    private Integer radioScore;

    private String selectionId;

    private Integer selectionScore;

    private String decideId;

    private Integer decideScore;

    private Date starTime;

    private Date endTime;

    private String shortId;

    private Integer shortScore;

}