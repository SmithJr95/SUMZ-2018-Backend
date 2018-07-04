package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.TimeSeriesItemDateFormats;

public class TimeSeriesItemDateDto implements Comparable<TimeSeriesItemDateDto> {
	
	@NotNull(message="year must not be null.")
	@DecimalMin(value="1900", message="year must be >=1900 and <=2100.")
	@DecimalMax(value="2100", message="year must be >=1900 and <=2100.")
	private Integer year;
	
	@Min(value=1, message="quarter must be an element of the set {1, 2, 3, 4}.")
	@Max(value=4, message="quarter must be an element of the set {1, 2, 3, 4}.")
	private Integer quarter;
	
	private TimeSeriesItemDateFormats dateFormat;
	
	public TimeSeriesItemDateDto() {
		this.updateDateFormat();
	}
	
	public TimeSeriesItemDateDto(Integer year) {
		this.year = year;
		this.updateDateFormat();
	}
	
	public TimeSeriesItemDateDto(Integer year, Integer quarter) {
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
		
	public TimeSeriesItemDateDto getNextDate(){
		TimeSeriesItemDateDto nextDate = new TimeSeriesItemDateDto();
		
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
	
	public TimeSeriesItemDateDto getPrevDate(){
		TimeSeriesItemDateDto prevDate = new TimeSeriesItemDateDto();
		
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
		
		if(!(o instanceof TimeSeriesItemDateDto)) {
			return false;
		}

		TimeSeriesItemDateDto other = (TimeSeriesItemDateDto) o;
		
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
	
	public boolean dateFormatsEqual(TimeSeriesItemDateDto other) {
		if (other == null) {
			throw new UnsupportedOperationException();
		}
		
		return this.dateFormat == other.dateFormat;
	}
	
	@Override
	public int compareTo(TimeSeriesItemDateDto o) {
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
