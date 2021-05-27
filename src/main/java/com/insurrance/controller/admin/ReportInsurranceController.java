package com.insurrance.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.insurrance.dao.ReportDAO;
import com.insurrance.model.ReportMedicalAddress;
import com.insurrance.model.ReportMonth;
import com.insurrance.model.ReportYear;

@WebServlet(urlPatterns = {"/report-insurrance"})
public class ReportInsurranceController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ReportDAO reportDAO = new ReportDAO();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
		String medicalAddress = "";
		String view = "";
		if(type.equals("medicalAddress")){
			medicalAddress = request.getParameter("address");
			if(StringUtils.isNotBlank(medicalAddress)){
				ReportMedicalAddress report = reportDAO.reportByMedicalAddress(medicalAddress);
				request.setAttribute("report", report);
//				request.setAttribute("address", medicalAddress);
			}
			view = "views/admin/report.jsp";
		}else if(type.equals("month")){
			String monthStr = request.getParameter("month");
			String yearStr = request.getParameter("year");
			if(StringUtils.isNotBlank(monthStr) && StringUtils.isNotBlank(yearStr)){
				int month = Integer.parseInt(monthStr);
				int year = Integer.parseInt(yearStr);
				ReportMonth report = reportDAO.reportByMonth(month, year);
				request.setAttribute("report", report);
			}
			view = "views/admin/reportMonth.jsp";
		}else if(type.equals("year")){
			String yearStr = request.getParameter("year");
			if(StringUtils.isNotBlank(yearStr)){
				int year = Integer.parseInt(yearStr);
				ReportYear report = reportDAO.reportByYear(year);
				request.setAttribute("report", report);
			}
			view = "views/admin/reportYear.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
