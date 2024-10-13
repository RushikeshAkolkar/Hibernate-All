package com.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {
	@Id
	private int eid;
	private String name;
	@ManyToMany
	@JoinTable(name="emp_info")
	private List<Project> pro;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Project> getPro() {
		return pro;
	}
	public void setPro(List<Project> pro) {
		this.pro = pro;
	}
	public Employee(int eid, String name, List<Project> pro) {
		super();
		this.eid = eid;
		this.name = name;
		this.pro = pro;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
