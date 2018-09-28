package com.mac.bry.krew.pepowiny.utils;

import java.util.List;

import com.mac.bry.krew.pepowiny.entity.Mother;
import com.mac.bry.krew.pepowiny.entity.MotherAdress;

public class MotherPrintProcesor {
	
	private static void printFirstFourLastMotherRow() {
		for(int i = 0 ; i <= 157; i ++) {
			System.out.print("=");
		}
		System.out.println();
	}
	
	private static void printSecondMotherRow() {
		System.out.printf("|| %-5s || %-5s || %-14s ||  %-14s || %-100s ||","LP","ID", "MOTHER SURNAME", "MOTHER NAME", "HOSPITAL ADRESS");
		System.out.println();
	}
	
	public static void printMotherList(List<Mother> mother, List<MotherAdress> motherAdress) {
		printFirstFourLastMotherRow();
		printSecondMotherRow();
	}
}
