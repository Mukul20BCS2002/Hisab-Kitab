package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ExpenseDao;
import com.db.HibernateUtil;
import com.entity.Expense;
import com.entity.User;

@WebServlet("/addExpense")
public class AddExpenseServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		String title = req.getParameter("title");
		String date = req.getParameter("date");
		String time = req.getParameter("time");
		String price = req.getParameter("price");
		String description = req.getParameter("description");
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("loginUser");
		
		Expense expense = new Expense(title,date,time,price,description,user);
		ExpenseDao expensedao = new ExpenseDao(HibernateUtil.getSessionFactory());
		boolean flag = expensedao.saveExpense(expense);
		if(flag)
		{
			session.setAttribute("msg","Expense added successfully");
			resp.sendRedirect("user/addExpense.jsp");
		}
		else
		{
			session.setAttribute("msg","Something went wrong");
			resp.sendRedirect("user/addExpense.jsp");
		}
	}
}
