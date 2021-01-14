package com.bd.thinkinginspring.config;

import com.alibaba.fastjson.JSONObject;
import com.bd.thinkinginspring.entity.PermissionRoleEntity;
import com.bd.thinkinginspring.entity.UserInfoEntity;
import com.bd.thinkinginspring.entity.UserRoleEntity;
import com.bd.thinkinginspring.service.PermissionRoleService;
import com.bd.thinkinginspring.service.UserInfoService;
import com.bd.thinkinginspring.service.UserRoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;

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
        UserInfoEntity userInfoEntity = (UserInfoEntity) principals.getPrimaryPrincipal();
        String principal = (String)getAvailablePrincipal(principals);
        if ("sucy".equals(principal)) {
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            authorizationInfo.addRole("admin");
            authorizationInfo.addStringPermission("user:delete");
            return authorizationInfo;
        }
        return null;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        // 获取用户的输入的账号.
        String userName = (String) token.getPrincipal();
        if (userName == null) {
            LOGGER.warn(String.format("user [%s] not exists and return", userName));
            return null;
        }
        LOGGER.info("MyShiroRealm.doGetAuthenticationInfo()");
        // 获取用户的输入的密码
        LOGGER.info(JSONObject.toJSONString(token));
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserInfoEntity userInfo = userInfoService.findByName(userName);

        LOGGER.info(String.format("current user info is : %s", userInfo));
        // 进行认证，将正确数据给shiro处理
        // 密码不用自己比对，AuthenticationInfo认证信息对象，一个接口，new他的实现类对象SimpleAuthenticationInfo
        /*	第一个参数随便放，可以放user对象，程序可在任意位置获取 放入的对象
         *  第二个参数必须放密码，
         *  第三个参数放 当前realm的名字，因为可能有多个realm*/
        AuthenticationInfo aInfo = new SimpleAuthenticationInfo(userInfo.getUserName(),userInfo.getPassword(),getName());

        return aInfo;
    }

}
