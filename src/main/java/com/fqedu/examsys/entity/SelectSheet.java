package com.fqedu.examsys.entity;

import lombok.Data;

@Data
public class SelectSheet {

    private Integer id;

    private Integer paperId;

    private Integer userId;

    private String radioReply;

    private String selectionReply;

    private String decideReply;


}