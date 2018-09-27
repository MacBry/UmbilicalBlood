package com.mac.bry.krew.pepowiny.DButils;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mac.bry.krew.pepowiny.DButils.API.DBMotherAPI;
import com.mac.bry.krew.pepowiny.entity.Mother;
import com.mac.bry.krew.pepowiny.entity.MotherAdress;

public class DBMotherUtility implements DBMotherAPI {

	private SessionFactory factory;
	
	public DBMotherUtility() {
		super();
		this.factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Mother.class)
				.addAnnotatedClass(MotherAdress.class)
				.buildSessionFactory();	
	}
	
	@Override
	public void addMother(Mother mother) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(mother);
		session.getTransaction().commit();
	}

	@Override
	public void deleteMotherById(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Mother motherToDelete = session.get(Mother.class, id);
		session.delete(motherToDelete);
		session.getTransaction().commit();
	}

	@Override
	public void deleteMotherBySurname(String surname) {
		Mother motherToDelete = getMotherBySurname(surname);
		Session session = factory.getCurrentSession();
		session.delete(motherToDelete);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Mother getMotherById(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Mother tempMother = session.get(Mother.class, id);
		session.getTransaction().commit();
		return tempMother;
	}

	@Override
	public Mother getMotherBySurname(String surname) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Mother tempMother = (Mother)session.createQuery("select from Mother mother where mother.surname='" + surname + '"');
		session.getTransaction().commit();
		session.close();
		return tempMother;
	}

	@Override
	public List<Mother> getAllMothers() {
		List<Mother> tempMotherList;
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		tempMotherList = session.createQuery("from Mother").getResultList();
		session.getTransaction();
		session.close();
		return tempMotherList;
	}

	@Override
	public List<MotherAdress> getAllMothersAdress() {
		List<MotherAdress> tempMotherAdressList;
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		tempMotherAdressList = session.createQuery("from MotherAdress").getResultList();
		session.getTransaction();
		session.close();
		return tempMotherAdressList;
	}

}
