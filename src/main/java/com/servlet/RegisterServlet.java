package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.HibernateUtil;
import com.entity.User;

@WebServlet("/userRegister")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String about = req.getParameter("about");
		
		User user = new User(name,email,password,about);
		System.out.println(user);
		HttpSession session = req.getSession();
		UserDao userdao = new UserDao(HibernateUtil.getSessionFactory());
		boolean flag = userdao.saveUser(user);
		if(flag)
		{
			session.setAttribute("msg","Register Succefully");
			resp.sendRedirect("register.jsp");
		}
		else
		{
			session.setAttribute("msg","Something went Wrong");
			resp.sendRedirect("register.jsp");
		}
	}
	
}
