package com.aik.model;

import java.io.Serializable;

public class CancelLeave implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lr_id;
	private String rmk;
	private String  cel_by;
	private int p_user_id ;

	public CancelLeave()
	{

	}

	public CancelLeave(String lr_id, String rmk, String cel_by, int p_user_id)
	{
		super();
		this.lr_id = lr_id;
		this.rmk = rmk;
		this.cel_by = cel_by;
		this.p_user_id = p_user_id;
	}



	public String getLr_id()
	{
		return lr_id;
	}
	public void setLr_id(String lr_id) 
	{
		this.lr_id = lr_id;
	}
	public String getRmk() 
	{
		return rmk;
	}
	public void setRmk(String rmk) 
	{
		this.rmk = rmk;
	}
	public String getCel_by() 
	{
		return cel_by;
	}
	public void setCel_by(String cel_by)
	{
		this.cel_by = cel_by;
	}
	public int getP_user_id()
	{
		return p_user_id;
	}
	public void setP_user_id(int p_user_id) 
	{
		this.p_user_id = p_user_id;
	}
	@Override
	public String toString() 
	{
		return "CancelLeave [lr_id=" + lr_id + ", rmk=" + rmk + ", cel_by=" + cel_by + ", p_user_id=" + p_user_id + "]";
	}

}
