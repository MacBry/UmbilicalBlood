package com.mac.bry.krew.pepowiny.DButils.API;

import com.mac.bry.krew.pepowiny.entity.User;

public interface DBUserAPI {
	public boolean loginCheck(User tempUser);
	public boolean permissionCheck(User tempUser);
	public void addUser(User user);
	public void showAllUsers(boolean isAdministrator);
	public void showUsers();
	public void deleteUserByID(int id);
	public void editLogin(User user, String newLogin);
	public void editPassword(User user, String newPassword);
	public void editPermission(User user);
	User findUserByID(int ID);
	int findUserIDByLoginAndPassword(User user);
	
}
