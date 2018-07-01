package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

import java.util.List;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.PredictionRequestTimeSeries;

public class PredictionRequestDto {
	private List<PredictionRequestTimeSeries> timeSeries;
	private Integer predSteps;
	private Integer numSamples;
	
	public PredictionRequestDto() {
	}
	
	public PredictionRequestDto(List<PredictionRequestTimeSeries> timeSeries, Integer predSteps, Integer numSamples) {
		this.timeSeries = timeSeries;
		this.predSteps = predSteps;
		this.numSamples = numSamples;
	}
	
	public List<PredictionRequestTimeSeries> getTimeSeries() {
		return timeSeries;
	}
	public void setTimeSeries(List<PredictionRequestTimeSeries> timeSeries) { this.timeSeries = timeSeries; }
	
	public Integer getPredSteps() { return predSteps; }
	public void setPredSteps(Integer predSteps) { this.predSteps = predSteps; }
	
	public Integer getNumSamples() { return numSamples; }
	public void setNumSamples(Integer numSamples) { this.numSamples = numSamples; }
	
	@Override
	public String toString() {
		
		String newLine = System.getProperty("line.separator");
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("PredSteps: ");
		sb.append(this.predSteps != null ? this.predSteps : "");
		sb.append(", ");
		sb.append("NumSamples: ");
		sb.append(this.numSamples != null ? this.numSamples : "");
		sb.append(", ");
		sb.append("TimeSeries: ");
		if(this.timeSeries != null) {
			for(int i = 0; i < this.timeSeries.size(); i++) {
				sb.append(newLine);
				sb.append(this.timeSeries.get(i));
			}
		}
		
		return sb.toString();
	}
}