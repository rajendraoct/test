package com.aik.model;

public class LeaveBalance
{
	private String empNo;
	private String type = "ALL"; 
	private String cDate;
	private int userId; 
   
	public LeaveBalance() 
	{
	}
	
	public LeaveBalance(String empNo, String type, String cDate, int userId) {
		super();
		this.empNo = empNo;
		this.type = type;
		this.cDate = cDate;
		this.userId = userId;
	}



	public String getempNo() {
		return empNo;
	}

	public void setempNo(String empNo) {
		this.empNo = empNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getcDate() {
		return cDate;
	}

	public void setcDate(String cDate) {
		this.cDate = cDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
