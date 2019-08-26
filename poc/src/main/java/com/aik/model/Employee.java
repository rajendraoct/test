package com.aik.model;

public class Employee 
{
	private String email;
	private String empId;
	private String name;
	private float totalleave;
	private float applied;
	private float remaining;
	public Employee()
	{

	}

	public Employee(String mail, String id, float tleave,float aleave,float rleave, String ename)
	{ 
		email = mail;
		empId = id;
		name  = ename;
	    totalleave = tleave;
		applied =  aleave;
		remaining = rleave;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getTotalleave() {
		return totalleave;
	}

	public void setTotalleave(float totalleave) {
		this.totalleave = totalleave;
	}

	public float getApplied() {
		return applied;
	}

	public void setApplied(float applied) {
		this.applied = applied;
	}

	public float getRemaining() {
		return remaining;
	}

	public void setRemaining(float remaining) {
		this.remaining = remaining;
	}


}
