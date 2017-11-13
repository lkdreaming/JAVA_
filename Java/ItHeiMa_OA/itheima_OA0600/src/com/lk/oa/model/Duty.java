package com.lk.oa.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Duty implements Serializable {
	private long dutyId;//主键
	private long pid;//父节点ID
	private String name;
	private boolean isParent;
	private String Description;
	private Set<User> users;
	
	@Id
	@GeneratedValue
	public long getDutyId() {
		return dutyId;
	}
	public void setDutyId(long dutyId) {
		this.dutyId = dutyId;
	}
	public long getPid() {
		return pid;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return Description;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	@ManyToMany(mappedBy = "duties")
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public boolean isParent() {
		return isParent;
	}
	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}
	
}