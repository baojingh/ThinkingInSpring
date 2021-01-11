package com.bd.thinkinginspring.config;

import com.bd.thinkinginspring.entity.UserInfoEntity;
import com.bd.thinkinginspring.entity.UserRoleEntity;
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
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.management.relation.RoleInfo;
import java.util.List;

/**
 * @Author: baojing.he
 * @Date: 2021/1/9 22:00
 * @Description:
 */
public class MyShiroRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyShiroRealm.class);

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private UserRoleService userRoleService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        LOGGER.info("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfoEntity userInfo  = (UserInfoEntity)principals.getPrimaryPrincipal();
        List<UserRoleEntity> roleList = userRoleService.findRoleList(userInfo.getId());



        for(UserRoleEntity role:roleList){
            authorizationInfo.addRole(role.getRole());
            for(SysPermission p:role.getPermissions()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        LOGGER.info("MyShiroRealm.doGetAuthenticationInfo()");
        // 获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        // 获取用户的输入的密码
        LOGGER.info(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserInfo userInfo = userInfoService.findByUsername(username);
        LOGGER.info("----->>userInfo="+userInfo);
        if(userInfo == null){
            return null;
        }

        // 进行认证，将正确数据给shiro处理
        // 密码不用自己比对，AuthenticationInfo认证信息对象，一个接口，new他的实现类对象SimpleAuthenticationInfo
        /*	第一个参数随便放，可以放user对象，程序可在任意位置获取 放入的对象
         *  第二个参数必须放密码，
         *  第三个参数放 当前realm的名字，因为可能有多个realm*/
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.getSalt()),
                getName()  //realm name
        );
        //清除之前的授权信息
        super.clearCachedAuthorizationInfo(authenticationInfo.getPrincipals());
        // 存入用户对象
        SecurityUtils.getSubject().getSession().setAttribute("login", userInfo);
        // 返回给安全管理器，securityManager，由securityManager比对数据库查询出的密码和页面提交的密码
        // 如果有问题，向上抛异常，一直抛到控制器
        return authenticationInfo;
    }

}
