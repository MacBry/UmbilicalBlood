package com.mac.bry.krew.pepowiny.DButils.API;

import java.util.List;

import com.mac.bry.krew.pepowiny.entity.Mother;
import com.mac.bry.krew.pepowiny.entity.MotherAdress;

public interface DBMotherAPI {
	public void addMother( Mother mother);
	public void deleteMotherById(int id);
	public void deleteMotherBySurname(String surname);
	public Mother getMotherById(int id);
	public Mother getMotherBySurname(String surname);
	public List <Mother> getAllMothers();
	public List <MotherAdress> getAllMothersAdress();	
	public void showMothers();
}
