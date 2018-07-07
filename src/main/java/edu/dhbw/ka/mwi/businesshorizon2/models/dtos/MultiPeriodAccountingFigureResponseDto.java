package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

import java.util.ArrayList;
import java.util.List;

public class MultiPeriodAccountingFigureResponseDto {
	
	private Boolean isHistoric;
	private List<TimeSeriesItemResponseDto> timeSeries = new ArrayList<>();
	
	public MultiPeriodAccountingFigureResponseDto() {}
	
	public MultiPeriodAccountingFigureResponseDto(Boolean isHistoric, List<TimeSeriesItemResponseDto> timeSeries) {
		this.isHistoric = isHistoric;
		this.timeSeries = timeSeries;
	}
	
	public Boolean getIsHistoric() { return isHistoric; }
	public void setIsHistoric(Boolean isHistoric) { this.isHistoric = isHistoric; }

	public List<TimeSeriesItemResponseDto> getTimeSeries() { return timeSeries; }
	public void setTimeSeries(List<TimeSeriesItemResponseDto> timeSeries) { this.timeSeries = timeSeries; }
}
