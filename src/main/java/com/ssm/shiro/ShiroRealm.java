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
	 * ��Ȩ
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		//1.��PrincipalCollection ��ȡ��¼�û�����Ϣ
        Object principal = principals.getPrimaryPrincipal();
        
        //2. ���õ�¼���û�����Ϣ����ѯ��ǰ�û��Ľ�ɫ��Ȩ��(������Ҫ��ѯ���ݿ�)
        Set<String> roles = userService.getRoleStrByUerName(principal.toString());
        Collection<String> permissions = userService.getUsersPermissionStrByName(principal.toString());
        
        //3.����SimpleAuthorizationInfo,��������Reals ����
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
        info.addStringPermissions(permissions);
        //4.����SimpleAuthorizationInfo
        return info;
	}
    
	/**
	 * ��֤
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		//1.��AuthenticationToken ǿת
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		//2.��usernamePasswordToken �л�ȡusername
		String username = usernamePasswordToken.getUsername();
		//3.�����ݿ��в�ѯusername��Ӧ�ļ�¼
		User user = userService.getUserByUserName(username);
		System.out.println(user);
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(),getName());
		
		return info;
	}

}
