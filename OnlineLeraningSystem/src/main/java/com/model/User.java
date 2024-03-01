package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//attributes or fields
	private long uId;
	
	@NotBlank(message = "FirstName is required.")
	@Size(min = 2, max = 50 ,message = "Enter valid Name." )
	private String firstName;
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
	@NotBlank(message = "FirstName is required.")
	@Size(min = 2, max = 50 ,message = "Enter valid Name." )
	private String lastName;
	
	@Email(message = "Enter Valid Email Address !!")
	private String email;
	
	@NotBlank(message = "Contact number should not be null .")
	@Size(min = 10, max = 10 ,message = "Enter your phone number." )
	private String phone;
	
	/*
	 * @NotBlank(message = "Password should not be null .")
	 * 
	 * @Size(min = 4, max = 8 ,message = "Enter valid password." )
	 */
	private String password;
	
	private String role;
	
	
	
	
	public long getuId() {
		return uId;
	}




	public void setuId(long uId) {
		this.uId = uId;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
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




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}




	@Override
	public String toString() {
		return "User [uId=" + uId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", password=" + password + ", role=" + role + "]";
	}
	
	
	
	
	
}
