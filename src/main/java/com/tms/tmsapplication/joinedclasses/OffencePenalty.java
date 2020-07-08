package com.tms.tmsapplication.joinedclasses;

import java.io.Serializable;
import java.util.HashMap;

public class OffencePenalty implements Serializable{
	
	private String OffType;
	
	private int penalty;
	
	public OffencePenalty() {
		
	}

	public OffencePenalty(String offType, int penalty) {
		OffType = offType;
		this.penalty = penalty;
	}

	public String getOffType() {
		return OffType;
	}

	public int getPenalty() {
		return penalty;
	}

	public void setOffType(String offType) {
		OffType = offType;
	}

	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}

	@Override
	public String toString() {
		return "OffencePenalty [OffType=" + OffType + ", penalty=" + penalty + "]";
	}
	
}
