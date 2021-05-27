package com.insurrance.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.insurrance.dao.ConfigInsuranceDAO;
import com.insurrance.model.LevelPrice;

@WebServlet(urlPatterns = {"/edit-insurrance"})
public class EditInsurranceController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ConfigInsuranceDAO configInsuranceDAO = new ConfigInsuranceDAO();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String idStr = request.getParameter("id");
		String typeLevel = request.getParameter("typeLevel");
		String priceStr = request.getParameter("price");
		String description = request.getParameter("description");
		LevelPrice levelPrice = null;
		LevelPrice result = null;
		float price = 0;
		int id;
		String view = "views/admin/editPrice.jsp";
		if(priceStr != null){
			price = Float.parseFloat(priceStr);
		}
		if(StringUtils.isNotBlank(idStr)){
			id = Integer.parseInt(idStr);
			levelPrice = new LevelPrice(id, typeLevel, price, description);
			result = configInsuranceDAO.updateLevePrice(levelPrice);
			request.setAttribute("messageResponse", "Update success!!!");
		}else{
			levelPrice = new LevelPrice(typeLevel, price, description);
			id = configInsuranceDAO.addLevePrice(levelPrice);
			result = configInsuranceDAO.findOne(id);
			request.setAttribute("messageResponse", "Insert success!!!");
		}
		request.setAttribute("levelPrice", result);
		request.setAttribute("alert", "success");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
