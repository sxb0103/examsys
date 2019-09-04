package com.fqedu.examsys.common;

import lombok.Data;

@Data
public class JsonResult {


    private int code; // 0 正常 1 异常
    private String msg;
    private long count;
    //返回前端的数据
    private Object data;


    public JsonResult() {
    }

    public JsonResult(long count, Object data) {
       new JsonResult(0,"",count,data);
    }

    public JsonResult(int code, String msg, long count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

}
