package com.model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	// method to get the username 
	@Query("select u from User u where u.email=:email")
	public User getUserByUserName(@Param("email") String email);
	
	// @param is used for get the dynamic email when enter the username by user
	
	/* User findByEmail(String user); */
}
