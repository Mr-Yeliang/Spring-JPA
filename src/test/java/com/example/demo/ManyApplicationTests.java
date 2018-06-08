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

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyApplicationTests {
	@Inject
	EntityService es;

	/**
	 * 在一的一方添加记录（包含多的一方的数据），只能添加到一成功，添加到多不成功
	 */
	@Test
	public void saveOnOne() {

		User u = new User();
		u.setUid("111");
		u.setPassword("111");
		u.setUname("叶亮");
		Org org = new Org();
		List<User> list = new ArrayList<>();
		list.add(u);
		org.setUsers(list);
		org.setOname("北京市公安局");
		org.setOid("1000");
		es.saveOrg(org);

	}

	/**
	 * 在多的一方添加记录，记录中同时添加一的数据，必须在实体类中一的对象的@ManyToOne注解增加cascade=CascadeType.PERSIST
	 */
	@Test
	public void saveOnMany() {
		Org org = new Org();
		org.setOid("2000");
		org.setOname("北京市教育部");

		User u = new User();
		u.setUid("333");
		u.setPassword("ccc");
		u.setUname("王五");
		u.setOrg(org);
		es.saveUser(u);
	}

	/**
	 * 在多的一方添加记录
	 */
	@Test
	public void saveOnManyByFind() {
		User u = new User();
		u.setUid("222");
		u.setPassword("bbb");
		u.setUname("李四");
		u.setOrg(es.findOrg("1000"));
		es.saveUser(u);
	}

	/**
	 * 要在一的一方删除记录，如果多的一方有关联记录则不能删除，非要删除则在@OneToMany中添加cascade=CascadeType.REMOVE
	 */
	@Test
	public void delOrg() {
		es.delOrg("2000");
	}

}
