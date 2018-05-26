package com.ssm.shiro;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.entity.User;
import com.ssm.service.UserService;
import com.ssm.service.impl.UserServiceImpl;

public class ShiroRealm extends AuthorizingRealm {
  
	@Autowired
	private UserService userService;
	
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		//1.从PrincipalCollection 获取登录用户的信息
        Object principal = principals.getPrimaryPrincipal();
        
        //2. 利用登录的用户的信息来查询当前用户的角色或权限(可能需要查询数据库)
        Set<String> roles = userService.getRoleStrByUerName(principal.toString());
        Collection<String> permissions = userService.getUsersPermissionStrByName(principal.toString());
        
        //3.创建SimpleAuthorizationInfo,并设置其Reals 属性
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
        info.addStringPermissions(permissions);
        //4.返回SimpleAuthorizationInfo
        return info;
	}
    
	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		//1.把AuthenticationToken 强转
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		//2.从usernamePasswordToken 中获取username
		String username = usernamePasswordToken.getUsername();
		//3.从数据库中查询username对应的记录
		User user = userService.getUserByUserName(username);
		System.out.println(user);
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(),getName());
		
		return info;
	}

}
