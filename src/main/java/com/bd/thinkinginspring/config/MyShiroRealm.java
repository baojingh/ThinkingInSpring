package com.bd.thinkinginspring.config;

import com.alibaba.fastjson.JSONObject;
import com.bd.thinkinginspring.entity.UserInfoEntity;
import com.bd.thinkinginspring.service.PermissionRoleService;
import com.bd.thinkinginspring.service.UserInfoService;
import com.bd.thinkinginspring.service.UserRoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;

/**
 * @Author: baojing.he
 * @Date: 2021/1/9 22:00
 * @Description:
 */
public class MyShiroRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyShiroRealm.class);

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private PermissionRoleService permissionRoleService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        LOGGER.info("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        if (principals == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }

        UserInfoEntity user = (UserInfoEntity) getAvailablePrincipal(principals);
        LOGGER.info("user info: " + JSONObject.toJSONString(user));

        if ("sucy".equals(user.getUserName())) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            HashSet<String> roleSet = new HashSet<>();
            roleSet.add("admin");
            info.setRoles(roleSet);

            HashSet<String> permissionSet = new HashSet<>();
            permissionSet.add("user:delete");
            info.setRoles(permissionSet);
            info.setStringPermissions(permissionSet);
            return info;
        } else {
            return null;
        }

    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        // Null username is invalid
        if (username == null) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        }
        UserInfoEntity userDB = userInfoService.findByName(username);
        if (userDB == null) {
            throw new UnknownAccountException("No account found for user [" + username + "]");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userDB, userDB.getPassword(), getName());
        return info;
    }

}
