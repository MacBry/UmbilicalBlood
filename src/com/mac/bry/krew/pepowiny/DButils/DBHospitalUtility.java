package com.mac.bry.krew.pepowiny.DButils;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mac.bry.krew.pepowiny.DButils.API.DBHospitalAPI;
import com.mac.bry.krew.pepowiny.entity.Hospital;
import com.mac.bry.krew.pepowiny.entity.HospitalAdress;
import com.mac.bry.krew.pepowiny.utils.HospitalPrintProcesor;

public class DBHospitalUtility implements DBHospitalAPI{
	
	private SessionFactory factory;
	

	public DBHospitalUtility() {
		super();
		this.factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Hospital.class)
				.addAnnotatedClass(HospitalAdress.class)
				.buildSessionFactory();
	}

	@Override
	public void addHospital(Hospital hospital) {
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(hospital);
		
		session.getTransaction().commit();
		
	}

	@Override
	public void deleteHospitalById(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Hospital hospitalToDelete = session.get(Hospital.class, id);
		session.delete(hospitalToDelete);
		session.getTransaction().commit();
	}

	@Override
	public List<Hospital> getAllHospital() {
		List<Hospital> tempHospitalList;
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		tempHospitalList = session.createQuery("from Hospital").getResultList();
		session.getTransaction().commit();
		return tempHospitalList;
		
	}

	@Override
	public List<HospitalAdress> getAllHospitalAdress() {
		List<HospitalAdress> tempHospitalList;
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		tempHospitalList = session.createQuery("from HospitalAdress").getResultList();
		session.getTransaction().commit();
		
		return tempHospitalList;
	}

	@Override
	public void showFullHospitalList() {
		HospitalPrintProcesor.printHospitalList(getAllHospital(), getAllHospitalAdress());
		
	}

	@Override
	public Hospital getHospitalById(int id) {
		Hospital tempHospital;
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		tempHospital = (Hospital)session.get(Hospital.class, id);
		session.getTransaction().commit();
		session.close();
		return tempHospital;
	}

}
