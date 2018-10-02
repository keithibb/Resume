package com.revature.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import com.revature.model.Reimbursement;
import com.revature.model.UserInformation;
import com.revature.util.ConnectionFactory;
import com.revature.model.User;
public class ReimbDao {
	
	private static ReimbDao instance;
	private ReimbDao() {}
	
	public static ReimbDao getInstance() {
		if (instance == null) 
			instance = new ReimbDao();
			return instance;
	}	
	//adding a reimbursement
	public void addRiembursement(Reimbursement r) {
		try(Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into reimbursement (amount, submit_time, r_desc, author, resolver, rs_id, rt_id) "
					+ "values (?, sysdate, ?, ?,NULL, 1, ?)");

			ps.setDouble(1, r.getAmount());
			ps.setString(2, r.getDescription());
			ps.setString(3, r.getAuthor());
			ps.setInt(4, typeOfReim(r.getType()));
			ps.executeUpdate();
		} catch (SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.println("Error Code: " + sql.getErrorCode());
	}
	}		
	//gets reimbursements by username
	public List<Reimbursement> getReimb(UserInformation username) {
		Reimbursement r = null;
		List<Reimbursement> reimb = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT R.R_ID, R.AMOUNT, R.SUBMIT_TIME, R.RESOLVED_TIME, R.R_DESC, R.AUTHOR, R.RESOLVER, RS.R_STATUS, RT.R_TYPE FROM REIMBURSEMENT R " + 
					"INNER JOIN R_STATUS RS ON R.RS_ID=RS.RS_ID INNER JOIN R_TYPE RT ON R.RT_ID=RT.RT_ID WHERE AUTHOR = ? " + 
					"ORDER BY SUBMIT_TIME desc");
			ps.setString(1, UserInformation.username);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
		

				Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Costa_Rica"));
				r = new Reimbursement();
				r.setReimbbId(rs.getInt(1));
				r.setAmount(rs.getDouble(2));
				r.setSubmitted(rs.getTimestamp(3, cal));
				r.setResolved(rs.getTimestamp(4, cal));
				r.setDescription(rs.getString(5));
				r.setAuthor(rs.getString(6));
				r.setResolver(rs.getString(7));
				r.setStatus(rs.getString(8));
				r.setType(rs.getString(9));
				reimb.add(r);
//				System.out.println(reimb.size());
			
			}
			} catch (SQLException e) {
				System.err.println(e.getErrorCode() + e.getSQLState());
				e.printStackTrace();
			}
			return reimb;
			
	}
	
//get all reimbursements
	public List<Reimbursement> getAllReimb(UserInformation ui) {
		Reimbursement r = null;
		List<Reimbursement> reimb = new ArrayList<Reimbursement>();
//		int index = 0;
		try(Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT R.R_ID, R.AMOUNT, R.SUBMIT_TIME, R.RESOLVED_TIME, R.R_DESC, R.AUTHOR, R.RESOLVER, RS.R_STATUS, RT.R_TYPE FROM REIMBURSEMENT R " + 
					"INNER JOIN R_STATUS RS ON R.RS_ID=RS.RS_ID INNER JOIN R_TYPE RT ON R.RT_ID=RT.RT_ID " + 
					"ORDER BY SUBMIT_TIME desc");
			
//			ps.setString(++index, ui.getUsername());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
		

				Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Costa_Rica"));
				r = new Reimbursement();
				r.setReimbbId(rs.getInt(1));
				r.setAmount(rs.getDouble(2));
				r.setSubmitted(rs.getTimestamp(3, cal));
				r.setResolved(rs.getTimestamp(4, cal));
				r.setDescription(rs.getString(5));
				r.setAuthor(rs.getString(6));
				r.setResolver(rs.getString(7));
				r.setStatus(rs.getString(8));
				r.setType(rs.getString(9));
				reimb.add(r);
//				System.out.println(reimb.size());
			
			}
			} catch (SQLException e) {
				System.err.println(e.getErrorCode() + e.getSQLState());
				e.printStackTrace();
			}
			return reimb;
					
		}
	//updating reimbursement requets
	public int updateReimb(Reimbursement r) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "UPDATE REIMBURSEMENT SET RESOLVED_TIME = SYSDATE, RESOLVER = ?, RS_ID = ? WHERE R_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "admin");
			ps.setInt(2, statusOfReim(r.getStatus()));
			ps.setInt(3, r.getReimbbId());			
			int i = ps.executeUpdate();
			
			if (i == 1) {
				return 1;
			}
			
		} catch (SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.println("Error Code: " + sql.getErrorCode());
		}
		return 0;
	}
	public static int typeOfReim(String s) {
		
		switch(s) {
		case "LODGING":
			return 1;
		case "TRAVEL":
			return 2;
		case "FOOD":
			return 3;
		case "OTHER":
			return 4;
		default:
			return 4;
		}
	}
	public static int statusOfReim(String s) {
		switch(s) {
		case "OPEN":
			return 1;
		case "APPROVED":
			return 2;
		case "DENIED":
			return 3;
		case "CLOSED":
			return 4;
		default:
			return 1;
		}	
	}
	
}