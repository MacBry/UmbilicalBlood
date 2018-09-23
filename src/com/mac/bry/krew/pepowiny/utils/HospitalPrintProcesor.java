package com.mac.bry.krew.pepowiny.utils;

import java.util.List;

import com.mac.bry.krew.pepowiny.entity.Hospital;
import com.mac.bry.krew.pepowiny.entity.HospitalAdress;

public class HospitalPrintProcesor {
	
	private static void printFirstFourLastHospitalRow() {
		for(int i = 0 ; i <= 153; i++) {
			System.out.print("=");
		}
		System.out.println();
	}
	
	private static void printSecondHospitalRow() {
		System.out.printf("|| %-10s || %-30s || %-100s ||","LP", "HOSPITAL NAME", "HOSPITAL ADRESS");
		System.out.println();
	}
	
	private static void printThirdHospitalRow() {
		System.out.printf("|| %-10s || %-30s || %-20s || %-10s || %-5s || %-25s || %-10s || %-10s ||",
				"", "", "CITY", "ZIP CODE", "P-FIX", "STREET", "HOUSE NUM.", "LOCAL NUM.");
		System.out.println();
	}
	
	
	public static void printHospitalList(List<Hospital> hospitalList, List<HospitalAdress> hospitalAdressList) {
		printFirstFourLastHospitalRow();
		printSecondHospitalRow();
		printThirdHospitalRow();
		printFirstFourLastHospitalRow();
		int lp=1;
		for(int i = 0 ; i < hospitalList.size() ; i++) {
			for(int j = 0 ; j < hospitalAdressList.size(); j++) {
				if(hospitalList.get(i).getId() == hospitalAdressList.get(j).getId()) {
					System.out.printf("|| %-10d || %-30s || %-20s || %-10s || %-5s || %-25s || %-10s || %-10s ||",
							lp,
							hospitalList.get(i).getHostpitalName(),
							hospitalAdressList.get(j).getCity(),
							hospitalAdressList.get(j).getZipCode(),
							hospitalAdressList.get(j).getPrefix(),
							hospitalAdressList.get(j).getStreet(),
							hospitalAdressList.get(j).getHouseNumber(),
							hospitalAdressList.get(j).getLocalNumber());
				}
			}
			lp++;
			System.out.println();
		}
		
		printFirstFourLastHospitalRow();
	}
}
