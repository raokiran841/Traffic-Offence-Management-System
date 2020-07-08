package com.tms.tmsapplication.joinedclasses;

import java.io.Serializable;
import java.util.Date;

public class OwnerRegistrationDetail implements Serializable {
	
	private int appNo;
	private String vehNo;
	private int vehicleId;
	private int ownerId;
	private Date date;
	private String distributerName;
	private String fname;
	private String lname;
	private Date DOB;
	private String landlineNo;
	private String mobileNo;
	private char gender;
	private String tempAddr;
	private String permAddr;
	private int pincode;
	private String occupation;
	private String pancardNo;
	private String addrProofName;
	
	public OwnerRegistrationDetail() {
		
	}

	public OwnerRegistrationDetail(int appNo, String vehNo, int vehicleId, int ownerId, Date date,
			String distributerName, String fname, String lname, Date dOB, String landlineNo, String mobileNo,
			char gender, String tempAddr, String permAddr, int pincode, String occupation, String pancardNo,
			String addrProofName) {
		this.appNo = appNo;
		this.vehNo = vehNo;
		this.vehicleId = vehicleId;
		this.ownerId = ownerId;
		this.date = date;
		this.distributerName = distributerName;
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

	public int getAppNo() {
		return appNo;
	}

	public String getVehNo() {
		return vehNo;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public Date getDate() {
		return date;
	}

	public String getDistributerName() {
		return distributerName;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public Date getDOB() {
		return DOB;
	}

	public String getLandlineNo() {
		return landlineNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public char getGender() {
		return gender;
	}

	public String getTempAddr() {
		return tempAddr;
	}

	public String getPermAddr() {
		return permAddr;
	}

	public int getPincode() {
		return pincode;
	}

	public String getOccupation() {
		return occupation;
	}

	public String getPancardNo() {
		return pancardNo;
	}

	public String getAddrProofName() {
		return addrProofName;
	}

	public void setAppNo(int appNo) {
		this.appNo = appNo;
	}

	public void setVehNo(String vehNo) {
		this.vehNo = vehNo;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setDistributerName(String distributerName) {
		this.distributerName = distributerName;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public void setLandlineNo(String landlineNo) {
		this.landlineNo = landlineNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public void setTempAddr(String tempAddr) {
		this.tempAddr = tempAddr;
	}

	public void setPermAddr(String permAddr) {
		this.permAddr = permAddr;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public void setPancardNo(String pancardNo) {
		this.pancardNo = pancardNo;
	}

	public void setAddrProofName(String addrProofName) {
		this.addrProofName = addrProofName;
	}

	@Override
	public String toString() {
		return "OwnerRegistrationDetail [appNo=" + appNo + ", vehNo=" + vehNo + ", vehicleId=" + vehicleId
				+ ", ownerId=" + ownerId + ", date=" + date + ", distributerName=" + distributerName + ", fname="
				+ fname + ", lname=" + lname + ", DOB=" + DOB + ", landlineNo=" + landlineNo + ", mobileNo=" + mobileNo
				+ ", gender=" + gender + ", tempAddr=" + tempAddr + ", permAddr=" + permAddr + ", pincode=" + pincode
				+ ", occupation=" + occupation + ", pancardNo=" + pancardNo + ", addrProofName=" + addrProofName + "]";
	}

}
