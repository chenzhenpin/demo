package com.example.demo.shiro;

import com.example.demo.dataobject.ShiroEntity.ShiroPermission;
import com.example.demo.dataobject.ShiroEntity.ShiroRole;
import com.example.demo.dataobject.ShiroEntity.ShiroUser;
import com.example.demo.service.jpaService.ShiroService;
import org.apache.shiro.SecurityUtils;
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

public class MyShiroRealm extends AuthorizingRealm {
    //用于用户查询
    @Autowired
    ShiroService shiroService;

    //角色权限和对应权限添加
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        ShiroUser userInfo  = (ShiroUser)principals.getPrimaryPrincipal();
        for(ShiroRole role:userInfo.getRoleList()){
            authorizationInfo.addRole(role.getRole());
            for(ShiroPermission p:role.getPermissions()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }


    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String) token.getPrincipal();
        ShiroUser shiroUser=null;
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        shiroUser = shiroService.findFirstByUsername(username);
        System.out.println("----->>userInfo=" + shiroUser);
        if (shiroUser == null) {
            System.out.println("登陆认证失败==============");
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                username, //用户名
                shiroUser.getPassword(), //密码
                ByteSource.Util.bytes(shiroUser.getSalt()),
                this.getName()  //realm name
        );

        return authenticationInfo;
    }

    //清除缓存
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }
}
