package com.insurrance.model;

public class ReportMonth extends Report{

	private static final long serialVersionUID = 1L;
	private int month;
	private int year;
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return super.toString() + "month=" + month + ", year=" + year + "]";
	}
}
