package com.revature.dao.users;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.users.User;
import com.revature.connection.ConnectionUtil;
import com.revature.exceptions.UserNotFoundException;
import com.revature.project0.Script;

public class UserDaoImpl implements UserDao {

	private static final Logger logger = Logger.getLogger(Script.class);
	private static UserDaoImpl instance;
	
	private UserDaoImpl() {}
	
	public static UserDaoImpl getInstance() {
		if(instance == null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}
	
	@Override
	public boolean addUser(User user) {
		// TODO add User to database
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL insert_user(?,?)}");
			stmt.setString(++index, user.getUsername());
			stmt.setString(++index, user.getPassword());
			return stmt.executeUpdate() > 0;
		} catch(SQLException sqle) {
			logger.error(sqle.getMessage(), sqle);
			logger.error(sqle.getSQLState(),sqle);
			logger.error(sqle.getErrorCode(),sqle);
		} 
		return false;
	}

	@Override
	public boolean lockUser(User user) throws UserNotFoundException {
		// TODO locks a user
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL lock_user(?)}");
			stmt.setString(++index, user.getUsername());
			return stmt.executeUpdate() > 0;
		} catch(SQLException sqle) {
			logger.error(sqle.getMessage(), sqle);
			logger.error(sqle.getSQLState(),sqle);
			logger.error(sqle.getErrorCode(),sqle);
		} 
		
		throw new UserNotFoundException();
	}

	@Override
	public boolean unlockUser(User user) throws UserNotFoundException {
		// TODO unlocks a user
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL unlock_user(?)}");
			stmt.setString(++index, user.getUsername());
			return stmt.executeUpdate() > 0;
		} catch(SQLException sqle) {
			logger.error(sqle.getMessage(), sqle);
			logger.error(sqle.getSQLState(),sqle);
			logger.error(sqle.getErrorCode(),sqle);
		} 
		
		throw new UserNotFoundException();
	}

	@Override
	public boolean approveUser(User user) throws UserNotFoundException {
		// TODO approves a user
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL approve_user(?)}");
			stmt.setString(++index, user.getUsername());
			return stmt.executeUpdate() > 0;
		} catch(SQLException sqle) {
			logger.error(sqle.getMessage(), sqle);
			logger.error(sqle.getSQLState(),sqle);
			logger.error(sqle.getErrorCode(),sqle);
		} 
		
		throw new UserNotFoundException();
	}

	@Override
	public List<User> getUsers() {
		try(Connection conn = ConnectionUtil.getConnection()){
			List<User> user= new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM movie_user ORDER BY user_id");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				user.add(new User(rs.getString("user_username"),rs.getString("user_password")));
			}
			return user;
		} catch(SQLException sqle) {
			logger.error(sqle.getMessage(), sqle);
			logger.error(sqle.getSQLState(),sqle);
			logger.error(sqle.getErrorCode(),sqle);
		} 
		return null;
	}

	@Override
	public User getUser(String user) throws UserNotFoundException {
		// TODO returns user with the given username;
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM movie_user WHERE user_username = ?");
			stmt.setString(++index, user);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next())
				return new User(rs.getString("user_username"), rs.getString("user_password"), rs.getInt("user_id"));
		} catch(SQLException sqle) {
			logger.error(sqle.getMessage(), sqle);
			logger.error(sqle.getSQLState(),sqle);
			logger.error(sqle.getErrorCode(),sqle);
		} 
		throw new UserNotFoundException();
	}

	@Override
	public boolean isUserLocked(User user) throws UserNotFoundException {
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM movie_user WHERE user_username = ?");
			stmt.setString(++index, user.getUsername());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int lock = rs.getInt("locked");
				return rs.getInt("locked") == 1;
			}
		} catch(SQLException sqle) {
			logger.error(sqle.getMessage(), sqle);
			logger.error(sqle.getSQLState(),sqle);
			logger.error(sqle.getErrorCode(),sqle);
		} 
		throw new UserNotFoundException();
	}

	@Override
	public boolean isUserUnapproved(User user) throws UserNotFoundException {
		// TODO returns if the given user is unapproved
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM movie_user WHERE user_username = ?");
			stmt.setString(++index, user.getUsername());
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
				return rs.getInt("approved") == 0;
		} catch(SQLException sqle) {
			logger.error(sqle.getMessage(), sqle);
			logger.error(sqle.getSQLState(),sqle);
			logger.error(sqle.getErrorCode(),sqle);
		} 
		throw new UserNotFoundException();
	}
	
	@Override
	public String getPasswordHash(User user) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT get_user_hash(?,?)AS HASH FROM dual");
			stmt.setString(++index, user.getUsername());
			stmt.setString(++index, user.getPassword());
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
				return rs.getString("HASH");
		} catch(SQLException sqle) {
			logger.error(sqle.getMessage(), sqle);
			logger.error(sqle.getSQLState(),sqle);
			logger.error(sqle.getErrorCode(),sqle);
		} 
		return null;
	}
	

}
