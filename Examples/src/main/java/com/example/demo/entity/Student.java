package com.example.demo.entity;

public class Student {
	
	int rid;
	String name;

	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Student(){}
	public Student(int id, String name) {
		rid=id;
		this.name = name;
	}

}
