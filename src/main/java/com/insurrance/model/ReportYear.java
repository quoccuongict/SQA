package com.insurrance.model;

public class ReportYear extends Report{

	private static final long serialVersionUID = 1L;
	private int year;
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return super.toString() + "year=" + year + "]";
	}
	
	
}
