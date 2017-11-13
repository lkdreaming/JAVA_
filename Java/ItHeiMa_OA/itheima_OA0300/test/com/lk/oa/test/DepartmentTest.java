package com.lk.oa.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lk.oa.model.Department;
import com.lk.oa.service.DepartmentService;

public class DepartmentTest {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	DepartmentService departmentService = (DepartmentService) ctx.getBean("departmentService");
	Department department;
	
	@Test
	public void SaveDepartment() {
		department = new Department();
		department.setName("������");
		department.setDescription("���ܴ����Ĳ���");
		departmentService.saveEntry(department);
	}
	
	@Test
	public void getAllDepartment() {
		SaveDepartment();
		department = new Department();
		departmentService.getALLEntry();
	}
}
