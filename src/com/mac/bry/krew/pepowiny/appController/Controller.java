package com.mac.bry.krew.pepowiny.appController;

import java.util.InputMismatchException;

import com.mac.bry.krew.pepowiny.DButils.DBHospitalUtility;
import com.mac.bry.krew.pepowiny.DButils.DBMotherUtility;
import com.mac.bry.krew.pepowiny.DButils.DBUserUtility;
import com.mac.bry.krew.pepowiny.entity.User;
import com.mac.bry.krew.pepowiny.utils.DataReader;
import com.mac.bry.krew.pepowiny.utils.HospitalDataReader;
import com.mac.bry.krew.pepowiny.utils.MotherDataReder;
import com.mac.bry.krew.pepowiny.utils.MotherPrintProcesor;

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
	
	public static final int USER_ADD_HOSPITAL = 1;
	public static final int USER_SHOW_ALL_HOSPITAL = 2;
	public static final int USER_EEXIT_HOSPITAL = 0;
	
	public static final int USER_USER_OPTION = 1;
	public static final int USER_HOSPITAL_OPTION = 2;
	public static final int USER_UMBLICAL_OPTION = 3;
	public static final int USER_EXIT_OPTION = 0;
	
	public static final int USER_EDIT_SELF_LOGIN = 1;
	public static final int USER_EDIT_SELF_PASSWORD = 2;
	public static final int USER_SHOW_USERS = 3;
	public static final int USER_EXIT_USER = 0;
	
	public static final int UMBLICAL_ADD_MOTHER = 1;
	public static final int UMBLICAL_DELETE_MOTHER_BY_ID = 2;
	public static final int UMBLICAL_DELETE_MOTHER_BY_SURNAME = 3;
	public static final int UMBLICAL_FIND_MOTHER_BY_ID = 4;
	public static final int UMBLICAL_FIND_MOTHER_BY_SURNAME = 5;
	public static final int UMBLICAL_SHOW_FULL_MOTHERS_LIST = 6;
	public static final int UMBLICAL_EXIT = 0;
	
	
	  
	private User user;
	private DataReader dataReader;
	private DBUserUtility dbUserUtility;
	private DBHospitalUtility dbHospitalUtility;
	private HospitalDataReader hospitalDataReader;
	private MotherDataReder motherDataReder;
	private DBMotherUtility dbMotherUtility;
	
	
	public Controller() {
		super();
		this.dataReader = new DataReader();
		this.dbUserUtility = new DBUserUtility();
		this.dbHospitalUtility = new DBHospitalUtility();
		this.hospitalDataReader = new HospitalDataReader();
		this.motherDataReder = new MotherDataReder();
		this.dbMotherUtility = new DBMotherUtility();
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
				umblicalMenue();
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
				userHospitalMenue();
				break;
				
			case USER_UMBLICAL_OPTION:
				umblicalMenue();
				break;

			default:
				System.out.println("\nNo such option");
				break;
			}
		}
		ProgramLoop();
	}
	
	public void umblicalMenue() {
		printMotherOption();
		int option;
		
		while((option = dataReader.ReadNumber()) != UMBLICAL_EXIT) {
			switch (option) {
			case UMBLICAL_ADD_MOTHER:
				dbMotherUtility.addMother(motherDataReder.readAndCreateMother());
				umblicalMenue();
				break;
				
			case UMBLICAL_DELETE_MOTHER_BY_ID:
				dbMotherUtility.deleteMotherById(dataReader.ReadNumber("ID"));
				umblicalMenue();
				break;
				
			case UMBLICAL_DELETE_MOTHER_BY_SURNAME:
				dbMotherUtility.deleteMotherById(dataReader.ReadNumber("surname"));
				umblicalMenue();
				break;
				
			case UMBLICAL_FIND_MOTHER_BY_ID:
				
				umblicalMenue();
				break;
				
			case UMBLICAL_FIND_MOTHER_BY_SURNAME:
				
				umblicalMenue();
				break;
				
			case UMBLICAL_SHOW_FULL_MOTHERS_LIST:
				dbMotherUtility.showMothers();
				umblicalMenue();
				break;
				

			default:
				System.out.println("\nNo such option");
				umblicalMenue();
				break;
			}
		}
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
				AdministratorUserMenue();
				break;
				
			case ADMINISTRATOR_DELETE_USER:
				System.out.println("Delete User");
				dbUserUtility.deleteUserByID(dataReader.ReadNumber("ID"));
				AdministratorUserMenue();
				break;
				
			case ADMINISTRATOR_EDIT_LOGIN_USER:
				System.out.println("Edit Login User");
				dbUserUtility.editLogin(dbUserUtility.findUserByID(dataReader.ReadNumber("ID")), dataReader.ReadString("new Login"));
				AdministratorUserMenue();
				break;
				
			case ADMINISTRATOR_EDIT_PASSWORD_USER:
				System.out.println("Edit Password User");
				dbUserUtility.editPassword(dbUserUtility.findUserByID(dataReader.ReadNumber("ID")), dataReader.ReadString("new Password"));
				AdministratorUserMenue();
				break;
				
			case  ADMINISTRATOR_EDIT_PERMISSION_USER:
				System.out.println("Edit Permission User");
				dbUserUtility.editPermission(dbUserUtility.findUserByID(dataReader.ReadNumber("ID")));
				AdministratorUserMenue();
				break;
				
			case  ADMINISTRATOR_SHOW_USERS:
				System.out.println("Show Users");
				dbUserUtility.showAllUsers(true);
				AdministratorUserMenue();
				break;	
				
			default:
				System.out.println("\nNo such option");
				AdministratorUserMenue();
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
				AdministratorHospitalMenue();
				break;
			case ADMINISTRATOR_SHOW_ALL_HOSPITAL:
				dbHospitalUtility.showFullHospitalList();
				AdministratorHospitalMenue();
				break;

			default:
				System.out.println("\nNo such option");
				AdministratorHospitalMenue();
				break;
			}
		}
		AdministratorHospitalMenue();
	}
	
	public void userHospitalMenue () {
		printUserHospitalOptions();
		int option;
		while((option = dataReader.ReadNumber()) != USER_EEXIT_HOSPITAL) {
			switch (option) {
			case USER_ADD_HOSPITAL:
				dbHospitalUtility.addHospital(hospitalDataReader.ReadAndCreateHospital());
				userHospitalMenue();
				break;
				
			case USER_SHOW_ALL_HOSPITAL:
				dbHospitalUtility.showFullHospitalList();
				userHospitalMenue();
				break;

			default:
				System.out.println("\nNo such option");
				userHospitalMenue();
				break;
			}
		}
		userHospitalMenue();
	}
	
	private void printMotherOption() {
		printLine();
		System.out.println("Chose Option: ");
		printLine();
		System.out.println("1. Add mother");
		System.out.println("2. Delete mother by ID");
		System.out.println("3. Delete mother by surname");
		System.out.println("4. Find mother by ID");
		System.out.println("5. Find mother by surname");
		System.out.println("6. Show full mothers list");
		System.out.println("0. Exit ");
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
	
	private void printUserHospitalOptions() {
		printLine();
		System.out.println("Chose Option: ");
		printLine();
		System.out.println("1. Add Hospital");
		System.out.println("2. Show all Hospital");
		System.out.println("0. Exit ");
	}

	private void printLoginOptions() {
		printLine();
		System.out.println("Chose Option: ");
		printLine();
		System.out.println("1. Login ");
		System.out.println("0. Exit ");
	}
	
	private void printMainAdministrationOptions() {
		printLine();
		System.out.println("Chose Option: ");
		printLine();
		System.out.println("1. User Administration Menu");
		System.out.println("2. Hospital Administration Menu");
		System.out.println("3. Umbilical Blood Menu");
		System.out.println("0. Exit ");
	}
	
	private void printAdministratotrUserMenuOptions() {
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
	
	private void printUserMenueOptions() {
		printLine();
		System.out.println("Chose Option: ");
		printLine();
		System.out.println("1. Edit login");
		System.out.println("2. Edit password");
		System.out.println("3. Show all users");
		System.out.println("0. Exit ");
	}
	
	private void printMainUserOptions() {
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
