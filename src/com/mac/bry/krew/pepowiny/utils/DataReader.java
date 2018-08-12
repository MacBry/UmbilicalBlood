package com.mac.bry.krew.pepowiny.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.mac.bry.krew.pepowiny.entity.User;

public class DataReader {
	
	private Scanner scanner;

	public DataReader() {
		super();
		this.scanner = new Scanner(System.in);
	}
	
	public void CloseScanner() {
		this.scanner.close();
	}
	
	public int ReadNumber(String msg) {
		while(true) {
			System.out.println("Enter " + msg);
			
			try {
				int tempNumber = scanner.nextInt();
				scanner.nextLine();
				return tempNumber;
			} catch (InputMismatchException e) {
				System.err.println("It's not a number\n");
				scanner.nextLine();
				continue;
			}
		}
	}
	
	public int ReadNumber() {
		while(true) {	
			try {
				int tempNumber = scanner.nextInt();
				scanner.nextLine();
				return tempNumber;
			} catch (InputMismatchException e) {
				System.err.println("It's not a number\n");
				scanner.nextLine();
				continue;
			}
		}
	}
	
	public String ReadString(String msg) {
		System.out.println("Enter " + msg);
		String tempString = scanner.nextLine();
		return tempString;
	}
	
	public String ReadString() {
		String tempString = scanner.nextLine();
		return tempString;
	}
	
	public User LoginUser() {
		System.out.println("Enter login: ");
		String tempLogin = scanner.nextLine();
		
		
		System.out.println("Enter password: ");
		String tempPassword = scanner.nextLine();
		
		User tempUser = new User (tempLogin, tempPassword);
		
		return  tempUser;
	}
	
	public User ReadAndCreateUser() {
		System.out.println("Enter login: ");
		String tempLogin = scanner.nextLine();
		
		System.out.println("Enter password: ");
		String tempPassword = scanner.nextLine();
		
		System.out.println("Confirm password: ");
		String tempConfirmPassword = scanner.nextLine();
		
		System.out.println("Admin Permission: (YES/NO)");
		boolean tempPermission = false;
		String tempAnswer = scanner.nextLine();
		if(tempAnswer.equals("YES")) {
			tempPermission = true;
		}
		else if (tempAnswer.equals("NO")) {
			tempPermission = false;
		}
		else {
			System.out.println("Ther is no such option");
			ReadAndCreateUser();
		}
		
		if(!tempPassword.equals(tempConfirmPassword)) {
			System.out.println("Incorect password!");
			ReadAndCreateUser();
		}
		return new User (tempLogin, tempPassword, tempPermission);
	}
}
