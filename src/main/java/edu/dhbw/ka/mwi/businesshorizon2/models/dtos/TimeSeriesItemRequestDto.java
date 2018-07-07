package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

import javax.validation.constraints.NotNull;

public class TimeSeriesItemRequestDto{
	
	@NotNull(message="date must not be null.")
	private TimeSeriesItemDateRequestDto date;
	
	@NotNull(message="amount must not be null.")
	private Double amount;
	
	public TimeSeriesItemRequestDto() {
	}
	
	public TimeSeriesItemRequestDto(TimeSeriesItemDateRequestDto date, Double amount) {
		this.date = date;
		this.amount = amount;
	}
	
	public Double getAmount() { return amount; }
	public void setAmount(Double amount) { this.amount = amount; }
	
	public TimeSeriesItemDateRequestDto getDate() { return date; }
	public void setDate(TimeSeriesItemDateRequestDto date) { this.date = date; }
	
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
