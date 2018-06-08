package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String password;

	private String uname;

	// bi-directional many-to-one association to Org
	@ManyToOne( cascade=CascadeType.PERSIST ) // cascade=CascadeType.PERSIST 集联增加，在添加User时会将其Org也添加到Org表中
	@JoinColumn(name = "oid")
	private Org org;

	// bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(name = "`user-role`", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns = {
			@JoinColumn(name = "rid") })
	private List<Role> roles;

	// bi-directional one-to-one association to Userinfo
	@OneToOne(mappedBy = "user")
	private Userinfo userinfo;

	public User() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Org getOrg() {
		return this.org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", password=" + password + ", uname=" + uname + "]";
	}

}