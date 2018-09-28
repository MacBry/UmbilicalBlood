package com.mac.bry.krew.pepowiny.utils;

import java.util.Scanner;

import com.mac.bry.krew.pepowiny.DButils.DBHospitalUtility;
import com.mac.bry.krew.pepowiny.entity.Hospital;
import com.mac.bry.krew.pepowiny.entity.Mother;
import com.mac.bry.krew.pepowiny.entity.MotherAdress;

public class MotherDataReder {
	
	private Scanner scanner;
	private DBHospitalUtility dbHospitalUtility;
	
	public MotherDataReder() {
		super();
		this.scanner = new Scanner(System.in);
		this.dbHospitalUtility = new DBHospitalUtility();
	}
	
	public void Close() {
		this.scanner.close();
	}
	
	private void prefixCheck(String tempPrefix) {
		if(tempPrefix.equals("ul.") || tempPrefix.equals("al.") || tempPrefix.equals("os.")) {
			System.out.println("prefix exist");
		}
		else {
			System.out.println("no such option try again enter hospital adress");
			readAndCreateMotherAdres();
		}
	}
	
	private MotherAdress readAndCreateMotherAdres() {
		System.out.println("Mother Adress SUB - Form:");
		System.out.println("=========================");
		System.out.println("Enter City: ");
		String tempCity = scanner.nextLine();
		
		System.out.println("Enter zip code: ");
		String tempZipCode = scanner.nextLine();
		
		System.out.println("Enter street prefix (ul./al./os.): ");
		String tempPrefix = scanner.nextLine();
		prefixCheck(tempPrefix);
		
		System.out.println("Enter street: ");
		String tempStreet = scanner.nextLine();
		
		System.out.println("Enter house number: ");
		String tempHouseNumber = scanner.nextLine();
		
		System.out.println("Enter localnumber: ");
		String tempLocalNumber = scanner.nextLine();
		
		return new MotherAdress (tempCity,tempZipCode,tempPrefix,tempStreet,tempHouseNumber,tempLocalNumber);
	}
	
	public Mother readAndCreateMother() {
		System.out.println("Mother - Form:");
		System.out.println("==============");
		System.out.println("Enter mother surname: ");
		String tempSurname = scanner.nextLine();
		System.out.println("Enter mother name: ");
		String tempName = scanner.nextLine();
		System.out.println("Enter mother pesel: ");
		String tempPESEL = scanner.nextLine();
		Mother tempMother = new Mother(tempSurname, tempName, tempPESEL);
		System.out.println("Enter hospital id: ");
		int tempHospitalID = scanner.nextInt();
		scanner.nextLine();
		tempMother.setMotherAdress(readAndCreateMotherAdres());
		tempMother.setHospital(dbHospitalUtility.getHospitalById(tempHospitalID));
		return tempMother;
	}
	
	
	

}
