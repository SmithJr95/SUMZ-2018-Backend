package edu.dhbw.ka.mwi.businesshorizon2.models.common;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TimeSeriesItem {
	
	@DecimalMin("1900")
	private int year;
	
	@NotNull
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
