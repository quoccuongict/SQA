package com.insurrance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.insurrance.model.LevelPrice;

public class ConfigInsuranceDAO {

	private Connection con = null;
	
	public List<LevelPrice> findAll(){
		List<LevelPrice> levelPrices = new ArrayList<>();
		String sql = "select * from level";
		try {
			con = DBConnection.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				LevelPrice levelPrice = new LevelPrice();
				levelPrice.setId(rs.getInt("id"));
				levelPrice.setTypeLevel(rs.getString("typelevel"));
				levelPrice.setPrice(rs.getFloat("price"));
				levelPrice.setDescription(rs.getString("description"));
				
				levelPrices.add(levelPrice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return levelPrices;
	}
	
	public LevelPrice findOne(int id){
		LevelPrice levelPrice = null;
		String sql = "select * from level where id = ?";
		try {
			con = DBConnection.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				levelPrice = new LevelPrice();
				levelPrice.setId(rs.getInt("id"));
				levelPrice.setTypeLevel(rs.getString("typelevel"));
				levelPrice.setPrice(rs.getFloat("price"));
				levelPrice.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return levelPrice;
	}
	
	public Integer addLevePrice(LevelPrice levelPrice){
		Integer id = null;
		String sql = "insert into level (typelevel, price, description) values (?, ?, ?)";
		try {
			con = DBConnection.getConnection();
			PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, levelPrice.getTypeLevel());
			statement.setFloat(2, levelPrice.getPrice());
			statement.setString(3, levelPrice.getDescription());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if(rs.next()){
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public LevelPrice updateLevePrice(LevelPrice levelPrice){
		LevelPrice result = null;
		String sql = "update level set typelevel = ?, price = ?, description = ? where id = ?";
		try {
			con = DBConnection.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, levelPrice.getTypeLevel());
			statement.setFloat(2, levelPrice.getPrice());
			statement.setString(3, levelPrice.getDescription());
			statement.setInt(4, levelPrice.getId());
			statement.executeUpdate();
			result = findOne(levelPrice.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void deleteLevelPrice(int id){
		String sql = "delete from level where id = ?";
		try {
			con = DBConnection.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
