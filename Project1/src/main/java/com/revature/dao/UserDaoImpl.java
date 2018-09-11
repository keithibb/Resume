
package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.User;
import com.revature.model.UserInformation;
import com.revature.util.ConnectionFactory;

public class UserDaoImpl implements UserDao {
	
	private static UserDaoImpl instance;
	
	private UserDaoImpl() {}
	
	public static UserDaoImpl getInstance() {
		if (instance == null) 
			instance = new UserDaoImpl();
		return instance;
	}


	
	@Override
	public String getPasswordHash(User user) {
		int index = 0;
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement cs = conn.prepareStatement("SELECT get_user_hash(?,?) AS HASH from dual");
			cs.setString(++index, user.getUsername());
			cs.setString(++index, user.getPassword());
			ResultSet rs = cs.executeQuery();
			if (rs.next())
				return rs.getString("HASH");
		} catch (SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.println("Error Code: " + sql.getErrorCode());
		}
		return null;
	}

	@Override
	public UserInformation getUserInformation(String username) {
		int index = 0;
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement stmt = 
			conn.prepareStatement("SELECT ui.username, ui.firstname, ui.lastname, ui.email, ur.u_role FROM user_info ui "
					+ "join user_roles ur on ui.ur_id = ur.ur_id WHERE username = ?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
				return new UserInformation(rs.getString(1), 
						rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		} catch (SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.println("Error Code: " + sql.getErrorCode());
		}
		return null;
	}

	
	@Override
	public User getUser(String username) {
		int index = 0;
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
			ps.setString(++index, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return new User(rs.getString(1), rs.getString(2));
		} catch (SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.println("Error Code: " + sql.getErrorCode());
		}
		return null;
	}
	

	
	
}