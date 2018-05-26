package com.ssm.criteria;

import java.util.Date;
import java.util.List;

import com.ssm.entity.Permission;

public class CriteriaRole {
   
	private Integer page = 1;
	private String id;
	private String roleName;
	private String roleDesc;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public String getId() {
		return id;
	}
	public void setId(Integer id) {
		if(id != null) {
			this.id = "%"+ id +"%";
		} 
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = "%"+roleName+ "%";
		
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = "%"+ roleDesc +"%";
	}
	public CriteriaRole(Integer page) {
		super();
		this.page = page;
	}
	public CriteriaRole() {
		super();
	}
    
	
	
	
}
