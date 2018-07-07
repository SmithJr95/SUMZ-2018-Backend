package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.TimeSeriesItemDateFormats;

public class TimeSeriesItemDateRequestDto implements Comparable<TimeSeriesItemDateRequestDto> {
	
	@NotNull(message="year must not be null.")
	@DecimalMin(value="1900", message="year must be >=1900 and <=2100.")
	@DecimalMax(value="2100", message="year must be >=1900 and <=2100.")
	private Integer year;
	
	@Min(value=1, message="quarter must be an element of the set {1, 2, 3, 4}.")
	@Max(value=4, message="quarter must be an element of the set {1, 2, 3, 4}.")
	private Integer quarter;
	
	private TimeSeriesItemDateFormats dateFormat;
	
	public TimeSeriesItemDateRequestDto() {
		this.updateDateFormat();
	}
	
	public TimeSeriesItemDateRequestDto(Integer year) {
		this.year = year;
		this.updateDateFormat();
	}
	
	public TimeSeriesItemDateRequestDto(Integer year, Integer quarter) {
		this.year = year;
		this.quarter = quarter;
		this.updateDateFormat();
	}
		
	public Integer getYear() { return year; }
	public void setYear(Integer year) { 
		this.year = year;
		this.updateDateFormat();
	}
	
	public Integer getQuarter() { return quarter; }
	public void setQuarter(Integer quarter) { 
		this.quarter = quarter; 
		this.updateDateFormat();
	}
	
	public TimeSeriesItemDateFormats getDateFormat() { return dateFormat; }
		
	public TimeSeriesItemDateRequestDto getNextDate(){
		TimeSeriesItemDateRequestDto nextDate = new TimeSeriesItemDateRequestDto();
		
		if (this.dateFormat == TimeSeriesItemDateFormats.Year) {
			nextDate.setYear(this.year + 1);
		}
		else if (this.dateFormat == TimeSeriesItemDateFormats.YearQuarter) {
			if(this.quarter == 4) {
				nextDate.setYear(this.year + 1);
				nextDate.setQuarter(1);
			}
			else {
				nextDate.setYear(this.year);
				nextDate.setQuarter(this.quarter + 1);
			}
		}
		else {
			throw new UnsupportedOperationException();
		}
		
		return nextDate;
	}
	
	public TimeSeriesItemDateRequestDto getPrevDate(){
		TimeSeriesItemDateRequestDto prevDate = new TimeSeriesItemDateRequestDto();
		
		if (this.dateFormat == TimeSeriesItemDateFormats.Year) {
			prevDate.setYear(this.year - 1);
		}
		else if (this.dateFormat == TimeSeriesItemDateFormats.YearQuarter) {
			if(this.quarter == 1) {
				prevDate.setYear(this.year - 1);
				prevDate.setQuarter(4);
			}
			else {
				prevDate.setYear(this.year);
				prevDate.setQuarter(this.quarter - 1);
			}
		}
		else {
			throw new UnsupportedOperationException();
		}
		
		return prevDate;
	}
	
	@Override
    public boolean equals(Object o) {
		if(o == this) {
			return true;
		}
		
		if(!(o instanceof TimeSeriesItemDateRequestDto)) {
			return false;
		}

		TimeSeriesItemDateRequestDto other = (TimeSeriesItemDateRequestDto) o;
		
		if(!this.dateFormatsEqual(other)) {
			return false;
		}	
		else if (this.year == null && this.quarter == null) {
			return other.year == null && other.quarter == null;
		}
		else if (this.year == null && this.quarter != null) {
			return other.year == null && this.quarter.equals(other.quarter);
		}
		else if (this.year != null && this.quarter == null) {
			return this.year.equals(other.year) && other.quarter == null;
		}
		else {
			return this.year.equals(other.year) &&  this.quarter.equals(other.quarter);
		}
	}
	
	public boolean dateFormatsEqual(TimeSeriesItemDateRequestDto other) {
		if (other == null) {
			throw new UnsupportedOperationException();
		}
		
		return this.dateFormat == other.dateFormat;
	}
	
	@Override
	public int compareTo(TimeSeriesItemDateRequestDto o) {
		if (!this.dateFormatsEqual(o) || this.dateFormat == TimeSeriesItemDateFormats.Invalid || o.dateFormat == TimeSeriesItemDateFormats.Invalid) {
			throw new UnsupportedOperationException();
		}
		
		if(this.dateFormat == TimeSeriesItemDateFormats.Year) {
			return Integer.compare(this.year, o.year);
		}
		else if (this.dateFormat == TimeSeriesItemDateFormats.YearQuarter) {
			if(Integer.compare(this.year, o.year) != 0) {
				return Integer.compare(this.year, o.year);
			}
			else {
				return Integer.compare(this.quarter, o.quarter);
			}
		}
		else {
			throw new UnsupportedOperationException();
		}
	}
	
	private void updateDateFormat() {
		if(this.year == null) {
			this.dateFormat = TimeSeriesItemDateFormats.Invalid;
		}
		else if(this.quarter == null) {
			this.dateFormat = TimeSeriesItemDateFormats.Year;
		}
		else {
			this.dateFormat = TimeSeriesItemDateFormats.YearQuarter;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Year: ");
		sb.append(this.year != null ? this.year : "");
		sb.append("\t");
		sb.append("Quarter: ");
		sb.append(this.quarter != null ? this.quarter : "");
		
		return sb.toString();
	}
}
