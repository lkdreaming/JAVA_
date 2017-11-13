package com.lk.oa.action.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	private Class classT;
	private T t;
	//�ڹ��캯���л�÷��͵�ʵ�����Ͳ���ֵ��classT,�����ڸ���ʵ����ModelDriven�ӿ�,������classT.newInstance()ʵ����t
	public BaseAction() {
		ParameterizedType type =  (ParameterizedType) this.getClass().getGenericSuperclass();
		classT = (Class) type.getActualTypeArguments()[0];
		try {
			t = (T) classT.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static final String LISTACITON = "listAction";
	public String listAction = LISTACITON;  //��ת����ѯҳ��
	
	public static final String ADDUI = "addUI";
	public String addUI = ADDUI;  //��ת�����ҳ��
	
	public static final String UPDATEUI = "updateUI";
	public String updateUI = UPDATEUI;  //��ת������ҳ��
	
	public static final String ACTION2ACTION = "action2action";
	public String action2action = ACTION2ACTION;  //action��ת��action
	
	@Override
	public T getModel() {
		return t;
	}

}
