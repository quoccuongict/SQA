package com.insurrance.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.insurrance.dao.UserDAO;
import com.insurrance.model.User;

@WebServlet(urlPatterns = {"/dang-nhap"})
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = new UserDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = request.getParameter("message");
		String alert = request.getParameter("alert");
		if(message != null && alert != null){
			request.setAttribute("message", "Username or Password is invalid");
			request.setAttribute("alert", alert);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/login.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userDAO.checkLogin(username, password);
		if(user != null){
			HttpSession session = request.getSession();
			session.setAttribute("USER", user);
			if(user.getRole().equals("ADMIN")){
				response.sendRedirect(request.getContextPath() + "/admin-home");
			}
		}else{
//			request.setAttribute("message", "Incorrect username or password");
//			request.setAttribute("alert", "danger");
			response.sendRedirect(request.getContextPath() + "/dang-nhap?message=username_password_invalid&alert=danger");
		}
	}
}
