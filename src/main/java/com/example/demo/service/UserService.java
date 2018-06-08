package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Org;
import com.example.demo.domain.User;

/**
 * 服务接口
 * @author Loner
 *
 */
public interface UserService {

	public User findUser(String uid);
	public void saveUsers(List<User> users);
	public void delUser(String uid);
	
	public List<User> findByUname(String uname);
	public List<User> findByUnameAndUid(String uname,String uid);
	public List<User> findByPasswordOrderByUidDesc(String pwd);
	public List<User> findByOnameAndRole(String oname,String role);
}
