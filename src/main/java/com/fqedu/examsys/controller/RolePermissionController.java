package com.fqedu.examsys.controller;

import com.fqedu.examsys.common.JsonResult;
import com.fqedu.examsys.entity.Role;
import com.fqedu.examsys.entity.RolePermission;
import com.fqedu.examsys.service.RolePermissionService;
import com.fqedu.examsys.service.RoleService;
import com.github.pagehelper.Page;
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
    private RolePermissionService rolePermissionService;


    /**
     * 分页展示权限角色关系
     * @param roleName
     * @param resourceName
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/admin/rolePermList")
    @ResponseBody
    public JsonResult findAllRolePerm(String roleName, String resourceName,Integer page, Integer limit) {
        List<RolePermission> list = rolePermissionService.findByPage(roleName,resourceName, page, limit);

        long total = ((Page) list).getTotal();
        JsonResult jsonResult = new JsonResult(0, "", total, list);

        return jsonResult;
    }

    /**
     * 单个删除
     * @param rolePermissionId
     * @return
     */
    @RequestMapping("/admin/deleteRolePerm")
    @ResponseBody
    public JsonResult deleteRole(Integer rolePermissionId) {

        JsonResult jsonResult;

        try {
            rolePermissionService.deleteRolePerm(rolePermissionId);
            jsonResult = new JsonResult(0, "",0,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult = new JsonResult(1, "",0,"删除失败");
        }
        return jsonResult;
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/admin/deleteManyRolePerm")
    @ResponseBody
    public JsonResult deleteManyRole(String ids) {
        String[] idArr = ids.split(",");

        int[] rolePermissionId = new int[idArr.length];

        for (int i = 0; i < idArr.length; i++) {
            rolePermissionId[i] = Integer.parseInt(idArr[i]);
        }
        rolePermissionService.deleteManyRolePerm(rolePermissionId);

        return new JsonResult(1, "",0,null);
    }

    @RequestMapping("/admin/findAllRole.do")
    @ResponseBody
    public JsonResult findAllRole() {

        List<Role> roleList = roleService.findAllRole();

        return new JsonResult(0, null, 0, roleList);
    }


    @RequestMapping("/admin/addRolePer.do")
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
