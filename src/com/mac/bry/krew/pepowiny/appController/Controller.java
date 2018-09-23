package com.mac.bry.krew.pepowiny.appController;

import java.util.InputMismatchException;

import com.mac.bry.krew.pepowiny.DButils.DBHospitalUtility;
import com.mac.bry.krew.pepowiny.DButils.DBUserUtility;
import com.mac.bry.krew.pepowiny.entity.User;
import com.mac.bry.krew.pepowiny.utils.DataReader;
import com.mac.bry.krew.pepowiny.utils.HospitalDataReader;

public class Controller {

	public static final int MAIN_LOGIN_OPTION = 1;
	public static final int MAIN_EXIT_OPTION = 0;
	
	public static final int MAIN_ADMINISTRATOR_USER_OPTION = 1;
	public static final int MAIN_ADMINISTRATOR_HOSPITAL_OPTION = 2;
	public static final int MAIN_ADMINISTRATOR_UMBLICAL_OPTION = 3;
	public static final int MAIN_ADMINISTRATOR_EXIT_OPTION = 0;
	
	public static final int ADMINISTRATOR_ADD_USER = 1;
	public static final int ADMINISTRATOR_DELETE_USER = 2;
	public static final int ADMINISTRATOR_EDIT_LOGIN_USER = 3;
	public static final int ADMINISTRATOR_EDIT_PASSWORD_USER = 4;
	public static final int ADMINISTRATOR_EDIT_PERMISSION_USER = 5;
	public static final int ADMINISTRATOR_SHOW_USERS = 6;
	public static final int ADMINISTRATOR_EXIT_USER = 0;
	
	public static final int ADMINISTRATOR_ADD_HOSPITAL = 1;
	public static final int ADMINISTRATOR_DELETE_HOSPITAL = 2;
	public static final int ADMINISTRATOR_SHOW_ALL_HOSPITAL = 3;
	public static final int ADMINISTRATOR_EEXIT_HOSPITAL = 0;
	
	public static final int USER_USER_OPTION = 1;
	public static final int USER_HOSPITAL_OPTION = 2;
	public static final int USER_UMBLICAL_OPTION = 3;
	public static final int USER_EXIT_OPTION = 0;
	
	public static final int USER_EDIT_SELF_LOGIN = 1;
	public static final int USER_EDIT_SELF_PASSWORD = 2;
	public static final int USER_SHOW_USERS = 3;
	public static final int USER_EXIT_USER = 0;
	
	private User user;
	private DataReader dataReader;
	private DBUserUtility dbUserUtility;
	private DBHospitalUtility dbHospitalUtility;
	private HospitalDataReader hospitalDataReader;
	
	public Controller() {
		super();
		this.dataReader = new DataReader();
		this.dbUserUtility = new DBUserUtility();
		this.dbHospitalUtility = new DBHospitalUtility();
		this.hospitalDataReader = new HospitalDataReader();
	}
	
	public void ProgramLoop() {
		printLoginOptions();
		int option;
		
		while( (option = dataReader.ReadNumber())  != MAIN_EXIT_OPTION) {
			switch (option) {
			case MAIN_LOGIN_OPTION:
				user = dataReader.LoginUser();
				if (dbUserUtility.loginCheck(user)) {
					System.out.println("\nSuccesful!");

					if (dbUserUtility.permissionCheck(user)) {
						System.out.println("\nAdministrator Permissions");
						AdministratorLoop();
						
					} else {
						System.out.println("\nUser Persmissions");
						UserLoop();
					}
				} else {
					System.out.println("\nTry again");
					ProgramLoop();
				}
				break;

			default:
				System.err.println("\nNo such option");
				ProgramLoop();
				break;
			}	
		}
		Runtime.getRuntime().exit(0);
	}
	
	public void AdministratorLoop() {
		
		printMainAdministrationOptions();
		int option;
		while( (option = dataReader.ReadNumber())!= MAIN_ADMINISTRATOR_EXIT_OPTION) {
			switch (option) {
			case MAIN_ADMINISTRATOR_USER_OPTION:
				AdministratorUserMenue();
				break;
					
			case MAIN_ADMINISTRATOR_HOSPITAL_OPTION:
				AdministratorHospitalMenue();
				break;
					
			case MAIN_ADMINISTRATOR_UMBLICAL_OPTION:
				break;
					
			default:
				System.out.println("\nNo such option");
				AdministratorLoop();
				break;
			}	
		}
		ProgramLoop();
	}
	
	public void UserLoop() {
		printMainUserOptions();
		int option;
		
		while((option = dataReader.ReadNumber()) != USER_EXIT_OPTION) {
			switch (option) {
			case USER_USER_OPTION:
				userUserMenue();
				break;
				
			case USER_HOSPITAL_OPTION:
				
				break;
				
			case USER_UMBLICAL_OPTION:
				
				break;

			default:
				System.out.println("\nNo such option");
				break;
			}
		}
		ProgramLoop();
	}
	
