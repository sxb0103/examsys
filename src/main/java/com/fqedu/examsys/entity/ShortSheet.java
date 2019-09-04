package com.fqedu.examsys.entity;

import lombok.Data;

@Data
public class ShortSheet {

    //
    private Integer id;

    private Integer paperId;

    private Integer userId;

    private String shortReply;

    private Integer score;

    private Integer shortId;
}