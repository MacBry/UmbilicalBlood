package com.mac.bry.krew.pepowiny.utils;

import java.util.Scanner;

import com.mac.bry.krew.pepowiny.entity.Hospital;
import com.mac.bry.krew.pepowiny.entity.HospitalAdress;

public class HospitalDataReader {
	
	private Scanner scanner;

	public HospitalDataReader() {
		super();
		this.scanner = new Scanner(System.in);
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
			ReadAndCreateHospitalAdress();
		}
	}
	
	private HospitalAdress ReadAndCreateHospitalAdress() {
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
		
		return new HospitalAdress( tempCity,tempZipCode,tempPrefix,tempStreet,tempHouseNumber,tempLocalNumber);
	}
	
	public Hospital ReadAndCreateHospital() {
		System.out.println("Enter hospital name: ");
		String tempHospitalName = scanner.nextLine();
		Hospital tempHospital = new Hospital(tempHospitalName);
		tempHospital.setHospitalAdress(ReadAndCreateHospitalAdress());
		return tempHospital;
	}
	
	
}
