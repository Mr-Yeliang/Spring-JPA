package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.pository.UserDao;

@Service
public class UserServiceImplement implements UserService {
	@Autowired
	UserDao userDao;

	@Transactional
	@Override
	public User findUser(String uid) {
		return userDao.findOne(uid);
	}

	@Transactional
	@Override
	public void saveUsers(List<User> users) {
		userDao.save(users);
	}

	@Transactional
	@Override
	public void delUser(String uid) {
		userDao.delete(uid);
	}

	@Override
	public List<User> findByUname(String uname) {
		return userDao.findByUname(uname);
	}

	@Override
	public List<User> findByUnameAndUid(String uname, String uid) {
		return userDao.findByUnameAndUid(uname, uid);
	}

	@Override
	public List<User> findByPasswordOrderByUidDesc(String pwd) {
		return userDao.findByPasswordOrderByUidDesc(pwd);
	}

	@Override
	public List<User> findByOnameAndRole(String oname, String role) {
		return userDao.findByOnameAndRole(oname, role);
	}

}