package com.aik.model;

import java.io.Serializable;

public class ApproveLeave implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String lr_id;
	private String act_st;
	private String  apr_rmk;
	private String apr_eno;
	private String apr_dt;
	private int p_user_id ;

	public ApproveLeave()
	{

	}
	public ApproveLeave(String lr_id, String act_st, String apr_rmk, String apr_eno, String apr_dt, int p_user_id) 
	{
		super();
		this.lr_id = lr_id;
		this.act_st = act_st;
		this.apr_rmk = apr_rmk;
		this.apr_eno = apr_eno;
		this.apr_dt = apr_dt;
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
	public String getAct_st() 
	{
		return act_st;
	}

	public void setAct_st(String act_st) 
	{
		this.act_st = act_st;
	}
	public String getApr_rmk() 
	{
		return apr_rmk;
	}
	public void setApr_rmk(String apr_rmk) 
	{
		this.apr_rmk = apr_rmk;
	}
	public String getApr_eno() 
	{
		return apr_eno;
	}
	public void setApr_eno(String apr_eno) 
	{
		this.apr_eno = apr_eno;
	}
	public String getApr_dt()
	{
		return apr_dt;
	}
	public void setApr_dt(String apr_dt) 
	{
		this.apr_dt = apr_dt;
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
		return "ApproveLeave [lr_id=" + lr_id + ", act_st=" + act_st + ", apr_rmk=" + apr_rmk + ", apr_eno=" + apr_eno
				+ ", apr_dt=" + apr_dt + ", p_user_id=" + p_user_id + "]";
	}

}
