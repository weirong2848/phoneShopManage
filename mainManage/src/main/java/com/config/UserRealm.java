package com.config;

import com.entity.CommonResult;
import com.entity.User;
import com.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class UserRealm extends AuthorizingRealm {

    @Resource
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        CommonResult<User> renturnResult = userService.selectUserByEmail(userToken.getUsername());
        if (renturnResult.getData() == null) {
            return null;
        }
        return  new SimpleAuthenticationInfo(renturnResult.getData(),renturnResult.getData().getPassword(),"");
    }
}
