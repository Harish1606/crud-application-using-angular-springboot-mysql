package com.cts.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String email_id;
	private String user_name;
	private String mobile_no;
	private String qualification;
	public User() {
	}
	public User(Integer id, String email_id, String user_name, String mobile_no, String qualification) {
		super();
		this.id = id;
		this.email_id = email_id;
		this.user_name = user_name;
		this.mobile_no = mobile_no;
		this.qualification = qualification;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email_id=" + email_id + ", user_name=" + user_name + ", mobile_no=" + mobile_no
				+ ", qualification=" + qualification + "]";
	}

}
