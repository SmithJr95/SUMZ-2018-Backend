package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

import java.util.ArrayList;
import java.util.List;

public class PredictionResponseDto {
	private List<PredictionResponseTimeSeriesDto> timeSeries = new ArrayList<PredictionResponseTimeSeriesDto>();

	public List<PredictionResponseTimeSeriesDto> getTimeSeries() { return timeSeries; }
	public void setTimeSeries(List<PredictionResponseTimeSeriesDto> timeSeries) { this.timeSeries = timeSeries; }
	
	@Override
	public String toString() {
		
		String newLine = System.getProperty("line.separator");
		
		StringBuilder sb = new StringBuilder();
		if(this.timeSeries != null) {
			for (PredictionResponseTimeSeriesDto ts : this.timeSeries) {
				if(ts != null) {
					sb.append(ts);
					sb.append(newLine);
				}
			}	
		}
				
		return sb.toString();
	}
}
