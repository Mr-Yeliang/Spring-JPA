package com.example.demo.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Org;
import com.example.demo.domain.User;

@Service
public class EntityService {
	@Inject
	EntityManager em;

	@Transactional
	public List<User> findAll() {
		List<User> list = em.createQuery("Select u from User u").getResultList();
		return list;
	}

	@Transactional
	public User findUser(String id) {
		return em.find(User.class, id);
	}

	@Transactional
	public Org findOrg(String id) {
		return em.find(Org.class, id);
	}

	@Transactional
	public void saveUser(User user) {
		em.persist(user);
	}

	@Transactional
	public void saveOrg(Org org) {
		em.persist(org);
	}

	@Transactional
	public void delOrg(String  id) {
		Org org=em.find(Org.class, id);
		em.remove(org);
	}

}
