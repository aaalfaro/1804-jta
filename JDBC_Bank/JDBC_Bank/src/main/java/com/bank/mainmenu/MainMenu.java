package com.bank.mainmenu;
import java.util.Scanner;

import com.bank.exception.IncorrectInputException;
import com.bank.factory.SignUp;
import com.bank.singleton.LogSingleton;

public class MainMenu{

	public static void startMenu() {
		LogSingleton.getInstance();
		System.out.println("Welcome!");
		System.out.println("Please select an option by number: ");
		System.out.println("1. Login");
		System.out.println("2. Sign Up");
		
		
		try (Scanner scan = new Scanner(System.in))
		{
			int mainOption = scan.nextInt();
			if (mainOption == 1){
				System.out.println("Sign in as: ");
				System.out.println("1: Admin");
				System.out.println("2. User");
			}
			
			if(mainOption == 2) {
				SignUp.signUp();
			}
		} catch (IncorrectInputException e) {
			LogSingleton.info("An error has occurred");
			startMenu();
		}
	}
}