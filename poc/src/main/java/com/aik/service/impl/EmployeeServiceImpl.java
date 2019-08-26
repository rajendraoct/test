package com.aik.service.impl;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aik.dao.EmployeeDao;
import com.aik.model.ApproveLeave;
import com.aik.model.CancelLeave;
import com.aik.model.LeaveBalance;
import com.aik.model.LeaveRequest;
import com.aik.model.LeaveResultStatus;
import com.aik.service.EmployeeService;
import com.aik.util.DateFormater;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public LeaveResultStatus applyLeave(LeaveRequest newLeaveRequest)
	{
		String result = employeeDao.applyLeave(newLeaveRequest);
		return getLeaveResultStatus(result);
	}

	@Override
	public List<LeaveRequest> getLeaveAppliedLeave(String mgrId)
	{
		return employeeDao.getLeaveAppliedLeave(mgrId);
	}
	
	@Override
	public LeaveResultStatus approveOrCancelLeave(ApproveLeave aLeave) 
	{
		LeaveResultStatus leaveResStatus = new LeaveResultStatus();
		String result = employeeDao.approveOrCancelLeave(aLeave);
		leaveResStatus.setLeaveStatus(result);
		return leaveResStatus;
	}

	/*@Override
	public void cancelEmpLeave(CancelLeave cLeave) 
	{
		employeeDao.cancelEmpLeave(cLeave);
	}*/

	@Override
	public Map<String, String> getLeaveBalance(LeaveBalance lvBlance) throws Exception
	{
		lvBlance.setcDate(DateFormater.getTodaysDate(new Date()));
		String res = employeeDao.getLeaveBalance(lvBlance);
		return lr_bal_Response(res);
	}

	private Map<String,String> lr_bal_Response(String res)
	{
		String newString = res.replace('$', '#');
		String lr_type [] = newString.split("#");
		Map<String,String> leave = new LinkedHashMap<String,String>();
		//leave.put("msg", lr_type[0]);
		//leave.put("row", lr_type[1]);
		for(int index=2; index<lr_type.length; index++ )
		{
			String lt [] =  lr_type[index].split(":");
			leave.put(lt[0].trim() , lt[1].trim());

		}
		return leave;
	}
	
	private LeaveResultStatus getLeaveResultStatus(String leaveResult) {
		String leaveStatus = leaveResult.substring(0, 1);
		LeaveResultStatus leaveResultStatus = new LeaveResultStatus();
		leaveResultStatus.setLeaveStatus(leaveStatus);
		if(leaveStatus.equals("S")) {
			leaveResultStatus.setMessage(leaveResult.substring(2, 9));
		} else {
			leaveResultStatus.setMessage(leaveResult.substring(2, leaveResult.length()));
		}
		return leaveResultStatus;
	}
}