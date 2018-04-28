package com.revature.project_0;

import static com.revature.scanner.BankScanner.*;
import static com.revature.logger.BankLogger.*;
import java.util.Scanner;

public class UserMenu {
	// All the options available to the user once logged in
	public static void menu(User user) {
		String choice = "";
		while (choice != "1" && choice != "2" && choice != "3" && choice != "4" && choice != "9") {
			System.out.println("=============");
			System.out.println("  USER MENU");
			System.out.println("=============");
			System.out.println("To display account information\tEnter 1");
			System.out.println("To make a deposit\t\tEnter 2");
			System.out.println("To make a withdrawal\t\tEnter 3");
			System.out.println("For account management\t\tEnter 4\n");
			System.out.println("\t\tTo log out\tEnter 9");
			System.out.println("\n\n\n\n\n\n\n\n\n\n");
			choice = input.next();
			switch (choice) { // Get account information for the user
			case "1": {
				System.out.println("=======================");
				System.out.println("  ACCOUNT INFORMATION");
				System.out.println("=======================");
				System.out.println("Account Number: " + user.getAccountNumber());
				System.out.println("Account Holder Name: " + user.getFirstName() + " " + user.getLastName());
				System.out.println("Account username: " + user.getUsername());
				System.out.println("Current Balance: $" + user.getAccountBalance());
				System.out.println("\n\n\t\tEnter any key to return to user menu");
				input.next();
				System.out.println("\n\n\n\n\n\n");
				choice = "0";
				break;
			}

			case "2": { // Allow the user to make a deposit
				System.out.println("============");
				System.out.println("  DEPOSITS");
				System.out.println("============");
				System.out.println("How much would you like to deposit?");
				System.out.println("Account Balance: $" + user.getAccountBalance());
				try {
					String deposit = input.next() + input.nextLine();
					double newBalance = Double.parseDouble(user.getAccountBalance()) + Double.parseDouble(deposit);
					user.setAccountBalance(newBalance);
					System.out.println("\t\tDeposited!");
					logger
							.trace("User: " + user.getFirstName() + " " + user.getLastName() + " made a deposit.");
				} catch (NumberFormatException nfe) {
					System.out.println("Please enter a valid number for deposit");
					logger.info("Entry error");
				} finally {
					choice = "0";
				}
				break;
			}

			case "3": { // Allow the user to make a withdrawal
				System.out.println("===============");
				System.out.println("  WITHDRAWALS");
				System.out.println("===============");
				System.out.println("How much would you like to withdraw?");
				System.out.println("Account Balance: $" + user.getAccountBalance());
				try {
					String deposit = input.next() + input.nextLine();
					double newBalance = Double.parseDouble(user.getAccountBalance()) - Double.parseDouble(deposit);
					if (newBalance < 0) {
						System.out.println("\n\n\t\t***INSUFFICIENT FUNDS***");
						logger.trace(
								"User: " + user.getFirstName() + " " + user.getLastName() + " insufficient funds.");
					} else {
						user.setAccountBalance(newBalance);
						System.out.println("\t\tWithdrawn!");
						logger.trace(
								"User: " + user.getFirstName() + " " + user.getLastName() + " made a withdrawal.");
					}
				} catch (NumberFormatException nfe) {
					System.out.println("Please enter a valid number for deposit");
					logger.info("Entry error");
				} finally {
					choice = "0";
				}
				break;
			}

			case "4": { // Let the user change account settings
				optionOne(user);
				choice = "0";
				break;
			}

			default: { // catch incorrect entries
				System.out.println("Please enter a valid option");
				break;
			}

			case "9": { // Log out of user menu
				System.out.println("Successfully logged out. Bye " + user.getFirstName() + "!");
				logger.trace("User: " + user.getFirstName() + " " + user.getLastName() + " logged out.");
				return;
			}
			}
		}
	}

	// Account settings menu
	public static void optionOne(User user) {
		String choice = "";
		while (choice != "1" && choice != "2" && choice != "3" && choice != "4" && choice != "9") {
			System.out.println("======================");
			System.out.println("  ACCOUNT MANAGEMENT");
			System.out.println("======================");
			System.out.println("To change first name, Enter 1 followed by the new name");
			System.out.println("To change last name, Enter 2 followed by the last name");
			System.out.println("To change username, Enter 3 followed by the new username");
			System.out.println("To change password, Enter 4 followed by the new password");
			System.out.println("\n\n\t\tTo return\tEnter 9");
			System.out.println("\n\n\n\n\n\n\n\n\n\n");
			choice = input.next();
			switch (choice) {
			case "1": { // Let the user change their first name
				choice = input.nextLine();
				user.setFirstName(choice.replaceAll(" ", ""));
				System.out.println("First name changed to: " + user.getFirstName());
				logger.trace("User: " + user.getFirstName() + " " + user.getLastName() + " first name change.");
				break;
			}
			case "2": { // Let the user change their last name
				choice = input.nextLine();
				user.setLastName(choice.replaceAll(" ", ""));
				System.out.println("Last name changed to: " + user.getLastName());
				logger.trace("User: " + user.getFirstName() + " " + user.getLastName() + " last name change.");
				break;
			}
			case "3": { // Let the user change their username
				choice = input.nextLine();
				user.setUsername(choice.replaceAll(" ", ""));
				System.out.println("Username changed to: " + user.getUsername());
				logger.trace("User: " + user.getFirstName() + " " + user.getLastName() + " username change.");
				break;
			}
			case "4": { // Let the user change their password
				choice = input.nextLine();
				user.setPassword(choice.replaceAll(" ", ""));
				System.out.println("Password changed to: " + user.getPassword());
				logger.trace("User: " + user.getFirstName() + " " + user.getLastName() + " password change.");
				break;
			}
			default: {
				System.out.println("Please enter a valid option");
				break;
			}
			case "9": {
				return;
			}
			}
		}
	}
}
