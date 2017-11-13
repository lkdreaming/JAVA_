package com.lk.hibernate.model;

import java.io.Serializable;

//����������Ҫʵ��Serializable�ӿ�
public class WifePK implements Serializable{
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	//��дequals()��hashCode()����
	@Override
	public boolean equals(Object o) {
		if (o instanceof WifePK) {
			WifePK wifePK = (WifePK)o;
			if(this.id == wifePK.getId() && (this.name.equals(wifePK.getName()))) {
				return true;
			}
				
		}
		return false;
	}
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
}
