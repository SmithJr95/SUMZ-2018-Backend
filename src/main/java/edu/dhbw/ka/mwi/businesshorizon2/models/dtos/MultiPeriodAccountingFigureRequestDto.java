package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import edu.dhbw.ka.mwi.businesshorizon2.comparators.TimeSeriesItemByDateComparator;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigureNames;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.TimeSeriesItemDateFormats;
import io.swagger.annotations.ApiModelProperty;

public class MultiPeriodAccountingFigureRequestDto {

	@NotNull(message="isHistoric must not be null.")
	@ApiModelProperty()
	private Boolean isHistoric;

	@NotNull(message="timeSeries must not be null.")
	@Valid
	@ApiModelProperty()
	private List<TimeSeriesItemDto> timeSeries;

	@ApiModelProperty()
	private MultiPeriodAccountingFigureNames figureName;
	
	public MultiPeriodAccountingFigureRequestDto() {}
	
	public MultiPeriodAccountingFigureRequestDto(MultiPeriodAccountingFigureNames figureName, Boolean isHistoric, List<TimeSeriesItemDto> timeSeries) {
		this.figureName = figureName;
		this.isHistoric = isHistoric;
		this.timeSeries = timeSeries;
	}
	
	public Boolean getIsHistoric() { return isHistoric; }
	public void setIsHistoric(Boolean isHistoric) { this.isHistoric = isHistoric; }

	public List<TimeSeriesItemDto> getTimeSeries() { return timeSeries; }
	public void setTimeSeries(List<TimeSeriesItemDto> timeSeries) { this.timeSeries = timeSeries; }
	
	public MultiPeriodAccountingFigureNames getFigureName() { return figureName; }
	public void setFigureName(MultiPeriodAccountingFigureNames figureName) {this.figureName = figureName; }
	
	public TimeSeriesItemDateDto getMaxDate() {
		if (this.timeSeries == null || this.timeSeries.isEmpty()){
			return null;
		}
		
		List<TimeSeriesItemDateDto> dates = new ArrayList<TimeSeriesItemDateDto>();
		for (TimeSeriesItemDto item : this.timeSeries) {
			if(item.getDate() != null && item.getDate().getDateFormat() != TimeSeriesItemDateFormats.Invalid) {
				dates.add(item.getDate());
			}
		}
		
		if(dates.isEmpty()) {
			return null;
		}
		
		return Collections.max(dates);
	}
	
	public TimeSeriesItemDateDto getMinDate() {
		if (this.timeSeries == null || this.timeSeries.isEmpty()){
			return null;
		}
		
		List<TimeSeriesItemDateDto> dates = new ArrayList<TimeSeriesItemDateDto>();
		for (TimeSeriesItemDto item : this.timeSeries) {
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
		
		List<TimeSeriesItemDateDto> dates = new ArrayList<TimeSeriesItemDateDto>();
		for (int i = 0; i < this.timeSeries.size(); i++) {
			if(this.timeSeries.get(i).getDate() != null && this.timeSeries.get(i).getDate().getDateFormat() != TimeSeriesItemDateFormats.Invalid) {
				dates.add(this.timeSeries.get(i).getDate());
			}
		}
		dates.sort(null);
		
		for (int i = 0; i < dates.size() - 1; i++) {
			TimeSeriesItemDateDto expectedNext = dates.get(i).getNextDate();
			TimeSeriesItemDateDto actualNext = dates.get(i + 1);
			
			if(!expectedNext.equals(actualNext)) {
				return false;
			}
		}
		
		return true;
	}
	
	public List<Double> getTimeSeriesAmountsSortedAscByDate() {
		if(this.timeSeries == null) {
			throw new UnsupportedOperationException();
		}
		
		this.timeSeries.sort(new TimeSeriesItemByDateComparator());
		
		List<Double> amounts = new ArrayList<Double>();
		
		for (int i = 0; i < this.timeSeries.size(); i++) {
			if(this.timeSeries.get(i).getAmount() != null) {
				amounts.add(this.timeSeries.get(i).getAmount());
			}
		}
		
		return amounts;
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
