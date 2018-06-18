package edu.dhbw.ka.mwi.businesshorizon2.models.common;

public class TimeSeriesItem {
	private int year;
	private Quarters quarter;
	private int amount;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Quarters getQuarter() {
		return quarter;
	}
	public void setQuarter(Quarters quarter) {
		this.quarter = quarter;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		String result = "Year: " +  this.year + ", " + "Quarter: " + quarter.name() +  ", " + "Amount: " + this.amount;
		
		return result;
	}
}
