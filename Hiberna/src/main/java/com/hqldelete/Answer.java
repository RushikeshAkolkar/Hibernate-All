package com.hqldelete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	@Id
	@Column
	private int aid;
	
	private String ans;
	
	@ManyToOne
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

	public Question getQue1() {
		return que1;
	}

	public void setQue1(Question que1) {
		this.que1 = que1;
	}
}
