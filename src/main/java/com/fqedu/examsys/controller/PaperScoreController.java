package com.fqedu.examsys.controller;

import com.fqedu.examsys.common.JsonResult;
import com.fqedu.examsys.entity.TSort;
import com.fqedu.examsys.entity.TSubject;
import com.fqedu.examsys.service.PaperAnswerServic;
import com.fqedu.examsys.service.PaperScoreService;
import com.fqedu.examsys.service.TSortService;
import com.fqedu.examsys.service.TSubjectService;
import com.fqedu.examsys.vo.PaperAnswer;
import com.fqedu.examsys.vo.PaperScore;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PaperScoreController {

    @Autowired
    public PaperScoreService paperScoreService;

    @Autowired
    public TSortService tSortService;

    @Autowired
    public TSubjectService tSubjectService;

    @Autowired
    public PaperAnswerServic paperAnswerServic;

//    @RequestMapping("/jump.do")
//    public String jump(){
//        return "videoIndex";
//    }

    @RequestMapping("/findAll.do")
    @ResponseBody
    public JsonResult findAll(Integer sortId, Integer subId, Integer page, Integer limit) {

        List<PaperScore> paperScoreList = paperScoreService.findAll(sortId,subId,page,limit);

        long total = ((Page) paperScoreList).getTotal();

        JsonResult jsonResult = new JsonResult(0, "", total, paperScoreList);

        return jsonResult;
    }

    @RequestMapping("/findBySubId.do")
    public List<PaperScore> findAllBySubId(Integer subId) {
        return paperScoreService.findListBySubId(subId);
    }

    @RequestMapping("/findAllSort.do")
    @ResponseBody
    public JsonResult findAllSort(){

        List<TSort> tSortList = tSortService.findAllSort();

        return new JsonResult(0,null,0,tSortList);
    }

    @RequestMapping("/findSubBySortId.do")
    @ResponseBody
    public JsonResult findSubBySortId(Integer sortId){

        List<TSubject> tSubjectList = tSubjectService.findSubBySortId(sortId);

        return new JsonResult(0,null,0,tSubjectList);
    }

    @RequestMapping("/findByPaperUserId.do")
    @ResponseBody
    public JsonResult findByPaperUserId(Integer paperId, Integer userId){

        List<PaperAnswer> paperAnswerList = paperAnswerServic.findByPaperUserId(paperId, userId);

        return new JsonResult(0,null,0,paperAnswerList);
    }
}
