package com.orenda.lifesecure.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="tbl_user_details")
public class UserDetails {
	
	@Id
	
	
	@Column(name = "user_fname")
	private String FirstName;
	
	@Column(name = "user_mname")
	private String MiddleName;
	
	@Column(name = "user_lname")
	private String lastName;
	
	@Column(name = "user_type")
	private String usertype;
	
	@Column(name = "user_gender")
	private String gender;
	
//	@Column(name = "user_dob")
//	private int DOB;
	
	@Column(name = "user_prim_contact")
	private Long PrimaryContact;
	
	@Column(name = "user_alt_contact")
	private Long AltanateContact;
	@Column(name="user_email")
	private String userEmail;
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getMiddleName() {
		return MiddleName;
	}
	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
//	public int getDOB() {
//		return DOB;
//	}
//	public void setDOB(int dOB) {
//		DOB = dOB;
//	}
	public Long getPrimaryContact() {
		return PrimaryContact;
	}
	public void setPrimaryContact(Long primaryContact) {
		PrimaryContact = primaryContact;
	}
	public Long getAltanateContact() {
		return AltanateContact;
	}
	public void setAltanateContact(Long altanateContact) {
		AltanateContact = altanateContact;
	}
	@Override
	public String toString() {
		return "UserDetails [FirstName=" + FirstName + ", MiddleName=" + MiddleName + ", lastName=" + lastName
				+ ", usertype=" + usertype + ", gender=" + gender + ",   PrimaryContact="
				+ PrimaryContact + ", AltanateContact=" + AltanateContact + ", userEmail=" + userEmail + "]";
	}
	
	
	

}
