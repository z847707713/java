package com.ssm.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import com.ssm.utils.DateUtils;

public class Permission implements Serializable {
   
	private Integer id;
	private String name;  //权限名称
	private String url;   //权限url
	private String type;  //(menu,button)
	private String permission;
	private Date createTime;
	private String createBy;
	private Date updateTime;
	private String updateBy;
	private String createTimeStr;
	private String updateTimeStr;
	
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
		this.createTimeStr = DateUtils.format(createTime);
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
		this.updateTimeStr = DateUtils.format(updateTime);
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
	@Override
	public String toString() {
		return "Permission [id=" + id + ", name=" + name + ", url=" + url + ", type=" + type + ", permission="
				+ permission + ", createTime=" + createTime + ", createBy=" + createBy + ", updateTime=" + updateTime
				+ ", updateBy=" + updateBy + "]";
	}
	
	
    	
	
	
}
