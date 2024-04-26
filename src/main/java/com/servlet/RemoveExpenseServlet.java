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


@WebServlet("/removeExpense")
public class RemoveExpenseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		int id = Integer.parseInt(req.getParameter("id"));
		ExpenseDao expensedao = new ExpenseDao(HibernateUtil.getSessionFactory());
		boolean flag = expensedao.removeExpense(id);
		HttpSession session = req.getSession();
		if(flag)
		{
			session.setAttribute("msg","Expense updated successfully");
			resp.sendRedirect("user/viewExpense.jsp");
		}
		else
		{
			session.setAttribute("msg","Something went wrong");
			resp.sendRedirect("user/viewExpense.jsp");
		}
	}
}
