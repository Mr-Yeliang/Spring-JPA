package com.example.demo.pository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.User;

public interface UserDao extends JpaRepository<User, String> {

	List<User> findByUname(String uname);

	List<User> findByUnameAndUid(String uname, String uid);

	List<User> findByPasswordOrderByUidDesc(String pwd);

	// @Query("select u from User u left join u.org o left join u.roles r where
	// o.oname=:oname and r.role=:role ")
	@Query(nativeQuery = true, value = "select u.* from user u LEFT JOIN org o on u.oid=o.oid"
			+ " LEFT JOIN user_role m on u.uid=m.uid" + " LEFT JOIN role r ON r.rid=m.rid"
			+ " where o.oname=:oname and r.role=:role")
	List<User> findByOnameAndRole(@Param("oname") String oname, @Param("role") String role);
}
