package com.online.exam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
   
@Entity
@Table (name="exam_candidate")
public class Candidate {
	@Id
	private Integer candidateId;
	private String fullName;
	private String eMail;
	private Long phonenumber;
	private String password;
	private String city;
	private String college;
	private String score;
	private String status;
	
	
	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Candidate(Integer candidateId, String fullName, String eMail, Long phonenumber, String password, String city,
			String college) {
		super();
		this.candidateId = candidateId;
		this.fullName = fullName;
		this.eMail = eMail;
		this.phonenumber = phonenumber;
		this.password = password;
		this.city = city;
		this.college = college;
	}
	
	public Candidate(Integer candidateId, String fullName, String eMail, Long phonenumber, String password, String city,
			String college, String score, String status) {
		super();
		this.candidateId = candidateId;
		this.fullName = fullName;
		this.eMail = eMail;
		this.phonenumber = phonenumber;
		this.password = password;
		this.city = city;
		this.college = college;
		this.score = score;
		this.status = status;
	}
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}	
}
