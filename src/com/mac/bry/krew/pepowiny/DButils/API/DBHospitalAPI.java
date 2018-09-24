package com.mac.bry.krew.pepowiny.DButils.API;

import java.util.List;

import com.mac.bry.krew.pepowiny.entity.Hospital;
import com.mac.bry.krew.pepowiny.entity.HospitalAdress;

public interface DBHospitalAPI {
	public void addHospital(Hospital hospital);
	public void deleteHospitalById(int id);
	public List<Hospital> getAllHospital();
	public List<HospitalAdress> getAllHospitalAdress();
	public void showFullHospitalList();
	public Hospital getHospitalById(int id);
}
