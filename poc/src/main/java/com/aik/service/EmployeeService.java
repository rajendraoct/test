package com.aik.service;

import java.util.List;
import java.util.Map;

import com.aik.model.ApproveLeave;
import com.aik.model.CancelLeave;
import com.aik.model.LeaveBalance;
import com.aik.model.LeaveRequest;
import com.aik.model.LeaveResultStatus;

public interface EmployeeService 
{
	public LeaveResultStatus applyLeave(LeaveRequest newLeaveRequest);
	public LeaveResultStatus approveOrCancelLeave(ApproveLeave aLeave);
	//public void cancelEmpLeave(CancelLeave cLeave);
	public Map<String, String> getLeaveBalance(LeaveBalance lvBlance) throws Exception;
	public List<LeaveRequest> getLeaveAppliedLeave(String mgrId);
	
}