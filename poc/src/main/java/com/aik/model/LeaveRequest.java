package com.aik.model;

import java.io.Serializable;


public class LeaveRequest implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String empName;
  private String empNo;
  private String cno;
  private int lrType;
  private String lrCode;
 
  private String lfdt;
  private String ltdt;
  private String rmk;
  
  private String aprEmpNo;
  private String lvSalPr;
  private String lrPntReqId;
  private int pUserId;
  private String leaveType;
  private String leaveReqId;
  

public LeaveRequest(String empName, String empNo, String cno, int lrType, String lrCode, String lfdt, String ltdt,
		String rmk, String aprEmpNo, String lvSalPr, String lrPntReqId, int pUserId, String leaveType,
		String leaveReqId) {
	super();
	this.empName = empName;
	this.empNo = empNo;
	this.cno = cno;
	this.lrType = lrType;
	this.lrCode = lrCode;
	this.lfdt = lfdt;
	this.ltdt = ltdt;
	this.rmk = rmk;
	this.aprEmpNo = aprEmpNo;
	this.lvSalPr = lvSalPr;
	this.lrPntReqId = lrPntReqId;
	this.pUserId = pUserId;
	this.leaveType = leaveType;
	this.leaveReqId = leaveReqId;
}

public String getLeaveType() {
	return leaveType;
}

public void setLeaveType(String leaveType) {
	this.leaveType = leaveType;
}



public LeaveRequest()
  {
	  
  }


public String getEmpName() {
	return empName;
}

public void setEmpName(String empName) {
	this.empName = empName;
}

public String getEmpNo() {
	return empNo;
}

public void setEmpNo(String empNo) {
	this.empNo = empNo;
}

public String getCno() {
	return cno;
}

public void setCno(String cno) {
	this.cno = cno;
}

public int getLrType() {
	return lrType;
}

public void setLrType(int lrType) {
	this.lrType = lrType;
}

public String getLrCode() {
	return lrCode;
}

public void setLrCode(String lrCode) {
	this.lrCode = lrCode;
}

public String getLfdt() {
	return lfdt;
}

public void setLfdt(String lfdt) {
	this.lfdt = lfdt;
}

public String getLtdt() {
	return ltdt;
}

public void setLtdt(String ltdt) {
	this.ltdt = ltdt;
}

public String getRmk() {
	return rmk;
}

public void setRmk(String rmk) {
	this.rmk = rmk;
}

public String getAprEmpNo() {
	return aprEmpNo;
}

public void setAprEmpNo(String aprEmpNo) {
	this.aprEmpNo = aprEmpNo;
}

public String getLvSalPr() {
	return lvSalPr;
}

public void setLvSalPr(String lvSalPr) {
	this.lvSalPr = lvSalPr;
}

public String getLrPntReqId() {
	return lrPntReqId;
}

public void setLrPntReqId(String lrPntReqId) {
	this.lrPntReqId = lrPntReqId;
}

public int getpUserId() {
	return pUserId;
}

public void setpUserId(int pUserId) {
	this.pUserId = pUserId;
}

public String getLeaveReqId() {
	return leaveReqId;
}

public void setLeaveReqId(String leaveReqId) {
	this.leaveReqId = leaveReqId;
}

@Override
public String toString() {
	return "LeaveRequest [empName=" + empName + ", empNo=" + empNo + ", cno=" + cno + ", lrType=" + lrType + ", lrCode="
			+ lrCode + ", lfdt=" + lfdt + ", ltdt=" + ltdt + ", rmk=" + rmk + ", aprEmpNo=" + aprEmpNo + ", lvSalPr="
			+ lvSalPr + ", lrPntReqId=" + lrPntReqId + ", pUserId=" + pUserId + ", leaveType=" + leaveType
			+ ", leaveReqId=" + leaveReqId + "]";
}



}
