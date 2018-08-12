package com.mac.bry.krew.pepowiny.utils;

import java.util.List;

import com.mac.bry.krew.pepowiny.entity.User;

public class UserPrintProcesor {

	private static  void printFirstThirdLastUserRow() {
		for(int i = 0 ; i <= 101; i++) {
			System.out.print("=");
		}
		System.out.println();
	}
	private static void printSecondUserRow() {
		System.out.printf("|| %-10s || %-10s || %-20s || %-20s || %-20s ||", "LP", "ID", "LOGIN", "PASSWORD", "PERMISSION");
		System.out.println();
	}
	
	
	public static void administratorPrintUsersList(List<User> userList) {
		printFirstThirdLastUserRow();
		printSecondUserRow();
		printFirstThirdLastUserRow();
		int lp = 1;
		for(User u : userList) {
			System.out.printf("|| %-10d || %-10d || %-20s || %-20s || %-20b ||", lp, u.getId(), u.getLogin(), u.getPassword(), u.isPermission());
			lp++;
			System.out.println();
		}
		printFirstThirdLastUserRow();
	}
	
	public static void userPrintUsersList(List<User> userList) {
		printFirstThirdLastUserRow();
		printSecondUserRow();
		printFirstThirdLastUserRow();
		int lp = 1;
		for(User u : userList) {
			System.out.printf("|| %-10d || %-10d || %-20s || %-20s || %-20b ||", lp, u.getId(), u.getLogin(), "************", u.isPermission());
			lp++;
			System.out.println();
		}
		printFirstThirdLastUserRow();
	}
}
