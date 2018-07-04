package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

import javax.validation.constraints.NotNull;

public class TimeSeriesItemDto{
	
	@NotNull(message="date must not be null.")
	private TimeSeriesItemDateDto date;
	
	@NotNull(message="amount must not be null.")
	private Double amount;
	
	public TimeSeriesItemDto() {
	}
	
	public TimeSeriesItemDto(TimeSeriesItemDateDto date, Double amount) {
		this.date = date;
		this.amount = amount;
	}
	
	public Double getAmount() { return amount; }
	public void setAmount(Double amount) { this.amount = amount; }
	
	public TimeSeriesItemDateDto getDate() { return date; }
	public void setDate(TimeSeriesItemDateDto date) { this.date = date; }
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Date: ");
		sb.append(this.date != null ? this.date : "");
		sb.append("\t");
		sb.append("Amount: ");
		sb.append(this.amount != null ? this.amount : "");
		
		return sb.toString();
	}
}
