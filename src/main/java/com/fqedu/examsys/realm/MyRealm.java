package com.fqedu.examsys.realm;

import com.fqedu.examsys.dao.AdminDao;
import com.fqedu.examsys.entity.Admin;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;

public class MyRealm extends AuthorizingRealm {

    @Autowired(required = false)
    private AdminDao adminDao;


    // 获取授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取登陆用户的账号
        String account = (String) principalCollection.getPrimaryPrincipal();
        // 从数据库中查询用户的角色和权限列表信息
//        List<String> perms = userDao.findPermsByName(username);
//        List<String> roles = userDao.findRolesByName(username);
        List<String> permAccount = adminDao.findPermAccount(account);

        List<String> roleAccount = adminDao.findRoleAccount(account);


        // 创建授权信息对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 设置角色和权限信息
//        info.setRoles(new HashSet<>(roles));
//        info.setStringPermissions(new HashSet<>(perms));
        info.setRoles(new HashSet<>(roleAccount));
        info.setStringPermissions(new HashSet<>(permAccount));

        return info;
    }

    // 获取认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        // 获取token中的账号
        String account = (String) authenticationToken.getPrincipal();

        // 认证信息对象
        SimpleAuthenticationInfo simpleAuthenticationInfo = null;
        // 从数据库中获取用户信息
//        User user = userDao.findByName(username);
        Admin admin = adminDao.findByAccount(account);



        if (admin == null) {
//            simpleAuthenticationInfo = new SimpleAuthenticationInfo(null, null, this.getName());
            throw new RuntimeException("账户不存在");
        } else {
            // 第一个参数 用户身份信息
            // 第二个参数 用户的合法密码
            // 第三个参数 realm的名称
//            simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, user.getPassword(), this.getName());
            // 如果使用md5进行处理，使用slat值的情况下，需要创建对象时，通过第三个参数指定slat值
            simpleAuthenticationInfo = new SimpleAuthenticationInfo(account, admin.getPassword(), ByteSource.Util.bytes("good"), this.getName());
        }

        return simpleAuthenticationInfo;
    }

//    public static void main(String[] args) {
//        String s = new SimpleHash("md5", "123", "Nice", 1).toHex();
//
//        System.out.println(s);
//    }
}





