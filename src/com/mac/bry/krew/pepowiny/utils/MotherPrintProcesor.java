package com.mac.bry.krew.pepowiny.utils;

import java.util.List;

import com.mac.bry.krew.pepowiny.entity.Mother;
import com.mac.bry.krew.pepowiny.entity.MotherAdress;

public class MotherPrintProcesor {
	
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
	
	public static void printMotherList(List<Mother> mother, List<MotherAdress> motherAdress) {
		printFirstFourLastMotherRow();
		printSecondMotherRow();
		printMidleLine();
		printThirdMotherRow();
		printFirstFourLastMotherRow();
		int lp=1;
	}
}
