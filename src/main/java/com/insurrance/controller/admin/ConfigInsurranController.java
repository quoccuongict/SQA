package com.insurrance.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.insurrance.dao.ConfigInsuranceDAO;
import com.insurrance.model.LevelPrice;

@WebServlet(urlPatterns = {"/config-insurrance"})
public class ConfigInsurranController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ConfigInsuranceDAO configInsuranceDAO = new ConfigInsuranceDAO();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
		String idStr = request.getParameter("id");
		int id;
		LevelPrice levelPrice = null;
		String view = "";
		if(type.equals("list")){
			List<LevelPrice> levelPrices = configInsuranceDAO.findAll();
			request.setAttribute("levelPrices", levelPrices);
			view = "views/admin/listPrice.jsp";
		}else if(type.equals("edit")){
			if(idStr != null){
				id = Integer.parseInt(idStr);
				levelPrice = configInsuranceDAO.findOne(id);
				request.setAttribute("levelPrice", levelPrice);
			}
			view = "views/admin/editPrice.jsp";
		}else if(type.equals("delete")){
			if(idStr != null){
				id = Integer.parseInt(idStr);
				configInsuranceDAO.deleteLevelPrice(id);
				List<LevelPrice> levelPrices = configInsuranceDAO.findAll();
				request.setAttribute("levelPrices", levelPrices);
				view = "views/admin/listPrice.jsp";
				request.setAttribute("messageResponse", "Delete success!!!");
				request.setAttribute("alert", "success");
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
