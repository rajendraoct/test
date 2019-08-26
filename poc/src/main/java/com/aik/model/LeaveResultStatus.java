package com.aik.model;

import java.io.Serializable;

public class LeaveResultStatus implements Serializable {

	private static final long serialVersionUID = 1L;

	private String leaveStatus;
	
	private String message;

	public String getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
