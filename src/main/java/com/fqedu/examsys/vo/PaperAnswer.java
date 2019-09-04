package com.fqedu.examsys.vo;

import lombok.Data;

@Data
public class PaperAnswer {

    //
    private Integer id;

    private Integer paperId;

    private Integer userId;

    private String shortReply;

    private Integer shortId;

    private String topic;

    private String answer;

    private String username;


}
