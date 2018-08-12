package com.mac.bry.krew.pepowiny.DBtest;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTest {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/JdbcTest.java?useSSL=false&serverTimezone=UTC";
		String user = "MacBry";
		String pass = "MacBry";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn =
					DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!!!");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}

}
