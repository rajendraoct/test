package com.aik.dao;

import java.util.List;

import com.aik.model.ApproveLeave;
import com.aik.model.CancelLeave;
import com.aik.model.LeaveBalance;
import com.aik.model.LeaveRequest;

public interface EmployeeDao 
{
	public String applyLeave(LeaveRequest newLeaveRequest);

	public String approveOrCancelLeave(ApproveLeave aLeave);

	//public void cancelEmpLeave(CancelLeave cLeave);
	
	public String getLeaveBalance(LeaveBalance lvBlance) throws Exception;
	
	public List<LeaveRequest> getLeaveAppliedLeave(String mgrId);
	
}