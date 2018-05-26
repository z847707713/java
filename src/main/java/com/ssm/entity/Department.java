package com.ssm.entity;

import java.io.Serializable;
import java.util.Date;

public class Department implements Serializable{
  
	private Integer id;
	private String name;
	private Integer defaultRoleId;
	
	private Date createTime;
	private String createBy;
	private Date updateTime;
	private String updateBy;
	
	
	
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
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
	public Integer getDefaultRoleId() {
		return defaultRoleId;
	}
	public void setDefaultRoleId(Integer defaultRoleId) {
		this.defaultRoleId = defaultRoleId;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", defaultRoleId=" + defaultRoleId + ", createTime="
				+ createTime + ", createBy=" + createBy + ", updateTime=" + updateTime + ", updateBy=" + updateBy + "]";
	}

	
	
	
	
	 
	
	
}
