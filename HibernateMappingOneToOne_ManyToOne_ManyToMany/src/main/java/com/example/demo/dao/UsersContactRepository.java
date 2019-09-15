package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.UsersContact;

public interface UsersContactRepository extends JpaRepository<UsersContact, Integer> {
	//select phone_no,name,salary from users,users_contact where users.user_id=users_contact.user_id
	
	// for whole table 
//	@Query(
//			  value = "select * from users_contact", 
//			  nativeQuery = true)
//	List<UsersContact> findContactAndName();
//	
	
	@Query(
			  value = "select phone_no,name,salary from users,users_contact where users.user_id=users_contact.user_id", 
			  nativeQuery = true)
	List<?> findContactAndName(); // or we can use Object[] as a generic
	
	// for update and delete query
	@Transactional
	@Modifying
	@Query(
			  value = "update users_contact set phone_no=34234", 
			  nativeQuery = true)
	int updateUsersContact(); 
	
	
	
	@Transactional
	@Modifying
	@Query(
			  value = "delete from users_contact where id=1", 
			  nativeQuery = true)
	int deleteUsersContact(); 
	
}
