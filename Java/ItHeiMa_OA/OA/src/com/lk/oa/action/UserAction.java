package com.lk.oa.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lk.oa.action.base.BaseAction;
import com.lk.oa.model.Department;
import com.lk.oa.model.Role;
import com.lk.oa.model.User;
import com.lk.oa.service.DepartmentService;
import com.lk.oa.service.RoleService;
import com.lk.oa.service.UserService;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction {
	private User user;
	private Long userId;
	private DepartmentService ds;
	private List<Role> roles;
	private Long roleId;
	private Department department;
	private RoleService rs;
	private UserService us;
	private List<User> users;
	private List<Department> departments;
	
	public String showAllUsers() {
		this.users = this.us.getAllEntries();
		return listAction;
	}
	
	public String addUI() {
		this.departments = this.ds.getAllEntries();
		this.roles = this.rs.getAllEntries();
		return addUI;
	}
	
	public String add() {
		this.user.setDepartment(this.department);
		this.us.saveEntry(user);
		return Action2Action;
	}
	
	public User getUser() {
		return user;
	}
	public Long getUserId() {
		return userId;
	}
	public DepartmentService getDs() {
		return ds;
	}
	public Long getRoleId() {
		return roleId;
	}
	public Department getDepartment() {
		return department;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Resource(name = "departmentService")
	public void setDs(DepartmentService ds) {
		this.ds = ds;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public UserService getUs() {
		return us;
	}
	
	@Resource(name = "userService")
	public void setUs(UserService us) {
		this.us = us;
	}

	public List<Role> getRoles() {
		return roles;
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public RoleService getRs() {
		return rs;
	}

	@Resource(name = "roleService")
	public void setRs(RoleService rs) {
		this.rs = rs;
	}

	
}