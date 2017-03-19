package com.pehecoro.murok.util;

import com.pehecoro.murok.user.UserDAO;
import com.pehecoro.murok.user.UserDAOHibernate;

public class DAOFactory {

	public static UserDAO createUserDAO(){
		UserDAOHibernate userDAO = new UserDAOHibernate();
		userDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return userDAO;
	}
	
}
