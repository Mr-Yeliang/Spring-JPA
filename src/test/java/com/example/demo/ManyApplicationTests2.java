package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Org;
import com.example.demo.domain.User;
import com.example.demo.service.EntityService;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImplement;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyApplicationTests2 {
	@Inject
	UserServiceImplement usi;

	@Inject
	EntityService es;

	@Test
	public void findUser() {
		User user = usi.findUser("111");
		System.out.println("\n---------------------");
		System.out.println(user);
		System.out.println("---------------------\n");
	}

	@Test
	public void saveUser() {
		List<User> users = new ArrayList<>();
		for (int i = 444; i < 888; i = i + 111) {
			User u = new User();
			u.setUid(String.valueOf(i));
			u.setPassword("bbb");
			u.setUname("李四");
			u.setOrg(es.findOrg("1000"));
			users.add(u);
		}
		usi.saveUsers(users);
	}

	@Test
	public void delUser() {
		usi.delUser("777");
	}

	@Test
	public void findByUname() {
		List<User> users = usi.findByUname("李四");
		System.out.println("\n----------------------");
		for (User user : users) {
			System.out.println(user);
		}
		System.out.println("---------------------\n");
	}

	@Test
	public void findByUnameAndUid() {
		List<User> users = usi.findByUnameAndUid("李四", "444");
		System.out.println("\n----------------------");
		for (User user : users) {
			System.out.println(user);
		}
		System.out.println("---------------------\n");
	}

	@Test
	public void findByPasswordOrderByUidDesc() {
		List<User> users = usi.findByPasswordOrderByUidDesc("bbb");
		System.out.println("\n---------------------");
		for (User user : users) {
			System.out.println(user);
		}
		System.out.println("---------------------\n");
	}

	@Test
	public void findByOnameAndRole() {
		List<User> users = usi.findByOnameAndRole("北京市公安局", "超级管理员");
		System.out.println("\n---------------------");
		for (User user : users) {
			System.out.println(user);
		}
		System.out.println("---------------------\n");
	}

}
