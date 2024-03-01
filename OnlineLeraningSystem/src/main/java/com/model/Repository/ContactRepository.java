package com.model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

	List<Contact> findAll();
	
	
}
