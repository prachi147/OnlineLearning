package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long contactId;
	private String fullName;
	private String email;
	private String phone;
	private String course;
	
	
	public long getContactId() {
		return contactId;
	}
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Contact(long contactId, String fullName, String email, String phone, String course) {
		super();
		this.contactId=contactId;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.course = course;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", fullName=" + fullName + ", email=" + email + ", phone=" + phone
				+ ", course=" + course + "]";
	}
	
	
	
	
	
	
	
}
