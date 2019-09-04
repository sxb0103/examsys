package com.fqedu.examsys.poi;

import com.alibaba.fastjson.JSON;
import com.fqedu.examsys.entity.TRadio;
import com.fqedu.examsys.service.TRadioService;
import com.fqedu.examsys.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Controller
public class ImportController {

    @Autowired
    public TRadioService tRadioService;

    /**
     *
     * @param upFile
     * @return
     */
    @RequestMapping("/import")
    public String importExcel(@RequestParam MultipartFile upFile){

        try {
            //获取上传文件的输入流对象
            InputStream inputStream=upFile.getInputStream();
            //获取上传文件的文件名
            String filename=upFile.getOriginalFilename();
            //获取上传文件的数据
            List<Map<String, Object>> list = ExcelUtils.readExcel(filename, inputStream);
            //将列表对象转为json格式字符串
            String jsonList = JSON.toJSONString(list);
            //将json字符串转为实体类对象
            List<TRadio> tRadioList = JSON.parseArray(jsonList, TRadio.class);
//            System.out.println(tRadioList);
            tRadioService.insertTRadioAll(tRadioList);

        } catch (IOException e) {
            e.printStackTrace();
        }
//        return new JsonResult(0,"上传成功",0,null);
        return "redirect:/import.html";
    }
}








































