package edu.dhbw.ka.mwi.businesshorizon2.models.common;

import java.util.EnumSet;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import edu.dhbw.ka.mwi.businesshorizon2.models.comparators.TimeSeriesItemDateComparator;
import edu.dhbw.ka.mwi.businesshorizon2.validators.IsDateFormatConsistentValidator.DateFormats;

public class TimeSeriesItem{
	
	@NotNull(message="year must not be null.")
	@DecimalMin(value="1900", message="year must be >=1900 and <=2100.")
	@DecimalMax(value="2100", message="year must be >=1900 and <=2100.")
	private Integer year;
	
	@Min(value=1, message="quarter must be an element of the set {1, 2, 3, 4}.")
	@Max(value=4, message="quarter must be an element of the set {1, 2, 3, 4}.")
	private Integer quarter;
	
	@NotNull(message="amount must not be null.")
	private Double amount;
	
	public Integer getYear() { return year; }
	public void setYear(Integer year) { this.year = year; }
	
	public Integer getQuarter() { return quarter; }
	public void setQuarter(Integer quarter) { this.quarter = quarter; }

	public Double getAmount() { return amount; }
	public void setAmount(Double amount) { this.amount = amount; }
	
	public boolean datesEqual(TimeSeriesItem other) {
		TimeSeriesItemDateComparator comparator = new TimeSeriesItemDateComparator();
		
		return comparator.compare(this, other) == 0;
	} 
	
	@Override
	public String toString() {
		String result = "Year: " +  this.year + ",\t" + "Quarter: " + this.quarter +  ",\t" + "Amount: " + this.amount;
		
		return result;
	}
}
