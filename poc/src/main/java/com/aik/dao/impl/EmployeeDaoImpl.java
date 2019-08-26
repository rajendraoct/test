package com.aik.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.aik.dao.EmployeeDao;
import com.aik.exception.AIKException;
import com.aik.model.ApproveLeave;
import com.aik.model.CancelLeave;
import com.aik.model.LeaveBalance;
import com.aik.model.LeaveRequest;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private Connection connection;

	@Override
	public String applyLeave(LeaveRequest newLeaveRequest) 
	{
		try
		{  
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement stmt=connection.prepareCall (" {? = call  xhrms.XXHR_LEAVE_PKG.lr_new(?,?,?,?,?,?,?,?,?,?,?)}");

			stmt.registerOutParameter (1, Types.VARCHAR);
			stmt.setString(2,newLeaveRequest.getEmpNo());       
			stmt.setString(3,newLeaveRequest.getCno());
			stmt.setInt(4,newLeaveRequest.getLrType());
			stmt.setString(5,newLeaveRequest.getLrCode());
			stmt.setString(6,newLeaveRequest.getLfdt());
			stmt.setString(7,newLeaveRequest.getLtdt());
			stmt.setString(8,newLeaveRequest.getRmk());
			stmt.setString(9,newLeaveRequest.getAprEmpNo());
			stmt.setString(10,newLeaveRequest.getLvSalPr() 	);
			stmt.setString(11,newLeaveRequest.getLrPntReqId());
			stmt.setInt(12,newLeaveRequest.getpUserId());
			stmt.execute(); 
			String output =stmt.getString (1);
            System.out.println(output);
			return output;
			
		}
		catch (SQLException exception) 
		{
			throw new AIKException(exception.getMessage());
		}  finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new AIKException(e.getMessage());
				}
			}
		}
	}

	@Override
	public String approveOrCancelLeave(ApproveLeave aLeave)
	{
		try
		{

			connection = jdbcTemplate.getDataSource().getConnection();

			CallableStatement stmt=connection.prepareCall (" {? = call  xhrms.XXHR_LEAVE_PKG.lr_apr(?,?,?,?,?,?)}");

			stmt.registerOutParameter (1, Types.VARCHAR);
			stmt.setString(2,aLeave.getLr_id());       
			stmt.setString(3,aLeave.getAct_st());
			stmt.setString(4,aLeave.getApr_rmk());
			stmt.setString(5,aLeave.getApr_eno());
			stmt.setString(6,aLeave.getApr_dt());
			stmt.setInt(7,aLeave.getP_user_id());
			stmt.execute(); 
			String output =stmt.getString (1);
            return output;
			
		}
		catch (SQLException exception) 
		{
			throw new AIKException(exception.getMessage());
		}  finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new AIKException(e.getMessage());
				}
			}
		}
		}
		


	@Override
	public String getLeaveBalance(LeaveBalance lvBlance)
	{
		//testRow();
        try
		{
            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement stmt=connection.prepareCall (" {? = call  xhrms.XXHR_LEAVE_PKG.lr_bal(?,?,?,?)}");
            stmt.registerOutParameter (1, Types.VARCHAR);
			stmt.setString(2,lvBlance.getempNo());       
			stmt.setString(3,lvBlance.getType());
			stmt.setString(4,lvBlance.getcDate());
			stmt.setInt(5,lvBlance.getUserId());
			stmt.execute(); 
            return stmt.getString (1);
		}
		catch (SQLException exception) 
		{
			throw new AIKException(exception.getMessage());
		}  finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new AIKException(e.getMessage());
				}
			}
		}
	}

	@Override
	public List<LeaveRequest> getLeaveAppliedLeave(String mgrId) {
		List list = new ArrayList();
		 try
			{
			    LeaveRequest leaveRequest;
	            connection = jdbcTemplate.getDataSource().getConnection();
	            PreparedStatement  preparedStatement  = connection.prepareStatement("Select HR_INFO.FULL_NAME, XHR_REQ_V.LR_L_FROM, XHR_REQ_V.LR_L_TO, XHR_REQ_V.LR_LEAVE_RESON, XHR_REQ_V.LEAVE_TYPE, XHR_REQ_V.LR_REQ_ID  from xhrms.XHR_REQ_V inner join HR_INFO on XHR_REQ_V.ENO = HR_INFO.ENO where LR_APP_E_NO = ? AND LR_STATUS = ?");
	            
				preparedStatement.setString(1, mgrId);
				preparedStatement.setString(2, "1");
				
	            ResultSet rs = preparedStatement.executeQuery();
	            
	        	while(rs. next()){
	            	
	            	leaveRequest = new LeaveRequest();
	            	leaveRequest.setEmpName(rs.getString(1));
	            	leaveRequest.setLfdt(rs.getString(2).substring(0, 10));
	            	leaveRequest.setLtdt(rs.getString(3).substring(0, 10));
	            	leaveRequest.setRmk(rs.getString(4));
	            	leaveRequest.setLeaveType(rs.getString(5));
	            	leaveRequest.setLeaveReqId(rs.getString(6));
	            	
	            	list.add(leaveRequest);
	            }
			}
			catch (SQLException exception) 
			{
				throw new AIKException(exception.getMessage());
			} finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						throw new AIKException(e.getMessage());
					}
				}
			}
		 
		return list;
	}
	
	private void testRow() throws SQLException {
		try {
		System.out.println("Inside Test");
		List list = new ArrayList();
		connection = jdbcTemplate.getDataSource().getConnection();//" select ENO from XHRMS.HR_INFO;"
		Statement  preparedStatement  = connection.createStatement();
		ResultSet rs = preparedStatement.executeQuery("select ENO from XHRMS.HR_INFO");
		while(rs.next()) {
			System.out.println("Inside RS");
			 CallableStatement stmt=connection.prepareCall (" {? = call  xhrms.XXHR_LEAVE_PKG.lr_bal(?,?,?,?)}");
	            stmt.registerOutParameter (1, Types.VARCHAR);
				stmt.setString(2,rs.getString(1));       
				stmt.setString(3,"ALL");
				stmt.setString(4,"5-MAY-19");
				stmt.setInt(5,0);
				stmt.execute(); 
	            System.out.println(stmt.getString (1));
	            Thread.sleep(1000);
		}
		
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new AIKException(e.getMessage());
				}
			}
		}
	}
	

}