package edu.dhbw.ka.mwi.businesshorizon2.models.common;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class MultiPeriodAccountingFigure {
	
	@NotNull(message="isHistoric must not be null.")
	private Boolean isHistoric;
	
	@NotNull(message="timeSeries must not be null.")
	@Valid
	private TimeSeriesItem[] timeSeries;
	
	private MultiPeriodAccountingFigureNames figureName;
	
	public Boolean getIsHistoric() { return isHistoric; }
	public void setIsHistoric(Boolean isHistoric) { this.isHistoric = isHistoric; }

	public TimeSeriesItem[] getTimeSeries() { return timeSeries; }
	public void setTimeSeries(TimeSeriesItem[] timeSeries) { this.timeSeries = timeSeries; }
	
	public MultiPeriodAccountingFigureNames getFigureName() { return figureName; }
	public void setFigureName(MultiPeriodAccountingFigureNames figureName) {this.figureName = figureName; }
	
	@Override
	public String toString() { 
		String newLine = System.getProperty("line.separator");
		
		StringBuilder sb = new StringBuilder();
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
				
		for(int i = 0; i < this.timeSeries.length - 1; i++) {
			sb.append("\t\t");
			sb.append(this.timeSeries[i].toString());
			sb.append(newLine);
		}
		
		sb.append("\t\t");
		sb.append(this.timeSeries[this.timeSeries.length - 1]);
		sb.append(newLine);
		sb.append("\t");
		sb.append("]");

		return sb.toString();
	}
}
