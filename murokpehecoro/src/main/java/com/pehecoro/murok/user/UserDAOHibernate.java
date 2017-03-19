		package com.pehecoro.murok.user;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class UserDAOHibernate implements UserDAO {
	private Session session;
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void save(User user) {
		this.session.save(user);
	}

	@Override
	public void update(User user) {
		this.session.update(user);
	}

	@Override
	public void delete(User user) {
		this.session.delete(user);
	}

	@Override
	public User load(Integer id) {
		return (User) this.session.get(User.class, id);
	}

	@Override
	public User searchForEmail(String email) {
		String hql = "select u from User u where u.email = :email";
		Query query = this.session.createQuery(hql);
		query.setString("email", email);
		return (User) query.uniqueResult();
	}

	@Override
	public List<User> list() {
		return this.session.createCriteria(User.class).list();
	}

}
