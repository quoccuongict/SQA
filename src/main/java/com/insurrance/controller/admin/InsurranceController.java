package com.insurrance.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.insurrance.dao.InsuranceDAO;
import com.insurrance.model.Insurance;

import paging.PageRequest;
import paging.Pageble;
import sort.Sorter;

@WebServlet(urlPatterns = {"/admin-insurrance"})
public class InsurranceController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private InsuranceDAO insuranceDAO = new InsuranceDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String view;
		String type = request.getParameter("type");
		String pageStr = request.getParameter("page");
		String maxPageItemStr = request.getParameter("maxPageItem");
		String sortName = request.getParameter("sortName");
		String sortBy = request.getParameter("sortBy");
		String keyword = request.getParameter("keyword");
		Integer page = 0;
		Integer maxPageItem = 0;
		if(type.equals("list")){
			if(pageStr != null){
				page = Integer.parseInt(pageStr);
			}
			if(maxPageItemStr != null){
				maxPageItem = Integer.parseInt(maxPageItemStr);
			}
			Pageble pageble = new PageRequest(page, maxPageItem, new Sorter(sortName, sortBy));
			List<Insurance> insurances = insuranceDAO.findAll(pageble, keyword);
			Integer totalItem = insuranceDAO.getTotalItem(keyword);
			Integer totalPage = (int) Math.ceil((double) totalItem / maxPageItem);
			view = "views/admin/list.jsp";
			request.setAttribute("insurances", insurances);
			request.setAttribute("totalItem", totalItem);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("page", page);
			request.setAttribute("keyword", keyword);
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
