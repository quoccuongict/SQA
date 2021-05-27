package com.insurrance.model;

import java.io.Serializable;
import java.util.List;

public class Report implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String type;
	private List<Insurance> insurances;
	private int quantity;
	private float total;
	
	public Report() {
	}

	public Report(String type, List<Insurance> insurances, int quantity, float total) {
		super();
		this.type = type;
		this.insurances = insurances;
		this.quantity = quantity;
		this.total = total;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Insurance> getInsurances() {
		return insurances;
	}

	public void setInsurances(List<Insurance> insurances) {
		this.insurances = insurances;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(List<Insurance> insurances) {
		this.quantity = insurances.size();
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(List<Insurance> insurances) {
		float s = 0;
		for(Insurance insurance : insurances){
			s += insurance.getLevelPrice().getPrice();
		}
		this.total = s;
	}

	@Override
	public String toString() {
		return "Report [type=" + type + ", insurances=" + insurances + ", quantity=" + quantity + ", total=" + total
				+ " ";
	}
}
