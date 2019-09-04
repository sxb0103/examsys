package com.fqedu.examsys.controller;

import com.fqedu.examsys.common.JsonResult;
import com.fqedu.examsys.entity.Role;
import com.fqedu.examsys.service.RolePermissionService;
import com.fqedu.examsys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RolePermissionController {

    @Autowired
    public RoleService roleService;

    @Autowired
    public RolePermissionService rolePermissionService;

    /**
     *
     * @return
     */
    @RequestMapping("/findAllRole.do")
    @ResponseBody
    public JsonResult findAllRole() {

        List<Role> roleList = roleService.findAllRole();

        return new JsonResult(0, null, 0, roleList);
    }

    @RequestMapping("/addRolePer.do")
    @ResponseBody
    public JsonResult addRolePer(Integer rid, String jsonPer) {

        JsonResult jsonResult = null;
        String[] split = jsonPer.split(",");
        ArrayList<Integer> pids = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            int i1 = Integer.parseInt(s);
            pids.add(i1);
        }

        try {
            //先清空原来的权限
            rolePermissionService.deleteRolPer(rid);
            //添加新权限
            for (int i = 0; i < pids.size(); i++) {
                rolePermissionService.insertRolPer(rid, pids.get(i));
            }
            jsonResult = new JsonResult(0, null, 0, null);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult = new JsonResult(1, null, 0, null);
        }
        return jsonResult;
    }
}
