package com.lk.oa.dao.base;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * crud������
 * @author Administrator
 *
 */
public interface BaseDao<T> {
	/**
	 * ��ѯ���ж���
	 * @return
	 */
	public List<T> getALLEntry();
	/**
	 * ����ID��ѯĳһ����
	 * @param id
	 * @return
	 */
	public T getEntryById(Serializable id);
	/**
	 * ���¶���
	 * @param t
	 */
	public void updateEntry(T t);
	/**
	 * ����IDɾ������
	 * @param id
	 */
	public void deleteEntry(Serializable id);
	/**
	 * �������
	 * @param t
	 */
	public void saveEntry(T t);
	
	
	public  Set<T> getEntrysByIds(Serializable[] Serializables);
	
}
