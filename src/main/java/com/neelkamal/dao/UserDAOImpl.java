package com.neelkamal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.neelkamal.model.User;
@Repository
public class UserDAOImpl implements UserDAO{
	
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public void addUser(User user) {
		Session session  = sessionFactory.getCurrentSession();
		session.persist(user);
		
	}

	public void updateUser(User user) {
		Session session  = sessionFactory.getCurrentSession();
		session.update(user);
		
	}

	public void deleteUser(int id) {
		Session session  = sessionFactory.getCurrentSession();
		User user = (User)session.load(User.class,id);
		if(null != user){
			session.delete(user);
		}
		
	}

	public List<User> listUser() {
		Session session  = sessionFactory.getCurrentSession();
		List<User> personList = session.createQuery("from User").list();
		return personList;
	}

	public User getUserById(int id) {
		Session session  = sessionFactory.getCurrentSession();
		return (User)session.get(User.class,id);
	}

}