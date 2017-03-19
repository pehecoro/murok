package com.pehecoro.murok.web;

import javax.faces.bean.*;

import com.pehecoro.murok.user.User;

@ManagedBean(name="userBean")
@RequestScoped
public class UserBean {

	private User user = new User();
	private String confirmPassword;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	
}
