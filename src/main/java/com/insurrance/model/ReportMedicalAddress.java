package com.insurrance.model;

import java.util.List;

public class ReportMedicalAddress extends Report{

	private static final long serialVersionUID = 1L;
	private String medicalAddress;
	
	public ReportMedicalAddress() {
		super();
	}

	public ReportMedicalAddress(String type, List<Insurance> insurances, int quantity, float total, String medicalAddress) {
		super(type, insurances, quantity, total);
		this.medicalAddress = medicalAddress;
	}

	public String getMedicalAddress() {
		return medicalAddress;
	}

	public void setMedicalAddress(String medicalAddress) {
		this.medicalAddress = medicalAddress;
	}

	@Override
	public String toString() {
		return super.toString() + "medicalAddress=" + medicalAddress + "]";
	}
}
