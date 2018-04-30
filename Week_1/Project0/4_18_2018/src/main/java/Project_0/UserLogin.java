package Project_0;

import java.util.Scanner;

public class UserLogin {

	// Method that directs user login
	public static void userLogin() {

		// Scanner to collect input
		Scanner input = new Scanner(System.in);
		// Collect user choice and do appropriate action
		String choice = "0";
		while (!choice.equals("1") && !choice.equals("2") && !choice.equals("9")) {
			System.out.println("\n\nHello! Welcome to _INSERT_NAME_HERE_\n");
			System.out.println("If you are an existing user,\t enter 1");
			System.out.println("If you are a new user,\t\t enter 2\n");
			System.out.println("\t\tTo quit,\t enter 9\n");
			choice = input.next();
			if (choice.equals("1")) { // user login
				checkCredentials();
				choice = "0";
			} else if (choice.equals("2")) { // create new user
				UserCreation.createUser();
				choice = "0";
			} else if (choice.equals("9")) { // Quit out of the program
				OnClose.programHouseKeeping(); // Regular program houseKeeping if user quits here since normal termination
				System.exit(0);
			} else { // Ensure the user supplies a valid entry
				System.out.println("Incorrect entry detected.\n Existing users enter 1.\n New users enter 2.\n Enter 9 to quit.");
			}
		}
		input.close();
	}
	
	// Method that will prompt user for their username and password and log them in if correct credentials supplied
	public static void checkCredentials() {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter your username: ");
		// Check against usernames here
		User currentUser = new User();
		currentUser = ListOfUsers.searchUsers(input.nextLine());	
		if(currentUser == null) {
			System.out.println("Username not found");
			System.out.println("Enter any key to return to the login screen");
			input.next();
			return; // Rude implementation
		}
		// Check against passwords here
		System.out.print("\nPlease enter your password: ");
		if(!input.nextLine().equals(currentUser.getPassword())) {
			System.out.println("Incorrect password for user: " + currentUser.getUserName());
			return; // Rude implementation
		}
		System.out.println("\n\n\n\n\nSuccessfully logged in. Welcome " + currentUser.getFirstName() + " " + currentUser.getLastName());
		if(currentUser.getAdmin()) {
			AdminMenu.menu(currentUser);
		}
		else {
			if(currentUser.isLocked()) {
				System.out.println("\n\n***THIS ACCOUNT IS LOCKED. PLEASE CONTACT YOUR ADMINISTRATOR***\n\n");
			}
			else {
				UserMenu.menu(currentUser);
			}
		}
	}
}