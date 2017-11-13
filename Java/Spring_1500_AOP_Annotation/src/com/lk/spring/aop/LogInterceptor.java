package com.lk.spring.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogInterceptor {
	@Before("execution(public void com.lk.spring.dao.impl.UserDAOImpl.save(com.lk.spring.model.User))")
	public void before() {
		System.out.println("before method");
	}
	
	@AfterReturning("execution(public * com.lk.spring.dao..*.*(..))")
	public void after() {
		System.out.println("after method");
	}
}