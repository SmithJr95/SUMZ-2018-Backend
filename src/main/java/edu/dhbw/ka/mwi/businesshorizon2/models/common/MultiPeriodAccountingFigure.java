package edu.dhbw.ka.mwi.businesshorizon2.models.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class MultiPeriodAccountingFigure {
	
	@NotNull(message="isHistoric must not be null.")
	private Boolean isHistoric;
	
	@NotNull(message="timeSeries must not be null.")
	@Valid
	private List<TimeSeriesItem> timeSeries;
	
	private MultiPeriodAccountingFigureNames figureName;
	
	public Boolean getIsHistoric() { return isHistoric; }
	public void setIsHistoric(Boolean isHistoric) { this.isHistoric = isHistoric; }

	public List<TimeSeriesItem> getTimeSeries() { return timeSeries; }
	public void setTimeSeries(List<TimeSeriesItem> timeSeries) { this.timeSeries = timeSeries; }
	
	public MultiPeriodAccountingFigureNames getFigureName() { return figureName; }
	public void setFigureName(MultiPeriodAccountingFigureNames figureName) {this.figureName = figureName; }
	
	public TimeSeriesItemDate getMaxDate() {
		if (this.timeSeries == null || this.timeSeries.isEmpty()){
			return null;
		}
		
		List<TimeSeriesItemDate> dates = new ArrayList<TimeSeriesItemDate>();
		for (TimeSeriesItem item : this.timeSeries) {
			if(item.getDate() != null && item.getDate().getDateFormat() != TimeSeriesItemDateFormats.Invalid) {
				dates.add(item.getDate());
			}
		}
		
		if(dates.isEmpty()) {
			return null;
		}
		
		return Collections.max(dates);
	}
	
	public TimeSeriesItemDate getMinDate() {
		if (this.timeSeries == null || this.timeSeries.isEmpty()){
			return null;
		}
		
		List<TimeSeriesItemDate> dates = new ArrayList<TimeSeriesItemDate>();
		for (TimeSeriesItem item : this.timeSeries) {
			if(item.getDate() != null && item.getDate().getDateFormat() != TimeSeriesItemDateFormats.Invalid) {
				dates.add(item.getDate());
			}
		}
		
		if(dates.isEmpty()) {
			return null;
		}
		
		return Collections.min(dates);
	}
	
	public boolean isTimeSeriesContinuous(){
		if(this.timeSeries == null) {
			throw new UnsupportedOperationException();
		}
		
		List<TimeSeriesItemDate> dates = new ArrayList<TimeSeriesItemDate>();
		for (int i = 0; i < this.timeSeries.size(); i++) {
			if(this.timeSeries.get(i).getDate() != null && this.timeSeries.get(i).getDate().getDateFormat() != TimeSeriesItemDateFormats.Invalid) {
				dates.add(this.timeSeries.get(i).getDate());
			}
		}
		dates.sort(null);
		
		for (int i = 0; i < dates.size() - 1; i++) {
			TimeSeriesItemDate expectedNext = dates.get(i).getNextDate();
			TimeSeriesItemDate actualNext = dates.get(i + 1);
			
			if(!expectedNext.equals(actualNext)) {
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public String toString() { 
		String newLine = System.getProperty("line.separator");
		
		StringBuilder sb = new StringBuilder();
		sb.append(newLine);
		sb.append("\tHistoric: ");
		sb.append(this.isHistoric != null ? this.isHistoric : "");
		sb.append(",");
		sb.append(newLine);
		sb.append("\tFigureName: ");
		sb.append(this.figureName);
		sb.append(",");
		sb.append(newLine);
		sb.append("\tTime Series: [");
		sb.append(newLine);
				
		for(int i = 0; i < this.timeSeries.size() - 1; i++) {
			sb.append("\t\t");
			sb.append(this.timeSeries.get(i).toString());
			sb.append(newLine);
		}
		
		sb.append("\t\t");
		sb.append(this.timeSeries.get(this.timeSeries.size()- 1));
		sb.append(newLine);
		sb.append("\t");
		sb.append("]");

		return sb.toString();
	}
}
