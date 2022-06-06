package com.orenda.lifesecure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_address_permanent")
public class PermanentAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address")
	private String Address;
	
	@Column(name = "landmark")
	private String LandMark;
	
	@Column(name = "add_area")
	private String Add_Area;
	
	@Column(name = "state")
	private String State;
	
	@Column(name = "district")
	private String District;
	
	@Column(name = "tahsil")
	private String Tahsil;
	
	@Column(name = "village")
	private String Village;
	
	@Column(name = "pincode")
	private Long pincode;
	
	@OneToOne(mappedBy = "paddress")
	private UserDetails userdetails;
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getLandMark() {
	   	return LandMark;
	}
	public void setLandMark(String landMark) {
		LandMark = landMark;
	}
	public String getAdd_Area() {
		return Add_Area;
	}
	public void setAdd_Area(String add_Area) {
		Add_Area = add_Area;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public String getTahsil() {
		return Tahsil;
	}
	public void setTahsil(String tahsil) {
		Tahsil = tahsil;
	}
	public String getVillage() {
		return Village;
	}
	public void setVillage(String village) {
		Village = village;
	}
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "CurrentAddress [Address=" + Address + ", LandMark=" + LandMark + ", Add_Area=" + Add_Area + ", State="
				+ State + ", District=" + District + ", Tahsil=" + Tahsil + ", Village=" + Village + ", pincode="
				+ pincode + "]";
	}

}
