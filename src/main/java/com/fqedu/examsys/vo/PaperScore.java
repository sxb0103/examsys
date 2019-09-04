package com.fqedu.examsys.vo;


import lombok.Data;

import java.util.Date;

@Data
public class PaperScore {

    //
    private Integer sortId;

    private String sortName;

    private Integer subId;

    private String course;

    private Integer id;

    private String paperName;

    private Date starTime;

    private Date endTime;

    private Integer paperId;

    private Integer userId;

    private Integer shortScore;

    private String username;
}
