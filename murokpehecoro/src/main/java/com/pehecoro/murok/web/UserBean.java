package com.pehecoro.murok.web;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import com.pehecoro.murok.user.User;
import com.pehecoro.murok.user.UserRN;

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
	
	public String newUser(){
		this.user = new User();
		this.user.setLive(true);
		this.user.setLevel(0);
		return "/public/user";
	}
	
	public String save(){
		FacesContext context = FacesContext.getCurrentInstance();
		
		String password = this.user.getPassword();
		if(!password.equals(this.confirmPassword)){
			FacesMessage facesMessage = new FacesMessage("The passwords doesn't match");
			context.addMessage(null, facesMessage);
			return null;
		}
		
		UserRN userRN = new UserRN();
		userRN.save(this.user);
		
		return "usersuccess";
	}
	
}
