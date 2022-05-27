package com.orenda.lifesecure.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orenda.lifesecure.model.User;
import com.orenda.lifesecure.model.UserDetails;

@Repository
@Transactional
public class LifeSecureLoginDaoImpl implements LifeSecureLoginDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public User getUserDetailsByEmailId(String username) {

		Session session = sessionFactory.openSession();
		User user = null;
		try {

		Query query = session.createQuery("from User where user_email=?");
		user = (User) query.setParameter(0, username).getSingleResult();
		} catch (Exception e) {

		}
//		
		return user;
	}

	@Override
	public UserDetails getUserType(String username) {
		Session session = sessionFactory.openSession();
		UserDetails userdetails=null;
		try {
		Query query = session.createQuery("from UserDetails where userEmail=?");
		userdetails = (UserDetails) query.setParameter(0, username).getSingleResult();
		System.out.println(userdetails);
		}catch(Exception e) {
			
		}
		return userdetails;
	}

	public List<UserDetails> getData() {
		Session session = sessionFactory.openSession();
		List <UserDetails>userList=null;
		try {
		
		  userList = session.createCriteria(UserDetails.class).list();
		}catch(Exception e) {
			
		}
		return userList;

	}
	
	//forgot code

	@Override
	public User getUserInDb(String emailId) {
		User user = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			Query query = session.createQuery("from User where user_email=?");

			user = (User) query.setParameter(0, emailId).getSingleResult();
		} catch (Exception e) {

		}
		return user;
	}

	@Override
	public boolean resetPasswordDb(String emailId, String newPassword) {

		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from User where user_email=?");

			User user = (User) query.setParameter(0, emailId).getSingleResult();
			user.setPassword(newPassword);

			Transaction tr = session.beginTransaction();
			session.saveOrUpdate(user);
			tr.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}
