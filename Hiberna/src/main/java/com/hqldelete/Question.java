package com.hqldelete;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {
	@Id
	@Column(name="question_id")
	private int qid;
	
	private String que;
	
	@OneToMany(mappedBy = "que1" , fetch=FetchType.EAGER)
	private List<Answer> ans1;

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getQue() {
		return que;
	}

	public void setQue(String que) {
		this.que = que;
	}

	public List<Answer> getAns1() {
		return ans1;
	}

	public void setAns1(List<Answer> ans1) {
		this.ans1 = ans1;
	}

	public Question(int qid, String que, List<Answer> ans1) {
		super();
		this.qid = qid;
		this.que = que;
		this.ans1 = ans1;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}