package com.tms.tmsapplication.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="tm_regdetails")
public class RegistrationEO {
	
	@Column(name="APP_NO")
	private int appNo;
	
	@Id
	@Column(name="VEH_NO")
	private String vehNo;
	
	@Column(name="VEH_ID")
	private int vehicleId;
	
	@Column(name="OWNER_ID")
	private int ownerId;
	
	@Column(name="DATE_OF_PURCHASE")
	private Date date;
	
	@Column(name="DISTRUBUTER_NAME")
	private String distributerName;
	
	public RegistrationEO() {
		
	}

	public RegistrationEO(int appNo, String vehNo, int vehicleId, int ownerId, Date date, String distributerName) {
		this.appNo = appNo;
		this.vehNo = vehNo;
		this.vehicleId = vehicleId;
		this.ownerId = ownerId;
		this.date = date;
		this.distributerName = distributerName;
	}

	public int getAppNo() {
		return appNo;
	}

	public void setAppNo(int appNo) {
		this.appNo = appNo;
	}

	public String getVehNo() {
		return vehNo;
	}

	public void setVehNo(String vehNo) {
		this.vehNo = vehNo;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDistributerName() {
		return distributerName;
	}

	public void setDistributerName(String distributerName) {
		this.distributerName = distributerName;
	}

	@Override
	public String toString() {
		return "RegistrationEO [appNo=" + appNo + ", vehNo=" + vehNo + ", vehicleId=" + vehicleId + ", ownerId="
				+ ownerId + ", date=" + date + ", distributerName=" + distributerName + "]";
	}

}
