package com.tms.tmsapplication.joinedclasses;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class FullOffenceDetail implements Serializable {
	
	private String offenceType;
	private float penalty;
	private String vehicleType;
	private int offenceId;
	private int offenceDetId;
	private String vehNo;
	private byte[] image;
	private String offenceStatus;
	private Date time;
	private String place;
	private String reportedBy;
	
	public FullOffenceDetail() {
		
	}

	public FullOffenceDetail(String offenceType, float penalty, String vehicleType, int offenceId,
			int offenceDetId, String vehNo, byte[] image, String offenceStatus, Date time, String place,
			String reportedBy) {
		this.offenceType = offenceType;
		this.penalty = penalty;
		this.vehicleType = vehicleType;
		this.offenceId = offenceId;
		this.offenceDetId = offenceDetId;
		this.vehNo = vehNo;
		this.image = image;
		this.offenceStatus = offenceStatus;
		this.time = time;
		this.place = place;
		this.reportedBy = reportedBy;
	}

	public int getOffenceId() {
		return offenceId;
	}

	public int getOffenceDetId() {
		return offenceDetId;
	}

	public void setOffenceId(int offenceId) {
		this.offenceId = offenceId;
	}

	public void setOffenceDetId(int offenceDetId) {
		this.offenceDetId = offenceDetId;
	}

	public String getOffenceType() {
		return offenceType;
	}

	public float getPenalty() {
		return penalty;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public String getVehNo() {
		return vehNo;
	}

	public byte[] getImage() {
		return image;
	}

	public String getOffenceStatus() {
		return offenceStatus;
	}

	public Date getTime() {
		return time;
	}

	public String getPlace() {
		return place;
	}

	public String getReportedBy() {
		return reportedBy;
	}

	public void setOffenceType(String offenceType) {
		this.offenceType = offenceType;
	}

	public void setPenalty(float penalty) {
		this.penalty = penalty;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public void setVehNo(String vehNo) {
		this.vehNo = vehNo;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public void setOffenceStatus(String offenceStatus) {
		this.offenceStatus = offenceStatus;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setReportedBy(String reportedBy) {
		this.reportedBy = reportedBy;
	}

	@Override
	public String toString() {
		return "FullOffenceDetail [offenceType=" + offenceType + ", penalty=" + penalty + ", vehicleType=" + vehicleType
				+ ", offenceId=" + offenceId + ", offenceDetId=" + offenceDetId + ", vehNo=" + vehNo + ", image="
				+ Arrays.toString(image) + ", offenceStatus=" + offenceStatus + ", time=" + time + ", place=" + place
				+ ", reportedBy=" + reportedBy + "]";
	}

}
