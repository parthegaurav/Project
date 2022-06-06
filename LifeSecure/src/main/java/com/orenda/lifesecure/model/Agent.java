package com.orenda.lifesecure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "tbl_user_details")
public class Agent 
{
	@Id
	
	//@GeneratedValue(Strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	@Column(name = "user_fname")
	private String fname;
	@Column(name = "user_mname")
	private String mname;
	@Column(name = "user_lname")
	private String lname;
	@Column(name = "user_type")
	private String type;
	@Column(name = "user_gender")
	private String gender;
	@Column(name = "user_dob")
	private String dob;
	@Column(name = "user_email")
	private String email;
	
	@Column(name = "user_prim_contact")
	private Long primaryContact;

	@Column(name = "user_alt_contact")
	private Long altanateContact;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getPrimaryContact() {
		return primaryContact;
	}
	public void setPrimaryContact(Long primaryContact) {
		this.primaryContact = primaryContact;
	}
	public Long getAltanateContact() {
		return altanateContact;
	}
	public void setAltanateContact(Long altanateContact) {
		this.altanateContact = altanateContact;
	}
	@Override
	public String toString() {
		return "Agent [id=" + id + ", fname=" + fname + ", mname=" + mname + ", lname=" + lname + ", type=" + type +", gender=" + gender
				+ ", dob=" + dob + ", email=" + email + ", userPrimContact=" +primaryContact+ ", userAltContact=" +altanateContact+" ]";
	}
	

}
