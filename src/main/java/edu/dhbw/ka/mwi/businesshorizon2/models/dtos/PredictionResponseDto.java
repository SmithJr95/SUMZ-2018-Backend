package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

import java.util.ArrayList;
import java.util.List;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.PredictionResponseTimeSeries;

public class PredictionResponseDto {
	private List<PredictionResponseTimeSeries> timeSeries = new ArrayList<PredictionResponseTimeSeries>();

	public List<PredictionResponseTimeSeries> getTimeSeries() { return timeSeries; }
	public void setTimeSeries(List<PredictionResponseTimeSeries> timeSeries) { this.timeSeries = timeSeries; }
	
	@Override
	public String toString() {
		
		String newLine = System.getProperty("line.separator");
		
		StringBuilder sb = new StringBuilder();
		if(this.timeSeries != null) {
			for (PredictionResponseTimeSeries ts : this.timeSeries) {
				if(ts != null) {
					sb.append(ts);
					sb.append(newLine);
				}
			}	
		}
				
		return sb.toString();
	}
}
