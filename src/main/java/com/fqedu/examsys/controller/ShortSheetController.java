package com.fqedu.examsys.controller;

import com.alibaba.fastjson.JSON;


import com.fqedu.examsys.common.JsonResult;
import com.fqedu.examsys.common.JsonShortSheet;
import com.fqedu.examsys.service.ShortSheetService;
import com.fqedu.examsys.service.TSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ShortSheetController {

    @Autowired
    public ShortSheetService shortSheetService;

    @Autowired
    public TSortService tSortService;

    /**
     *
     * @param request
     * @param paperId
     * @param userId
     * @return
     */
    @RequestMapping("/admin/updateShortSheet.do")
    @ResponseBody
    public JsonResult updateShortSheet(HttpServletRequest request, Integer paperId, Integer userId) {

        //获取JsonShortSheet的json字符串，里面存储的是{shortId,userId}
        String conditionsStr = request.getParameter("conditions");

        //将json字符串转为列表
        List<JsonShortSheet> lists = JSON.parseArray(conditionsStr, JsonShortSheet.class);

        //创建变量获取简答题总成绩
        Integer shortScore = 0;

        //更新答题卡成绩
        for (int i = 0; i < lists.size(); i++) {

            //获取题目id
            Integer shortId = lists.get(i).getShortId();

            //获取分数
            Integer score = lists.get(i).getScore();

            shortScore += score;
            //根据paperId,userId,shortId,score跟新答题卡成绩
            shortSheetService.updateShortSheet(paperId, userId, shortId, score);
        }

        //更新总成绩
        tSortService.updateSortByPaperId(paperId,userId,shortScore);

        //返回json格式
        return new JsonResult(0, null, 0, null);
    }
}
