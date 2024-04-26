package com.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static SessionFactory sessionfactory;
	public static SessionFactory getSessionFactory()
	{
		try
		{
			if(sessionfactory==null)
			{
				sessionfactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); 
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sessionfactory;
	}
	public static void closeFactory()
	{
		if(sessionfactory.isOpen())
		{
			sessionfactory.close();
		}
	}
}
