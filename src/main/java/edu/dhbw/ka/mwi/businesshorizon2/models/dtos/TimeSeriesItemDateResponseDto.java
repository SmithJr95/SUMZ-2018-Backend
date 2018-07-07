package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TimeSeriesItemDateResponseDto {
	
	@NotNull(message="year must not be null.")
	@DecimalMin(value="1900", message="year must be >=1900 and <=2100.")
	@DecimalMax(value="2100", message="year must be >=1900 and <=2100.")
	private Integer year;
	
	@Min(value=1, message="quarter must be an element of the set {1, 2, 3, 4}.")
	@Max(value=4, message="quarter must be an element of the set {1, 2, 3, 4}.")
	private Integer quarter;
	
	public TimeSeriesItemDateResponseDto() {
	}
	
	public TimeSeriesItemDateResponseDto(Integer year) {
		this.year = year;
	}
	
	public TimeSeriesItemDateResponseDto(Integer year, Integer quarter) {
		this.year = year;
		this.quarter = quarter;
	}
		
	public Integer getYear() { return year; }
	public void setYear(Integer year) { 
		this.year = year;
	}
	
	public Integer getQuarter() { return quarter; }
	public void setQuarter(Integer quarter) { 
		this.quarter = quarter; 
	}
}
