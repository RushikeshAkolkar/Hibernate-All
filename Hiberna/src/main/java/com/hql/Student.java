package com.hql;
import javax.persistence.Cacheable;
// video - 6
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;

@Entity
@Cacheable  //video - 28
public class Student {
	@Id
	private int id;
	
	private String name;
	
	private String city;
	//video No 23
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
