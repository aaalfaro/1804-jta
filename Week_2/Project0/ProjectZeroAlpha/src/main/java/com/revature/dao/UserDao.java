package com.revature.dao;

import java.sql.Timestamp;
import java.util.List;

import com.revature.users.User;


public interface UserDao {
	
	List<User> getAllUsers();
	User getUser(String username);
	boolean insertUser(User user);
	boolean updateUser(User user);
	boolean deleteUser(String username);
	String getPasswordHash(User user);
	boolean insertAdmin(User user);
	User getAnyUser();
	boolean generateUserInterest(User user);
	Timestamp getUserTime(User user);
}
