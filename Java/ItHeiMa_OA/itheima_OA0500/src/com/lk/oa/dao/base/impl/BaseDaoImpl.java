package com.lk.oa.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.lk.oa.dao.base.BaseDao;


public class BaseDaoImpl<T> implements BaseDao<T> {
	private HibernateTemplate hibernateTemplate;
	//����T��ʵ������
	private Class classT;
	private ClassMetadata metaData;
	/**
	 * �ڸ��������ʵ����֮��,���캯���л�÷��͵�ʵ������,�����Ƹ�classT.
	 */
	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		classT = (Class) type.getActualTypeArguments()[0];
	}
	
	/**
	 * �ڳ�ʼ�����캯��֮��,�����Ż�ȡ�����Ͳ���T��Ԫ���ݶ���
	 */
	@PostConstruct
	public void init() {
		metaData = hibernateTemplate.getSessionFactory().getClassMetadata(classT);
	}
	
	
	@Override
	public List<T> getALLEntry() {
		return (List<T>)hibernateTemplate.find("from " + classT.getName());
	}

	@Override
	public T getEntryById(Serializable id) {
		return (T) hibernateTemplate.get(classT, id);
	}

	

	

	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	@Override
	public void updateEntry(T t) {
		hibernateTemplate.update(t);
		
	}


	@Override
	public void saveEntry(T t) {
		System.out.println(classT.getName());
		hibernateTemplate.save(t);		
	}
	
	@Override
	public void deleteEntry(Serializable id) {
		T t = getEntryById(id);
		hibernateTemplate.delete(t);
		
	}


	@Override
	public Set<T> getEntrysByIds(Serializable[] serializables) {
		/**
		 * ƴ��HQL���
		 */
		String query = "from " + classT.getName();//from ����
		query += " where " + metaData.getIdentifierPropertyName();// where �ֶ���(�˴���ID)
		query += " in (";
		/**
		 * ����serializables�����е�ֵ:��������һ��ֵ���Ӷ���,���������Ӷ���.
		 */
		for(int i = 0; i < serializables.length; i++) {
			if(i == serializables.length - 1) {
				query += serializables[i];
			}else {
				query += serializables[i] + ",";
			}
		}
		//�ӷ�����,ƴ��HQL������.
		query += ")";
		return null;
	}


	

}
