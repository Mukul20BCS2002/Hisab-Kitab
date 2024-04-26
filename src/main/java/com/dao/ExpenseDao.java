package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Expense;
import com.entity.User;

public class ExpenseDao {
	private SessionFactory sessionfactory = null;
	private Session session = null;
	private Transaction transaction = null;
	
	public ExpenseDao(SessionFactory sessionfactory)
	{
		super();
		this.sessionfactory = sessionfactory;
	}
	public boolean saveExpense(Expense expense)
	{
		boolean flag = false;
		try
		{
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.save(expense);
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
	public List<Expense> getAllEntry(User user)
	{
		List<Expense>list = new ArrayList<Expense>();
		try
		{
			session = sessionfactory.openSession();
			Query q = session.createQuery("from Expense where user=:user");
			q.setParameter("user",user);
			list = q.list();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public Expense getExpenseById(int id)
	{
		Expense expense = null;
		try
		{
			session = sessionfactory.openSession();
			Query q = session.createQuery("from Expense where id=:id");
			q.setParameter("id", id);
			expense = (Expense) q.uniqueResult();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return expense;
	}
	public boolean updateExpense(Expense expense) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try
		{
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(expense);
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
	public boolean removeExpense(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try
		{
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			Expense expense = session.get(Expense.class,id);
			session.delete(expense);
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
}
