package com.tms.tmsapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TM_OFFENCE")
public class OffenceEO {
	
	@Id
	@SequenceGenerator(name="TM_OFFENCE_OFFENCEID_GENERATOR", sequenceName="TM_OFFENCE_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TM_OFFENCE_OFFENCEID_GENERATOR")
	@Column(name="OFFENCE_ID")
	private int id;
	
	@Column(name="OFFENCE_TYPE")
	private String offenceType;
	
	@Column(name="PENALTY")
	private float penalty;
	
	@Column(name="VEH_TYPE")
	private String vehicleType;
	
	public OffenceEO() {
		
	}

	public OffenceEO(int id, String offenceType, float penalty, String vehicleType) {
		this.id = id;
		this.offenceType = offenceType;
		this.penalty = penalty;
		this.vehicleType = vehicleType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOffenceType() {
		return offenceType;
	}

	public void setOffenceType(String offenceType) {
		this.offenceType = offenceType;
	}

	public float getPenalty() {
		return penalty;
	}

	public void setPenalty(float penalty) {
		this.penalty = penalty;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	@Override
	public String toString() {
		return "OffenceEO [id=" + id + ", offenceType=" + offenceType + ", penalty=" + penalty + ", vehicleType="
				+ vehicleType + "]";
	}

}