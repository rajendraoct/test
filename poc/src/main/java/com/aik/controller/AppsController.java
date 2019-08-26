package com.aik.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aik.exception.AIKException;
import com.aik.model.ApproveLeave;
import com.aik.model.CancelLeave;
import com.aik.model.LeaveBalance;
import com.aik.model.LeaveRequest;
import com.aik.model.LeaveResultStatus;
import com.aik.service.EmployeeService;

@RestController
@RequestMapping(produces = "application/hal+json")
public class AppsController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/leavebal")
	public ResponseEntity<Map<String, String>> ShowLeavesStatistics(@RequestBody LeaveBalance  lvBlance) throws Exception
	{
		System.out.println("Inside Leave Balance");
		return new ResponseEntity<>(employeeService.getLeaveBalance(lvBlance) , HttpStatus.OK);
	}
	
	@PostMapping("/leaverequest")
	public  ResponseEntity<LeaveResultStatus> SubmitLeaveRequest(@RequestBody LeaveRequest newLeave)
	{
		LeaveResultStatus result = employeeService.applyLeave(newLeave);
		return new ResponseEntity<>(result , HttpStatus.OK);
	}
	
	
	@GetMapping("/pendingleave")
	public ResponseEntity<List<LeaveRequest>> getLeaveAppliedLeave(@RequestParam String mgrId)
	{
		List<LeaveRequest> result = employeeService.getLeaveAppliedLeave(mgrId);
		return new ResponseEntity<>(result , HttpStatus.OK);
	}
	
	@PostMapping("/appcancelleave")
	public ResponseEntity<LeaveResultStatus> approveOrCancelLeave(@RequestBody ApproveLeave aLeave)
	{
		return new ResponseEntity<>(employeeService.approveOrCancelLeave(aLeave) , HttpStatus.OK);
	}
	
	@GetMapping("/hello")
	public ResponseEntity<String> getHello()
	{
		System.out.println("For Testing---------------------");
		return new ResponseEntity<>("Hello" , HttpStatus.OK);
	}
	
}
