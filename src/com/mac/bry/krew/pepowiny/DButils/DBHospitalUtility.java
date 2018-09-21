package com.mac.bry.krew.pepowiny.DButils;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mac.bry.krew.pepowiny.DButils.API.DBHospitalAPI;
import com.mac.bry.krew.pepowiny.entity.Hospital;
import com.mac.bry.krew.pepowiny.entity.HospitalAdress;

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
		session.createQuery("delete from Hospital hospital where hospital.id='" + id + "'")
			.executeUpdate();
		session.getTransaction().commit();
	}

	@Override
	public List<Hospital> showAllHospital() {
		// TODO Auto-generated method stub
		return null;
	}

}
