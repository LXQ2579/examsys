package com.damo.examsys.realm;

import com.damo.examsys.entity.User;
import com.damo.examsys.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;


/**
 * @author liujiulong
 * @date 2019/10/11  16:00:00
 */
public class MyRealm extends AuthorizingRealm {

//
    @Autowired
 //   @Lazy
    private UserService userService;
//
//    //获取授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //获取合法登陆的用户的用户名
        String name = (String) principalCollection.getPrimaryPrincipal();

        List<String> permsList = userService.findPermsByName(name);

        //创建授权信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(new HashSet<>(permsList));

        return info;
//        return null;
    }

//    //获取认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String uname = (String) authenticationToken.getPrincipal();
        User user = userService.findByName(uname);
        SimpleAuthenticationInfo info = null;

        if (user == null) {
            info = new SimpleAuthenticationInfo("", "", this.getName());
        } else {
            //身份认证信息对象
            //第一个参数: 用户身份信息 用户名
            //第二个参数: 用户身份信息 密码
            //第三个参数: realm的名称
            info = new SimpleAuthenticationInfo(uname, user.getPassword(), ByteSource.Util.bytes("haha"), this.getName());

        }
        return info;
//        return null;
    }
//
////设置simpleHash 加密方式模版
    public static void main(String[] args) {
        SimpleHash simpleHash = new SimpleHash("md5", "123", "haha", 1);
        System.out.println(simpleHash.toHex());
    }
}
