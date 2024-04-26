package com.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.entity.User;

public class UserDao {
	private SessionFactory sessionfactory = null;
	private Session session = null;
	private Transaction transaction = null;
	
	public UserDao(SessionFactory sessionfactory)
	{
		super();
		this.sessionfactory = sessionfactory;
	}
	public boolean saveUser(User user)
	{
		boolean flag = false;
		try
		{
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			flag = true;
		}
		catch (Exception e) {
			// TODO: handle exception
			if(transaction!=null)
			{
				flag = false;
				e.printStackTrace();
			}
		}
		return flag;
	}
	public User login(String email,String password)
	{
		User user = null;
		try
		{
			Session session = sessionfactory.openSession();
			Criteria criteria = session.createCriteria(User.class);
            // Add restrictions for email and password
            criteria.add(Restrictions.eq("email", email));
            criteria.add(Restrictions.eq("password", password));
            // Execute the query
            user = (User) criteria.uniqueResult(); 
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return user;
	}
}
