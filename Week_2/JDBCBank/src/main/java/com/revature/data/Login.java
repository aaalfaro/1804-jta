package com.revature.data;

import com.revature.dao.users.AdminService;
import com.revature.dao.users.UserService;
import com.revature.exceptions.UserNotFoundException;
import com.revature.users.Admin;
import com.revature.users.User;

//handle all the login attempts of users
public class Login {
// checks if a user is currently in the list of users	
 public static boolean userExists(String name) {
	 for(User user : UserService.getUsers()) {
		 if(user.getUsername().equals(name)) {
			 return true;
		 }
	 }
	 return false;
}
//checks if a user is currently in the list of users	
public static boolean adminExists(String name) {
	for(Admin admin : AdminService.getAdmins()) {
		 if(admin.getUsername().equals(name)) {
			 return true;
		 }
	 }
	 return false;
}
 //checks if the password given matches what is on record for the user
 public static boolean checkPasswordAdmin(String pass,String name) throws UserNotFoundException {
	 //change password comparing method;
	 if(AdminService.getAdmin(name).getPassword().equals(pass))
		 return true;
	 
	 return false;
}
 
 public static boolean checkPasswordUser(String pass,String name) throws UserNotFoundException {
	 //change password comparing method;
	 if(UserService.getUser(name).getPassword().equals(pass))
		 return true;
	 
	 return false;
} 
}