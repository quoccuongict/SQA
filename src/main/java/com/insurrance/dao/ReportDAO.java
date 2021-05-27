package com.insurrance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.insurrance.model.Customer;
import com.insurrance.model.Insurance;
import com.insurrance.model.LevelPrice;
import com.insurrance.model.ReportMedicalAddress;
import com.insurrance.model.ReportMonth;
import com.insurrance.model.ReportYear;
import com.insurrance.utils.DateUtil;

public class ReportDAO {

	private Connection con = null;
	
	public ReportMedicalAddress reportByMedicalAddress(String medicalAddress){
		ReportMedicalAddress report = new ReportMedicalAddress();
		List<Insurance> insurances = new ArrayList<>();
		String sql = "select h.id, h.insurancecode, h.startdate, h.expireddate, h.medicaladdress, c.fullname, c.address, c.date_of_birth, c.gender, l.typelevel, l.price, l.`description` from healthinsurance as h inner join customer as c on h.userid = c.id inner join `level` as l on h.levelid = l.id where h.medicaladdress = ? order by l.price desc";
		try {
			con = DBConnection.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, medicalAddress);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				Insurance insurance = new Insurance();
                Customer customer = new Customer();
                LevelPrice levelPrice = new LevelPrice();
                
                customer.setFullName(rs.getString("fullname"));
                customer.setAddress(rs.getString("address"));
                customer.setDateOfBirth(rs.getTimestamp("date_of_birth"));
                customer.setGender(rs.getString("gender"));
                
                levelPrice.setTypeLevel(rs.getString("typelevel"));
                levelPrice.setPrice(rs.getFloat("price"));
                levelPrice.setDescription(rs.getString("description"));
                
                insurance.setId(rs.getInt("id"));
                insurance.setInsuranceCode(rs.getString("insurancecode"));
                insurance.setStartDate(rs.getTimestamp("startdate"));
                insurance.setExpiredDate(rs.getTimestamp("expireddate"));
                insurance.setMedicalAddress(rs.getString("medicaladdress"));
                insurance.setCustomer(customer);
                insurance.setLevelPrice(levelPrice);
                
                insurances.add(insurance);
			}
			report.setMedicalAddress(medicalAddress);
			report.setInsurances(insurances);
			report.setType("medicalAddress");
			report.setQuantity(insurances);
			report.setTotal(insurances);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return report;
	}
	
	public ReportMonth reportByMonth(int month, int year){
		ReportMonth report = new ReportMonth();
		List<Insurance> insurances = new ArrayList<>();
		String startDate = DateUtil.getStartDate(month, year);
		String expiredDate = DateUtil.getExpiredDate(month, year);
		String sql = "select h.id, h.insurancecode, h.startdate, h.expireddate, h.medicaladdress, c.fullname, c.address, c.date_of_birth, c.gender, l.typelevel, l.price, l.`description` from healthinsurance as h inner join customer as c on h.userid = c.id inner join `level` as l on h.levelid = l.id where h.startdate >= ? and h.startdate < ? order by l.price desc";
		try {
			con = DBConnection.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, startDate);
			statement.setString(2, expiredDate);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				Insurance insurance = new Insurance();
                Customer customer = new Customer();
                LevelPrice levelPrice = new LevelPrice();
                
                customer.setFullName(rs.getString("fullname"));
                customer.setAddress(rs.getString("address"));
                customer.setDateOfBirth(rs.getTimestamp("date_of_birth"));
                customer.setGender(rs.getString("gender"));
                
                levelPrice.setTypeLevel(rs.getString("typelevel"));
                levelPrice.setPrice(rs.getFloat("price"));
                levelPrice.setDescription(rs.getString("description"));
                
                insurance.setId(rs.getInt("id"));
                insurance.setInsuranceCode(rs.getString("insurancecode"));
                insurance.setStartDate(rs.getTimestamp("startdate"));
                insurance.setExpiredDate(rs.getTimestamp("expireddate"));
                insurance.setMedicalAddress(rs.getString("medicaladdress"));
                insurance.setCustomer(customer);
                insurance.setLevelPrice(levelPrice);
                
                insurances.add(insurance);
			}
			report.setMonth(month);
			report.setYear(year);
			report.setInsurances(insurances);
			report.setType("month");
			report.setQuantity(insurances);
			report.setTotal(insurances);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return report;
	}
	
	public ReportYear reportByYear(int year){
		ReportYear report = new ReportYear();
		List<Insurance> insurances = new ArrayList<>();
		String sql = "select h.id, h.insurancecode, h.startdate, h.expireddate, h.medicaladdress, c.fullname, c.address, c.date_of_birth, c.gender, l.typelevel, l.price, l.`description` from healthinsurance as h inner join customer as c on h.userid = c.id inner join `level` as l on h.levelid = l.id where YEAR(h.startdate) = ? order by l.price desc";
		try {
			con = DBConnection.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, year);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				Insurance insurance = new Insurance();
                Customer customer = new Customer();
                LevelPrice levelPrice = new LevelPrice();
                
                customer.setFullName(rs.getString("fullname"));
                customer.setAddress(rs.getString("address"));
                customer.setDateOfBirth(rs.getTimestamp("date_of_birth"));
                customer.setGender(rs.getString("gender"));
                
                levelPrice.setTypeLevel(rs.getString("typelevel"));
                levelPrice.setPrice(rs.getFloat("price"));
                levelPrice.setDescription(rs.getString("description"));
                
                insurance.setId(rs.getInt("id"));
                insurance.setInsuranceCode(rs.getString("insurancecode"));
                insurance.setStartDate(rs.getTimestamp("startdate"));
                insurance.setExpiredDate(rs.getTimestamp("expireddate"));
                insurance.setMedicalAddress(rs.getString("medicaladdress"));
                insurance.setCustomer(customer);
                insurance.setLevelPrice(levelPrice);
                
                insurances.add(insurance);
			}
			report.setYear(year);
			report.setInsurances(insurances);
			report.setType("year");
			report.setQuantity(insurances);
			report.setTotal(insurances);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return report;
	}
	
}
