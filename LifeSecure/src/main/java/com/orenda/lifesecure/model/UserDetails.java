package com.orenda.lifesecure.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user_details")
public class UserDetails {

	@Id
	@Column(name = "user_id")
	private int id;
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

	@Column(name = "user_dob")
	private Date DOB;

	@Column(name = "user_prim_contact")
	private Long PrimaryContact;

	@Column(name = "user_alt_contact")
	private Long AltanateContact;

	@Column(name = "user_email")
	private String email;

	@Column(name = "user_gov_id_image")
	private byte[] image;

	@Column(name = "user_gov_id_type")
	private String IdType;

	@Column(name = "user_gov_id_number")
	private String AdharNumber;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_cur_id")
	private CurrentAddress caddress;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_perm_id")
	private PermanentAddress paddress;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getIdType() {
		return IdType;
	}

	public void setIdType(String idType) {
		IdType = idType;
	}

	public String getAdharNumber() {
		return AdharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		AdharNumber = adharNumber;
	}

	public CurrentAddress getCaddress() {
		return caddress;
	}

	public void setCaddress(CurrentAddress caddress) {
		this.caddress = caddress;
	}

	public PermanentAddress getPaddress() {
		return paddress;
	}

	public void setPaddress(PermanentAddress paddress) {
		this.paddress = paddress;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", FirstName=" + FirstName + ", MiddleName=" + MiddleName + ", lastName="
				+ lastName + ", usertype=" + usertype + ", gender=" + gender + ", DOB=" + DOB + ", PrimaryContact="
				+ PrimaryContact + ", AltanateContact=" + AltanateContact + ", Email=" + email + ", image=" + image
				+ ", IdType=" + IdType + ", AdharNumber=" + AdharNumber + "]";
	}

	

}
