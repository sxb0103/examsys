package com.fqedu.examsys.controller;

import com.fqedu.examsys.common.JsonResult;
import com.fqedu.examsys.entity.Admin;
import com.fqedu.examsys.service.AdminService;
import com.github.pagehelper.Page;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 跳转登陆页面
     *
     * @return
     */
//    @RequestMapping(value = "/admin/login.do", method = RequestMethod.POST)
    @PostMapping("/admin/login.do")
    @ResponseBody
    public JsonResult login(String account, String password, HttpSession session) {
//    public Map<String,Object> login(String account, String password) {

        //根据用户登陆时的账号密码创建 token对象
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);

        Admin admin = adminService.LoginAdmin(account, password);
        session.setAttribute("admin", admin);

        try {
            //获取 subject主体对象
            Subject subject = SecurityUtils.getSubject();
//            HashMap<String, Object> map = new HashMap<>();
            subject.login(token);
//            map.put("token",token);
            return new JsonResult(0,"",0, null);

        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(1, "",0,"登陆失败");

        }
//        return map;
    }


    /**
     * 登出
     *
     * @return
     */
    @RequestMapping("/admin/outLogin")
    public String loginOut() {
        Subject subjectOut = SecurityUtils.getSubject();

        subjectOut.logout();
        return "redirect:/login.html";
    }

    /**
     * 添加用户
     *
     * @param
     * @return
     */
    @RequestMapping("/admin/addAdmin")
    @ResponseBody
    public JsonResult addAdmin(@RequestParam("account") String account,
                               @RequestParam("admName") String admName,
                               @RequestParam("password") String password,
                               @RequestParam("rid") Integer rid) {

        adminService.addAdmin(account, admName, password, rid);

        return new JsonResult(0, "",0,null);
    }

    /**
     * 所有用户的信息
     *
     * @param account  账号
     * @param admName  姓名
     * @param roleName 角色名称
     * @param limit    分页 从第几行开始
     * @param page     页数
     * @return
     */
    @RequestMapping("/admin/adminList")
    @ResponseBody
    public JsonResult findAdminAll(String account, String admName, String roleName, Integer page, Integer limit) {
        List<Admin> list = adminService.findByPage(account, admName, roleName, page, limit);

        long total = ((Page) list).getTotal();
        JsonResult jsonResult = new JsonResult(0, "", total, list);

        return jsonResult;
    }

    /**
     * 单个删除
     *
     * @param id
     * @return
     */
    @RequestMapping("/admin/deleteAdmin")
    @ResponseBody
    public JsonResult deleteAdmin(Integer id) {

        JsonResult jsonResult = new JsonResult();

        try {
            adminService.deleteAdmin(id);
            jsonResult = new JsonResult(0, "",0,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonResult;
    }


    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/admin/deleteManAdmin")
    @ResponseBody
    public JsonResult deleteManyAdmin(String ids) {
        String[] idArr = ids.split(",");

        int[] id = new int[idArr.length];

        for (int i = 0; i < idArr.length; i++) {
            id[i] = Integer.parseInt(idArr[i]);
        }
        adminService.deleteManyAdmin(id);

        return new JsonResult(0, "",0,null);

    }

    /**
     * 查询一个人的所有信息
     *
     * @param id 用户 id
     * @return
     */
    @RequestMapping("/admin/findById")
    @ResponseBody
    public JsonResult findById(Integer id) {
        Admin byId = null;
        try {
            byId = adminService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JsonResult(0,"",0, byId);
    }

    /**
     * 修改信息
     *
     * @param admin
     * @return
     */
    @RequestMapping("/admin/updateAdmin")
    @ResponseBody
    public JsonResult updateAdmin(Admin admin) {
        JsonResult jsonResult;
        try {
            adminService.updateAdmin(admin);
            jsonResult = new JsonResult(0, "",0,null);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult = new JsonResult(1, "",0,e.getMessage());
        }
        return jsonResult;
        //        return new JsonResult(1,null);
    }

    /**
     * 修改密码
     *
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/admin/updatePassword")
    public String updatePassword(String password, HttpSession session) {

        Admin admin = (Admin) session.getAttribute("admin");

        adminService.updatePassword(password, admin.getId());

        return "redirect:/manage.html";
    }

    /**
     * 查询登陆用户的所有信息
     * @param session
     * @return
     */
    @RequestMapping("/admin/findAdmin")
    @ResponseBody
    public JsonResult findAdmin(HttpSession session) {

        Admin admin = (Admin) session.getAttribute("admin");

        return new JsonResult(0,"",0, admin);
    }
}

