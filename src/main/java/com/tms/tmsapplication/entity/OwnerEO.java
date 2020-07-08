package com.tms.tmsapplication.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TM_OWNERDETAILS")
public class OwnerEO {
	
	@Id
	@Column(name="OWNER_ID")
	private int ownerId;
	
	@Column(name="FNAME")
	private String fname;
	
	@Column(name="LNAME")
	private String lname;
	
	@Column(name="DATEOFBIRTH")
	private Date DOB;
	
	@Column(name="LANDLINE_NO")
	private String landlineNo;
	
	@Column(name="MOBILE_NO")
	private String mobileNo;
	
	@Column(name="GENDER")
	private char gender;
	
	@Column(name="TEMP_ADDR")
	private String tempAddr;
	
	@Column(name="PERM_ADDR")
	private String permAddr;
	
	@Column(name="PINCODE")
	private int pincode;
	
	@Column(name="OCCUPATION")
	private String occupation;
	
	@Column(name="PANCARD_NO")
	private String pancardNo;
	
	@Column(name="ADD_PROOF_NAME")
	private String addrProofName;
	
	public OwnerEO() {
		
	}

	public OwnerEO(int ownerId, String fname, String lname, Date dOB, String landlineNo, String mobileNo, char gender,
			String tempAddr, String permAddr, int pincode, String occupation, String pancardNo, String addrProofName) {
		this.ownerId = ownerId;
		this.fname = fname;
		this.lname = lname;
		DOB = dOB;
		this.landlineNo = landlineNo;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.tempAddr = tempAddr;
		this.permAddr = permAddr;
		this.pincode = pincode;
		this.occupation = occupation;
		this.pancardNo = pancardNo;
		this.addrProofName = addrProofName;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getLandlineNo() {
		return landlineNo;
	}

	public void setLandlineNo(String landlineNo) {
		this.landlineNo = landlineNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getTempAddr() {
		return tempAddr;
	}

	public void setTempAddr(String tempAddr) {
		this.tempAddr = tempAddr;
	}

	public String getPermAddr() {
		return permAddr;
	}

	public void setPermAddr(String permAddr) {
		this.permAddr = permAddr;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPancardNo() {
		return pancardNo;
	}

	public void setPancardNo(String pancardNo) {
		this.pancardNo = pancardNo;
	}

	public String getAddrProofName() {
		return addrProofName;
	}

	public void setAddrProofName(String addrProofName) {
		this.addrProofName = addrProofName;
	}

	@Override
	public String toString() {
		return "OwnerEO [ownerId=" + ownerId + ", fname=" + fname + ", lname=" + lname + ", DOB=" + DOB
				+ ", landlineNo=" + landlineNo + ", mobileNo=" + mobileNo + ", gender=" + gender + ", tempAddr="
				+ tempAddr + ", permAddr=" + permAddr + ", pincode=" + pincode + ", occupation=" + occupation
				+ ", pancardNo=" + pancardNo + ", addrProofName=" + addrProofName + "]";
	}

}
