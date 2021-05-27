package com.insurrance.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Customer implements Serializable{

	private static final long serialVersionUID = -1495446013543262253L;
	private int id;
	private String fullName;
	private String address;
	private Timestamp dateOfBirth;
	private String gender;
	
	public Customer() {
		super();
	}
	
	

	public Customer(String fullName) {
		super();
		this.fullName = fullName;
	}



	public Customer(int id, String fullName, String address, Timestamp dateOfBirth, String gender) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Timestamp dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return id + " " + fullName + " " + address + " " + dateOfBirth + " " + gender;
	}
}
