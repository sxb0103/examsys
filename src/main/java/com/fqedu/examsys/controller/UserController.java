package com.fqedu.examsys.controller;

import com.fqedu.examsys.common.JsonResult;
import com.fqedu.examsys.entity.User;
import com.fqedu.examsys.service.UserService;
import com.fqedu.examsys.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
public class UserController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UserService userService;

    /**
     * 登陆
     *
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping("/api/userLogin")
    @ResponseBody
    public JsonResult login(String userName, String password) {


        User user = userService.LoginUser(userName, password);

        Map<String, Object> map = new HashMap<>();
        // 根据name生成token
        String token = MD5Utils.md5(user.getUserName() + "Nice");
        map.put("token", token);

        // 将token写道redis中
        redisTemplate.opsForValue().set(token, user.getUserName());

        return new JsonResult(0, "", 0, map);
    }

    /**
     * 注册
     * @param account
     * @param userName
     * @param password
     * @param address
     * @param phone
     * @return
     */
    @RequestMapping("/api/registerUser")
    @ResponseBody
    public JsonResult registerUser(String account, String userName, String password, String address, String phone) {
        JsonResult jsonResult;
        try {
            userService.addUser(account, userName, password, address, phone);
            jsonResult = new JsonResult(0, "",0,null);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult = new JsonResult(1, "",0,e.getMessage());
        }
        return jsonResult;

//        userService.addUser(account, userName, password, address, phone);
//
//        return new JsonResult(0,null);

    }
}
