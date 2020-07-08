package com.tms.tmsapplication.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="TM_VEHICLEDETAILS")
public class VehicleDetailEO {
	
	@Id
	@Column(name="VEH_ID")
	private int vehId;
	
	@Column(name="VEH_TYPE")
	private String vehType;
	
	@Column(name="ENGINE_NO")
	private String EngineNo;
	
	@Column(name="MODEL_NO")
	private String modelNo;
	
	@Column(name="VEH_NAME")
	private String vehName;
	
	@Column(name="VEH_COLOR")
	private String vehColor;
	
	@Column(name="MANUFACTURER_NAME")
	private String manufacturerName;
	
	@Column(name="DATE_OF_MANUFACTURE")
	private Date manufacturerDate;
	
	@Column(name="NO_OF_CYLINDERS")
	private int noOfCyl;
	
	@Column(name="CUBIC_CAPACITY")
	private int cubicCapacity;
	
	@Column(name="FUEL_USED")
	private String fuelUsed;
	
	public VehicleDetailEO() {
		
	}

	public VehicleDetailEO(int vehId, String vehType, String engineNo, String modelNo, String vehName, String vehColor,
			String manufacturerName, Date manufacturerDate, int noOfCyl, int cubicCapacity, String fuelUsed) {
		this.vehId = vehId;
		this.vehType = vehType;
		EngineNo = engineNo;
		this.modelNo = modelNo;
		this.vehName = vehName;
		this.vehColor = vehColor;
		this.manufacturerName = manufacturerName;
		this.manufacturerDate = manufacturerDate;
		this.noOfCyl = noOfCyl;
		this.cubicCapacity = cubicCapacity;
		this.fuelUsed = fuelUsed;
	}

	public int getVehId() {
		return vehId;
	}

	public void setVehId(int vehId) {
		this.vehId = vehId;
	}

	public String getVehType() {
		return vehType;
	}

	public void setVehType(String vehType) {
		this.vehType = vehType;
	}

	public String getEngineNo() {
		return EngineNo;
	}

	public void setEngineNo(String engineNo) {
		EngineNo = engineNo;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getVehName() {
		return vehName;
	}

	public void setVehName(String vehName) {
		this.vehName = vehName;
	}

	public String getVehColor() {
		return vehColor;
	}

	public void setVehColor(String vehColor) {
		this.vehColor = vehColor;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public Date getManufacturerDate() {
		return manufacturerDate;
	}

	public void setManufacturerDate(Date manufacturerDate) {
		this.manufacturerDate = manufacturerDate;
	}

	public int getNoOfCyl() {
		return noOfCyl;
	}

	public void setNoOfCyl(int noOfCyl) {
		this.noOfCyl = noOfCyl;
	}

	public int getCubicCapacity() {
		return cubicCapacity;
	}

	public void setCubicCapacity(int cubicCapacity) {
		this.cubicCapacity = cubicCapacity;
	}

	public String getFuelUsed() {
		return fuelUsed;
	}

	public void setFuelUsed(String fuelUsed) {
		this.fuelUsed = fuelUsed;
	}

	@Override
	public String toString() {
		return "VehicleDetailEO [vehId=" + vehId + ", vehType=" + vehType + ", EngineNo=" + EngineNo + ", modelNo="
				+ modelNo + ", vehName=" + vehName + ", vehColor=" + vehColor + ", manufacturerName=" + manufacturerName
				+ ", manufacturerDate=" + manufacturerDate + ", noOfCyl=" + noOfCyl + ", cubicCapacity=" + cubicCapacity
				+ ", fuelUsed=" + fuelUsed + "]";
	}

}
