package com.ssm.entity;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    
	private Integer id;
	private String name;
	private String idCard;
	private String email;
	private String type;
	private Department department;
	
	private Date createTime;
	private String createBy;
	private Date updateTime;
	private String updateBy;
	
	
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
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	
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
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", idCard=" + idCard + ", email=" + email + ", type=" + type
				+ ", department=" + department + ", createTime=" + createTime + ", createBy=" + createBy
				+ ", updateTime=" + updateTime + ", updateBy=" + updateBy + "]";
	}
	
	
	
	
	
	
	
}
