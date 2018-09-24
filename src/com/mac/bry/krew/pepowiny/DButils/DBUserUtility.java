package com.mac.bry.krew.pepowiny.DButils;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mac.bry.krew.pepowiny.DButils.API.DBUserAPI;
import com.mac.bry.krew.pepowiny.entity.User;
import com.mac.bry.krew.pepowiny.utils.UserPrintProcesor;

public class DBUserUtility implements DBUserAPI {
	
	private SessionFactory factory;

	public DBUserUtility() {
		super();
		this.factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.buildSessionFactory();
	}
	
	@Override
	public boolean loginCheck(User tempUser) {
		List<User> userList;
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		userList = session.createQuery("from User user where user.login='" + tempUser.getLogin() + "' and user.password='" + tempUser.getPassword() +"'").getResultList();
		session.getTransaction().commit();
		if(userList.isEmpty()) {
			return false;
		}
		else return true ;
	}
	
	@Override
	public boolean permissionCheck(User tempUser) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		User user = (User) session.createQuery("from User user where user.login='" + tempUser.getLogin() + "' and user.password='" + tempUser.getPassword() +"'").getSingleResult();
		session.getTransaction().commit();
		return user.isPermission();
	}
	
	@Override
	public void addUser(User user) {
		List<User> userList;
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		userList = session.createQuery("from User user where user.login='" + user.getLogin() + "'").getResultList();
		if(userList.isEmpty()) {
			session.save(user);
			session.getTransaction().commit();
		}
		else {
			System.out.println("Incorrect login");	
			session.getTransaction().commit();
		}
	}
	
	public void showAllUsers(boolean isAdministrator) {
		List<User> userList;
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		userList = session.createQuery("from User").getResultList();
		session.getTransaction().commit();
		if(isAdministrator) {
			UserPrintProcesor.administratorPrintUsersList(userList);
		}
		else UserPrintProcesor.userPrintUsersList(userList);
	}
	
	@Override
	public void showUsers() {
		List <Integer> idList;
		List <User> userList = new ArrayList<User>();
		User tempUser;
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		idList = session.createQuery("Select user.id from User user where user.permission=true").getResultList();
		for(Integer id : idList) {
			tempUser = (User) session.createQuery("from User user where user.id='" + id + "'").getSingleResult();
			userList.add(tempUser);
			System.out.println(tempUser.getPassword());
		}
		UserPrintProcesor.administratorPrintUsersList(userList);
		
	}
	
	@Override
	public void deleteUserByID(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.createQuery("delete from User user where user.id='" + id + "'").executeUpdate();
		session.getTransaction().commit();
	}
	
	@Override
	public User findUserByID(int ID) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		User tempUser = session.get(User.class, ID);
		return tempUser;
	}
	
	@Override
	public int findUserIDByLoginAndPassword(User user) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		int tempID;
		User tempUser =(User) session.createQuery("from User user where user.login='" 
				+ user.getLogin() + "' and user.password='" 
				+ user.getPassword() + "'")
				.getSingleResult();
		session.getTransaction().commit();
		tempID = tempUser.getId();
		return tempID;
		
	}
	
	@Override
	public void editLogin(User user, String newLogin) {
		String oldLogin = user.getLogin();
		Session session = factory.getCurrentSession();
		user.setLogin(newLogin);
		session.getTransaction().commit();
		System.out.println("You have changed field from " + oldLogin + " to " + user.getLogin());
	}
	
	@Override
	public void editPassword(User user, String newPassword) {
		String oldPassword = user.getLogin();
		Session session = factory.getCurrentSession();
		user.setPassword(newPassword);
		session.getTransaction().commit();
		System.out.println("You have changed field from " + oldPassword + " to " + user.getPassword());
	}
	
	@Override
	public void editPermission(User user) {
		boolean oldPermission = user.isPermission();
		Session session = factory.getCurrentSession();
		if(user.isPermission()) {
			user.setPermission(false);
			System.out.println("You have changed field from " + oldPermission + " to " + user.isPermission());
		}
		else {
			user.setPermission(true);
			System.out.println("You have changed field from " + oldPermission + " to " + user.isPermission());
		}
		session.getTransaction().commit();
	}
}
