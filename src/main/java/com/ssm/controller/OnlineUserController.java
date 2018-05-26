package com.ssm.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.session.mgt.DefaultWebSessionContext;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.subject.support.DefaultWebSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.utils.DateUtils;
import com.ssm.utils.LayuiJsonUtils;

@Controller
public class OnlineUserController {
   
	@Autowired
	SessionDAO sessionDao;
	
	@RequestMapping("/onlineUser")
	public String onlineUser() {
	
		return "onlineUser";
	}
	
	@ResponseBody
	@RequestMapping(value="/onlineUserTable",produces="text/json;charset=UTF-8")
	public String onlineUserTable(@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="limit",required=false) Integer limit) {
		if(page == null) {
			page = 1;
		}
		if(limit == null) {
			limit = 10;
		}
		Collection<Session> sessions = sessionDao.getActiveSessions();
		List<Map<String,Object>> maps = new ArrayList<Map<String,Object>>();
		for(Session session: sessions) {
			SimplePrincipalCollection simplePrincipalCollection = 
					(SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
			
			if(simplePrincipalCollection != null) {
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("ip", session.getHost());
				
				map.put("username",simplePrincipalCollection.toString());
				map.put("lastTime",DateUtils.format(session.getLastAccessTime()));
				maps.add(map);
			}
			
		}
		
		if((page * 10 -1) > maps.size()) {
			maps.subList((page-1) * 10,maps.size());
		} else {
			maps.subList((page-1) * 10,(page * 10 -1));
		}
		
		
		StringBuilder builder = LayuiJsonUtils.paseToJson(sessions.size(),maps);
		return builder.toString();
	}
	
	@ResponseBody
	@RequestMapping("removeOnlineUser")
	public String removeOnlineUser(@RequestParam("username") String username) {
		
		Collection<Session> sessions = sessionDao.getActiveSessions();
		
		for(Session session : sessions) {
		    
			String loginName = String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
			
			if(username.equals(loginName) ) {

				session.setTimeout(0);//设置session立即失效，即将其踢出系统
				break;
		   }
		}
		
		return "";
	}
	
	
}
