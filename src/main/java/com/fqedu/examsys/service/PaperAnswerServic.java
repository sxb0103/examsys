package com.fqedu.examsys.service;

import com.fqedu.examsys.vo.PaperAnswer;


import java.util.List;

public interface PaperAnswerServic {

    public List<PaperAnswer> findByPaperUserId(Integer paperId,Integer userId);
}
