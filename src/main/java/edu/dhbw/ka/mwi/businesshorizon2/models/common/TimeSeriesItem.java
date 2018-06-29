package edu.dhbw.ka.mwi.businesshorizon2.models.common;

import javax.validation.constraints.NotNull;

public class TimeSeriesItem{
	
	@NotNull(message="date must not be null.")
	private TimeSeriesItemDate date;
	
	@NotNull(message="amount must not be null.")
	private Double amount;
	
	public TimeSeriesItem() {
	}
	
	public TimeSeriesItem(TimeSeriesItemDate date, Double amount) {
		this.date = date;
		this.amount = amount;
	}
	
	public Double getAmount() { return amount; }
	public void setAmount(Double amount) { this.amount = amount; }
	
	public TimeSeriesItemDate getDate() { return date; }
	public void setDate(TimeSeriesItemDate date) { this.date = date; }
	
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
