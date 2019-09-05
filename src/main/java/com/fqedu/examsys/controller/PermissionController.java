package com.fqedu.examsys.controller;

import com.fqedu.examsys.common.JsonResult;
import com.fqedu.examsys.entity.Admin;
import com.fqedu.examsys.entity.Permission;
import com.fqedu.examsys.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    /**
     * 菜单栏的动态展示
     *
     * @return
     */
    @RequestMapping("/admin/moveMenu")
    @ResponseBody
    public JsonResult moveMenu(HttpSession session) {

        JsonResult jsonResult;
        try {
            Admin admin = (Admin) session.getAttribute("admin");
            List<Permission> list = permissionService.moveMenu(admin.getId());
            jsonResult = new JsonResult(0, null, 0, list);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult = new JsonResult(1, null, 0, e.getMessage());
        }
        return jsonResult;
    }
}
