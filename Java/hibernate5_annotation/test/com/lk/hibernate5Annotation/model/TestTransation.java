package com.lk.hibernate5Annotation.model;
import static org.junit.Assert.*;

import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lk.hibernate5Annotation.model.Event;


public class TestTransation {
/*	private static SessionFactory sessionFactory ;
	
	@BeforeClass
	public static void beforeClass() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}*/

	@Test
	public void test() {
		Session session = HibernateUtil
		session.beginTransaction();
		session.save( new Event( "Our very first event!", new Date() ) );
		session.save( new Event( "A follow up event", new Date() ) );
		session.getTransaction().commit();
		session.close();
	}

}