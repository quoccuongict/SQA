package com.insurrance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.insurrance.model.Customer;
import com.insurrance.model.Insurance;
import com.insurrance.model.LevelPrice;

import paging.Pageble;

public class InsuranceDAO {

	private Connection con = null;
	
	public List<Insurance> findAll(Pageble pageble, String keyword){
		con = DBConnection.getConnection();
		List<Insurance> insurances = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder("select h.id, h.insurancecode, h.startdate, h.expireddate, h.medicaladdress, c.fullname, c.address, c.date_of_birth, c.gender, l.typelevel, l.price, l.`description` from healthinsurance as h inner join customer as c on h.userid = c.id inner join `level` as l on h.levelid = l.id");
		if(StringUtils.isNotBlank(keyword)){
			sql.append(" where h.medicaladdress like '%" + keyword + "%'");
		}
		if(pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())){
			sql.append(" order by " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + "");
		}
		if(pageble.getOffset() != null && pageble.getLimit() != null){
			sql.append(" limit " + pageble.getOffset() + ", " + pageble.getLimit() + "");
		}
		try {
			PreparedStatement statement = con.prepareStatement(sql.toString());
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insurances;
	}
	
	public int getTotalItem(String keyword){
		con = DBConnection.getConnection();
		int totalItem = 0;
		StringBuilder sql = new StringBuilder("select count(*) from healthinsurance");
		if(StringUtils.isNotBlank(keyword)){
			sql.append(" where medicaladdress like '%" + keyword + "%'");
		}
		try {
			PreparedStatement statement = con.prepareStatement(sql.toString());
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				totalItem = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalItem;
	}
}
