package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the org database table.
 * 
 */
@Entity
@NamedQuery(name="Org.findAll", query="SELECT o FROM Org o")
public class Org implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String oid;

	private String oname;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="org"/*,cascade=CascadeType.REMOVE*/)//添加了cascade=CascadeType.REMOVE将会在删除Org表的记录时删除关联表的相关记录
	private List<User> users;

	public Org() {
	}

	public String getOid() {
		return this.oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getOname() {
		return this.oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setOrg(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setOrg(null);

		return user;
	}

	@Override
	public String toString() {
		return "Org [oid=" + oid + ", oname=" + oname + "]";
	}

}