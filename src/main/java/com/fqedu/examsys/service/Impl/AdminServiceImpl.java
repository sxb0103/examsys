package com.fqedu.examsys.service.impl;

import com.fqedu.examsys.dao.AdminDao;
import com.fqedu.examsys.entity.Admin;
import com.fqedu.examsys.service.AdminService;
import com.fqedu.examsys.utils.MD5Utils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired(required = false)
    private AdminDao adminDao;


    /**
     * 登陆验证
     *
     * @param account
     * @param password
     * @return
     */
    @Override
    public Admin LoginAdmin(String account, String password) {

        Admin admin = adminDao.findByAccount(account);

        String md5Password = MD5Utils.md5("good" + password);

        if (account == "") {
            throw new RuntimeException("账号不能为空");
        }
        if (password == "") {
            throw new RuntimeException("密码不能为空");
        }
        if (admin == null) {
            throw new RuntimeException("账号错误");
        }

        if (!admin.getPassword().equals(md5Password)) {
            throw new RuntimeException("账号或者密码错误");
        }


        return admin;
    }

    @Override
    public void addAdmin(String account, String admName, String password, Integer rid) {

        Admin byAccount = adminDao.findByAccount(account);

        if (byAccount != null) {
            throw new RuntimeException("此账号已存在");
        }
        //设置盐值
        ByteSource salt = ByteSource.Util.bytes("good");

        String md5 = new SimpleHash("md5", password, salt, 1).toHex();

        HashMap<String, Object> map = new HashMap<>();
//        map.put("id", id);
        map.put("account", account);
        map.put("admName", admName);
        map.put("password", md5);
        map.put("rid", rid);

        adminDao.addAdmin(map);
    }

    @Override
    public List<Admin> findByPage(String account, String admName, String roleName, Integer limit, Integer page) {

        PageHelper.startPage(limit, page);

        List<Admin> list = adminDao.findAdminAll(account, admName, roleName);

        return list;
    }

    @Override
    public void deleteAdmin(Integer id) {
        adminDao.deleteAdmin(id);
    }

    @Override
    public Integer deleteManyAdmin(int[] idArr) {
        return adminDao.deleteManyAdmin(idArr);
    }

    @Override
    public Admin findById(Integer id) {
        Admin byId = adminDao.findById(id);

        return byId;
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminDao.updateAdmin(admin);
    }

    @Override
    public void updatePassword(String password, Integer id) {
//        Admin admin = adminDao.findPassword(password);
        Admin admin = adminDao.findById(id);
        if (password == admin.getPassword()) {
            throw new RuntimeException("请输入新密码");
        }

        //设置盐值
        ByteSource salt = ByteSource.Util.bytes("good");

        String md5 = new SimpleHash("md5", password, salt, 1).toHex();


        adminDao.updatePassword(md5, id);
    }

    @Override
    public Admin findAdmin() {
        Admin admin = adminDao.findAdmin();

        return admin;
    }
}
