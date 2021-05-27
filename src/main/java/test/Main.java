package test;

import java.sql.Connection;
import java.util.List;

import com.insurrance.dao.ConfigInsuranceDAO;
import com.insurrance.dao.DBConnection;
import com.insurrance.dao.InsuranceDAO;
import com.insurrance.dao.ReportDAO;
import com.insurrance.dao.UserDAO;
import com.insurrance.model.Insurance;
import com.insurrance.model.LevelPrice;
import com.insurrance.model.Report;
import com.insurrance.model.ReportMedicalAddress;
import com.insurrance.model.ReportMonth;
import com.insurrance.model.User;
import com.insurrance.utils.DateUtil;

import paging.PageRequest;
import paging.Pageble;
import sort.Sorter;

public class Main {

	public static void main(String[] args) {
//		Pageble pageble = new PageRequest(4, 2, new Sorter("startdate", "asc"));
//		InsuranceDAO dao = new InsuranceDAO();
//		List<Insurance> insurances = dao.findAll(pageble, "Hà");
//		insurances.forEach(insurance -> System.out.println(insurance));
//		System.out.println(dao.getTotalItem("Hà"));
		
//		ConfigInsuranceDAO configInsuranceDAO = new ConfigInsuranceDAO();
//		List<LevelPrice> levelPrices = configInsuranceDAO.findAll();
//		LevelPrice levelPrice = new LevelPrice();
//		levelPrice.setId(6);
//		levelPrice.setTypeLevel("Mức 6.1");
//		levelPrice.setPrice(100001);
//		levelPrice.setDescription("Mức đóng người thứ 6 trở lên trong gia đình hh");
//		LevelPrice result = configInsuranceDAO.updateLevePrice(levelPrice);
//		System.out.println(result);
//		LevelPrice levelPrice = configInsuranceDAO.findOne(1);
//		System.out.println(levelPrice);
//		levelPrices.forEach(level -> System.out.println(level));
		
		ReportDAO dao = new ReportDAO();
//		ReportMedicalAddress report = dao.reportByMedicalAddress("Hà Đông");
//		System.out.println(report);
		Connection con = DBConnection.getConnection();
		String sql = "select convert(varchar, h.startdate, 103) from healthinsurance h where h.id = 1";
		
		
//		System.out.println(DateUtil.getStartDate(12, 2020));
//		System.out.println(DateUtil.getExpiredDate(12, 2020));
		ReportMonth report = dao.reportByMonth(1, 2021);
//		System.out.println(report);
		UserDAO  userDAO = new UserDAO();
		User user = userDAO.checkLogin("admin1", "admin");
		System.out.println(user);
	}
}
