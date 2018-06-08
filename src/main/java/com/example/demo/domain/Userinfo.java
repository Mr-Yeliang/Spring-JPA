package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the userinfo database table.
 * 
 */
@Entity
@NamedQuery(name="Userinfo.findAll", query="SELECT u FROM Userinfo u")
public class Userinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private int age;

	private String email;

	private String hoby;

	private String sex;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="uid")
	private User user;

	public Userinfo() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHoby() {
		return this.hoby;
	}

	public void setHoby(String hoby) {
		this.hoby = hoby;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}