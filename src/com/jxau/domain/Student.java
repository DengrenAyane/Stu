package com.jxau.domain;

import java.util.Date;

public class Student {

	private int sid;
	private String sname;
	private String gender;
	private String phone;
	private Date birthday;
	private String hobby;
	private String info;
	
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int sid, String sname, String gender, String phone, Date date, String hobby, String info) {
		super();
		this.sid=sid;
		this.sname = sname;
		this.gender = gender;
		this.phone = phone;
		this.birthday = date;
		this.hobby = hobby;
		this.info = info;
	}
	
	public Student( String sname, String gender, String phone, Date date, String hobby, String info) {
		super();
		this.sname = sname;
		this.gender = gender;
		this.phone = phone;
		this.birthday = date;
		this.hobby = hobby;
		this.info = info;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

}
