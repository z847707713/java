package com.ssm.criteria;

import java.util.Date;

public class CriteriaPermission {
	
	private Integer id;
	private String name;  //权限名称
	private String url;   //权限url
	private String type;  //(menu,button)
	private String permission;
	private Integer page = 1;
	
	public CriteriaPermission() {
		
	}
	
	public CriteriaPermission(Integer page) {
		super();
		this.page = page;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		if(page != null) {
			this.page = page;
		} else {
			this.page = 1;
		}
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	
	
}
