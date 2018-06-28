package edu.dhbw.ka.mwi.businesshorizon2.models.common;

public class TimeSeriesItemDate implements Comparable<TimeSeriesItemDate> {
	
	private Integer year;
	private Integer quarter;
	
	public Integer getYear() { return year; }
	public void setYear(Integer year) { this.year = year; }
	public Integer getQuarter() { return quarter; }
	public void setQuarter(Integer quarter) { this.quarter = quarter; }
	
	public TimeSeriesItemDate getNextDate(){
		if(this.year == null && this.quarter == null) {
			return new TimeSeriesItemDate();
		}
		if(this.year == null) {
			throw new UnsupportedOperationException();
		}
		if(this.quarter != null) {
			TimeSeriesItemDate nextDate = new TimeSeriesItemDate();
			if(nextDate.getQuarter() == 4) {
				nextDate.setYear(this.yea);
			}
			nextDate.setYear(year);
		}
	}
	
	public TimeSeriesItemDate getPrevDate(){
		throw new UnsupportedOperationException();
	}
	
	public boolean datesEqual(TimeSeriesItemDate other) {
		throw new UnsupportedOperationException();
	}
	
	public boolean dateFormatsEqual(TimeSeriesItemDate other) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public int compareTo(TimeSeriesItemDate o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
