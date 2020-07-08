package com.tms.tmsapplication.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TM_OFFENCE_DETAILS")
public class OffenceDetailEO implements Serializable {
	
	@Column(name="VEH_NO")
	private String vehNo;
	
	@Column(name="IMAGE")
	private byte[] image;
	
	@Id
	@SequenceGenerator(name="TM_OFFENCE_OFFENCEID_GENERATOR", sequenceName="TM_OFFENCE_DETAIL_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TM_OFFENCE_OFFENCEID_GENERATOR")
	@Column(name="OFFENCE_DETAIL_ID")
	private int offenceDetId;
	
	@Column(name="OFFENCE_STATUS")
	private String offenceStatus;
	
	@Column(name="OFFENCE_ID")
	private int offenceId;
	
	@Column(name="TIME")
	private Date time;
	
	@Column(name="PLACE")
	private String place;
	
	@Column(name="REPORTED_BY")
	private String reportedBy;
	
	public OffenceDetailEO() {
		
	}

	public OffenceDetailEO(String vehNo, byte[] image, int offenceDetId, String offenceStatus, int offenceId, Date time,
			String place, String reportedBy) {
		this.vehNo = vehNo;
		this.image = image;
		this.offenceDetId = offenceDetId;
		this.offenceStatus = offenceStatus;
		this.offenceId = offenceId;
		this.time = time;
		this.place = place;
		this.reportedBy = reportedBy;
	}

	public String getVehNo() {
		return vehNo;
	}

	public void setVehNo(String vehNo) {
		this.vehNo = vehNo;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getOffenceDetId() {
		return offenceDetId;
	}

	public void setOffenceDetId(int offenceDetId) {
		this.offenceDetId = offenceDetId;
	}

	public String getOffenceStatus() {
		return offenceStatus;
	}

	public void setOffenceStatus(String offenceStatus) {
		this.offenceStatus = offenceStatus;
	}

	public int getOffenceId() {
		return offenceId;
	}

	public void setOffenceId(int offenceId) {
		this.offenceId = offenceId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getReportedBy() {
		return reportedBy;
	}

	public void setReportedBy(String reportedBy) {
		this.reportedBy = reportedBy;
	}

	@Override
	public String toString() {
		return "OffenceDetail [vehNo=" + vehNo + ", image=" + Arrays.toString(image) + ", offenceDetId=" + offenceDetId
				+ ", offenceStatus=" + offenceStatus + ", offenceId=" + offenceId + ", time=" + time + ", place="
				+ place + ", reportedBy=" + reportedBy + "]";
	}
}
