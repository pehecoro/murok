package com.pehecoro.murok.user;

import java.util.List;

import com.pehecoro.murok.util.DAOFactory;

public class UserRN {
	private UserDAO userDAO;
	public UserRN(){
		this.userDAO = DAOFactory.createUserDAO();
	}
	
	public User load(Integer id){
		return this.userDAO.load(id);
	}
	
	public User searchForEmail(String email){
		return this.userDAO.searchForEmail(email);
	}
	
	public void save(User user){
		Integer id = user.getId();
		if(id == null || id == 0){
			this.userDAO.save(user);
		}else{
			this.userDAO.update(user);
		}
	}
	
	public void delete(User user){
		this.userDAO.delete(user);
	}
	
	public List<User> list(){
		return this.userDAO.list();
	}
}