	public void userUserMenue() {
		printUserMenueOptions();
		int option;
		
		while((option = dataReader.ReadNumber()) != USER_EXIT_OPTION) {
			switch (option) {
			case USER_EDIT_SELF_LOGIN:
			System.out.println("Edit self Login");
			dbUserUtility.editLogin(dbUserUtility.findUserByID(dbUserUtility.findUserIDByLoginAndPassword(user)), dataReader.ReadString("new Login"));
				break;
				
			case USER_EDIT_SELF_PASSWORD:
			System.out.println("Edit self Password");
			dbUserUtility.editPassword(dbUserUtility.findUserByID(dbUserUtility.findUserIDByLoginAndPassword(user)), dataReader.ReadString("new Password"));
				break;

			case USER_SHOW_USERS:
			dbUserUtility.showAllUsers(false);	
				break;
				
			default:
				System.out.println("\nNo such option");
				userUserMenue();
				break;
			}
		}
		UserLoop();
	}
	
	public void AdministratorUserMenue() {
		printAdministratotrUserMenuOptions();
		int option;
		while((option =dataReader.ReadNumber()) != ADMINISTRATOR_EXIT_USER){
			switch (option) {
			case ADMINISTRATOR_ADD_USER:
				System.out.println("Add User");
				dbUserUtility.addUser(dataReader.ReadAndCreateUser());
				break;
				
			case ADMINISTRATOR_DELETE_USER:
				System.out.println("Delete User");
				dbUserUtility.deleteUserByID(dataReader.ReadNumber("ID"));
				break;
				
			case ADMINISTRATOR_EDIT_LOGIN_USER:
				System.out.println("Edit Login User");
				dbUserUtility.editLogin(dbUserUtility.findUserByID(dataReader.ReadNumber("ID")), dataReader.ReadString("new Login"));
				break;
				
			case ADMINISTRATOR_EDIT_PASSWORD_USER:
				System.out.println("Edit Password User");
				dbUserUtility.editPassword(dbUserUtility.findUserByID(dataReader.ReadNumber("ID")), dataReader.ReadString("new Password"));
				break;
				
			case  ADMINISTRATOR_EDIT_PERMISSION_USER:
				System.out.println("Edit Permission User");
				dbUserUtility.editPermission(dbUserUtility.findUserByID(dataReader.ReadNumber("ID")));
				break;
				
			case  ADMINISTRATOR_SHOW_USERS:
				System.out.println("Show Users");
				dbUserUtility.showAllUsers(true);
				break;	
				
			default:
				System.out.println("\nNo such option");
				break;
			}
			
		}
		AdministratorLoop();
	}
	
	public void AdministratorHospitalMenue () {
		printAdministratotrHospitalMenuOptions();
		int option;
		while((option = dataReader.ReadNumber()) != ADMINISTRATOR_EEXIT_HOSPITAL) {
			switch (option) {
			case ADMINISTRATOR_ADD_HOSPITAL:
				dbHospitalUtility.addHospital(hospitalDataReader.ReadAndCreateHospital());
				AdministratorHospitalMenue();
				break;
			case ADMINISTRATOR_DELETE_HOSPITAL:
				dbHospitalUtility.deleteHospitalById(dataReader.ReadNumber("ID"));
				break;
			case ADMINISTRATOR_SHOW_ALL_HOSPITAL:
				dbHospitalUtility.showFullHospitalList();
				break;

			default:
				break;
			}
		}
		AdministratorHospitalMenue();
	}
	
	
	private void printAdministratotrHospitalMenuOptions() {
		printLine();
		System.out.println("Chose Option: ");
		printLine();
		System.out.println("1. Add Hospital");
		System.out.println("2. Delete Hospital");
		System.out.println("3. Show all Hospital");
		System.out.println("0. Exit ");
		
	}

	public void printLoginOptions() {
		printLine();
		System.out.println("Chose Option: ");
		printLine();
		System.out.println("1. Login ");
		System.out.println("0. Exit ");
	}
	
	public void printMainAdministrationOptions() {
		printLine();
		System.out.println("Chose Option: ");
		printLine();
		System.out.println("1. User Administration Menu");
		System.out.println("2. Hospital Administration Menu");
		System.out.println("3. Umbilical Blood Menu");
		System.out.println("0. Exit ");
	}
	
	public void printAdministratotrUserMenuOptions() {
		printLine();
		System.out.println("Chose Option: ");
		printLine();
		System.out.println("1. Add user");
		System.out.println("2. Delete user");
		System.out.println("3. Edit login of selected user");
		System.out.println("4. Edit password of selected user");
		System.out.println("5. Edit permission of selected user");
		System.out.println("6. Show all users");
		System.out.println("0. Exit ");
	}
	
	public void printUserMenueOptions() {
		printLine();
		System.out.println("Chose Option: ");
		printLine();
		System.out.println("1. Edit login");
		System.out.println("2. Edit password");
		System.out.println("3. Show all users");
		System.out.println("0. Exit ");
	}
	
	public void printMainUserOptions() {
		printLine();
		System.out.println("Chose Option: ");
		printLine();
		System.out.println("1. User Menu");
		System.out.println("2. Hospital Menu");
		System.out.println("3. Umbilical Blood Menu");
		System.out.println("0. Exit ");
	}
	
	private void printLine() {
		for(int i = 0 ; i<20 ; i++) {
			System.out.print("=");
		}
		System.out.println();
	}
	
}
