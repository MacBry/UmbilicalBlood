package com.mac.bry.krew.pepowiny.utils;

import java.util.List;

import com.mac.bry.krew.pepowiny.DButils.DBHospitalUtility;
import com.mac.bry.krew.pepowiny.entity.Hospital;
import com.mac.bry.krew.pepowiny.entity.HospitalAdress;
import com.mac.bry.krew.pepowiny.entity.Mother;
import com.mac.bry.krew.pepowiny.entity.MotherAdress;

public class MotherPrintProcesor {
	
	private static DBHospitalUtility dbHospitalUtility = new DBHospitalUtility();
	
	private static void printFirstFourLastMotherRow() {
		for(int i = 0 ; i <= 209; i ++) {
			System.out.print("=");
		}
		System.out.println();
	}
	
	private static void printSecondMotherRow() {
		System.out.printf("|| %-5s || %-5s || %-14s || %-14s || %-14s || %-100s || %-28s ||","LP","ID", "MOTHER SURNAME", "MOTHER NAME", "MOTHER PESEL" , "MOTHER ADRESS", "HOSPITAL DATA");
		System.out.println();
	}
	
	private static void printThirdMotherRow(){
		System.out.printf("|| %-5s || %-5s || %-14s || %-14s || %-14s || %-20s || %-10s || %-5s || %-25s || %-10s || %-10s || %-12s || %-12s ||",
				"", "", "", "", "", "CITY", "ZIP CODE", "P-FIX", "STREET", "HOUSE NUM.", "LOCAL NUM.", "HOSPITAL ID", "ADRESS ID");
		System.out.println();
	}
	private static void printMidleLine() {
		System.out.print("||");
		for(int i = 0 ; i <=65; i ++ ) {
			if(i == 7 || i == 15 || i ==32 || i == 49) {
				System.out.print("||");
			}
			else System.out.print(" ");
		}
		
		System.out.print("||");
		for(int i = 0 ; i <= 133; i++) {
			System.out.print("=");
		}
		System.out.print("||");
		System.out.println();
	}
	
	public static void printMotherList(List<Mother> mothersList, List<MotherAdress> mothersAdressList) {
		List<Hospital> hospitalsList = dbHospitalUtility.getAllHospital();
		List<HospitalAdress> hospitalsAdressList = dbHospitalUtility.getAllHospitalAdress();
		printFirstFourLastMotherRow();
		printSecondMotherRow();
		printMidleLine();
		printThirdMotherRow();
		printFirstFourLastMotherRow();
		int lp=1;
		for(int i = 0 ; i < mothersList.size() ; i++) {
			for(int k = 0 ; k < mothersAdressList.size() ; k++) {
				for(int j = 0 ; j < hospitalsList.size() ; j++) {
					for(int m = 0 ; m < hospitalsAdressList.size() ; m++) {
						if(mothersList.get(i).getId() == mothersAdressList.get(k).getId() 
								&& mothersList.get(i).getHospital().getId() == hospitalsList.get(j).getId()
								&& hospitalsList.get(j).getId() == hospitalsAdressList.get(m).getId());
						
						System.out.printf("|| %-5s || %-5s || %-14s || %-14s || %-14s || %-20s || %-10s || %-5s || %-25s || %-10s || %-10s || %-12s || %-12s ||",
								lp,
								mothersList.get(i).getId(),
								mothersList.get(i).getSurname(),
								mothersList.get(i).getName(),
								mothersList.get(i).getPESEL(),
								mothersAdressList.get(k).getCity(),
								mothersAdressList.get(k).getZipCode(),
								mothersAdressList.get(k).getPrefix(),
								mothersAdressList.get(k).getStreet(),
								mothersAdressList.get(k).getHouseNumber(),
								mothersAdressList.get(k).getLocalNumber(),
								hospitalsList.get(j).getId(),
								hospitalsAdressList.get(j).getId());
					}
				}
			}
			lp++;
			System.out.println();
		}
		printFirstFourLastMotherRow();
	}
	
}
