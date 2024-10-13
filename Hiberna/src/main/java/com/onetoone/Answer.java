package com.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answer {
	@Id
	@Column
	private int aid;
	
	private String ans;
	
	@OneToOne(mappedBy="ans")
	private Question que1;
	
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public Answer(int aid, String ans) {
		super();
		this.aid = aid;
		this.ans = ans;
	}
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question getQue1() {
		return que1;
	}
	public void setQue1(Question que1) {
		this.que1 = que1;
	}
	
}
