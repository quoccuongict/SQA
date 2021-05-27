package com.insurrance.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Insurance implements Serializable{

	private static final long serialVersionUID = -314785317133651231L;

	private int id;
    private String insuranceCode;
    private Timestamp startDate;
    private Timestamp expiredDate;
    private String medicalAddress;
    private Customer customer;
    private LevelPrice levelPrice;
    
	public Insurance() {
		super();
	}
	

	public Insurance(int id, String insuranceCode, String medicalAddress, Customer customer, LevelPrice levelPrice) {
		super();
		this.id = id;
		this.insuranceCode = insuranceCode;
		this.medicalAddress = medicalAddress;
		this.customer = customer;
		this.levelPrice = levelPrice;
	}



	public Insurance(int id, String insuranceCode, Timestamp startDate, Timestamp expiredDate, String medicalAddress,
			Customer customer, LevelPrice levelPrice) {
		super();
		this.id = id;
		this.insuranceCode = insuranceCode;
		this.startDate = startDate;
		this.expiredDate = expiredDate;
		this.medicalAddress = medicalAddress;
		this.customer = customer;
		this.levelPrice = levelPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInsuranceCode() {
		return insuranceCode;
	}

	public void setInsuranceCode(String insuranceCode) {
		this.insuranceCode = insuranceCode;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Timestamp expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String getMedicalAddress() {
		return medicalAddress;
	}

	public void setMedicalAddress(String medicalAddress) {
		this.medicalAddress = medicalAddress;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LevelPrice getLevelPrice() {
		return levelPrice;
	}

	public void setLevelPrice(LevelPrice levelPrice) {
		this.levelPrice = levelPrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
	@Override
	public String toString() {
		return id + " " + insuranceCode + " " + startDate + " " + expiredDate + " " + medicalAddress + " " + customer + " " + levelPrice;
	}
}
