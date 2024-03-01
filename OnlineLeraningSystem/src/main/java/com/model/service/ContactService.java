package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Contact;
import com.model.Repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	ContactRepository contactRepository;
	

	
	public String save(Contact Contact) {
		
		contactRepository.save(Contact);
			return "Thank you our team will contact you shortly.";
		}


	public List<Contact> findByContactId() {
		return contactRepository.findAll();
	}
	
	public List<Contact> findAllContact(){
		
		 return contactRepository.findAll();
		 
	 }


	public void get(long id) {
		contactRepository.findById(id).get();	
	}


}
