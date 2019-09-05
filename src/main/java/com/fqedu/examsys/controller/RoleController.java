package com.fqedu.examsys.controller;

import com.fqedu.examsys.common.JsonResult;
import com.fqedu.examsys.entity.Role;
import com.fqedu.examsys.service.RoleService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 查找所有角色名称
     *
     * @return
     */
    @RequestMapping("/admin/roleName")
    @ResponseBody
    public JsonResult findRoleName() {

        JsonResult jsonResult;
        try {
            List<Role> list = roleService.findRoleName();
            jsonResult = new JsonResult(0,"",0, list);
        } catch (Exception e) {
            jsonResult = new JsonResult(1,"",0, e.getMessage());
        }
        return jsonResult;
    }

    /**
     * 分页展示角色表所有内容
     * @param roleName
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/admin/roleList")
    @ResponseBody
    public JsonResult findRoleAll(String roleName, Integer page, Integer limit) {
        List<Role> list = roleService.findByPageRole(roleName, page, limit);

        long total = ((Page) list).getTotal();
        JsonResult jsonResult = new JsonResult(0, "", total, list);

        return jsonResult;
    }

    /**
     * 单个删除
     * @param rid
     * @return
     */
    @RequestMapping("/admin/deleteRole")
    @ResponseBody
    public JsonResult deleteRole(Integer rid) {

        JsonResult jsonResult = new JsonResult();

        try {
            roleService.deleteRole(rid);
            jsonResult = new JsonResult(0, "",0,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonResult;
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/admin/deleteManyRole")
    @ResponseBody
    public JsonResult deleteManyRole(String ids) {
        String[] idArr = ids.split(",");

        int[] rid = new int[idArr.length];

        for (int i = 0; i < idArr.length; i++) {
            rid[i] = Integer.parseInt(idArr[i]);
        }
        roleService.deleteManyRole(rid);

        return new JsonResult(0, "",0,null);

    }

    /**
     * 根据 id查找内容
     * @param rid
     * @return
     */
    @RequestMapping("/admin/findByIdRole")
    @ResponseBody
    public JsonResult findById(Integer rid) {
        JsonResult jsonResult;
        try {
            Role byIdRole = roleService.findByIdRole(rid);
            jsonResult = new JsonResult(0,"",0,byIdRole);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(1,"",0,e.getMessage());
        }
        return jsonResult;
    }

    /**
     * 修改信息
     * @param role
     * @return
     */
    @RequestMapping("/admin/updateRole")
    @ResponseBody
    public JsonResult updateRole(Role role) {
        JsonResult jsonResult;
        try {
            roleService.updateRole(role);
            jsonResult = new JsonResult(0, "",0,null);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult = new JsonResult(1, "",0,e.getMessage());
        }
        return jsonResult;

    }

    /**
     * 添加角色信息
     * @param role
     * @return
     */
    @RequestMapping("/admin/addRole")
    @ResponseBody
    public JsonResult addRole(Role role){
        JsonResult jsonResult;
        try {
            roleService.addRole(role);
            jsonResult = new JsonResult(0,"",0,null);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult = new JsonResult(1,"",0, e.getMessage());
        }
        return jsonResult;
    }

}
