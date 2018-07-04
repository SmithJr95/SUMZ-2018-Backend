package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

public class ApvCompanyValuationResultDto {
	private Double companyValue;
	private Double marketValueTotalAssets;
	private Double totalLiabilities;
	private Double marketValueEquity;
	private Double taxShield;
	
	public ApvCompanyValuationResultDto(Double companyValue, Double marketValueTotalAssets, Double totalLiabilities, Double marketValueEquity, Double taxShield) {
		this.companyValue = companyValue;
		this.marketValueTotalAssets = marketValueTotalAssets;
		this.totalLiabilities = totalLiabilities;
		this.marketValueEquity = marketValueEquity;
		this.taxShield = taxShield;
	}
	
	public Double getCompanyValue() { return companyValue; }
	public void setCompanyValue(Double companyValue) { this.companyValue = companyValue; }
	public Double getMarketValueTotalAssets() { return marketValueTotalAssets; }
	public void setMarketValueTotalAssets(Double marketValueTotalAssets) { this.marketValueTotalAssets = marketValueTotalAssets; }
	public Double getMarketValueEquity() { return marketValueEquity; }
	public void setMarketValueEquity(Double marketValueEquity) { this.marketValueEquity = marketValueEquity; }
	public Double getTotalLiabilities() { return totalLiabilities; }
	public void setTotalLiabilities(Double totalLiabilities) { this.totalLiabilities = totalLiabilities; }
	public Double getTaxShield() { return taxShield; }
	public void setTaxShield(Double taxShield) { this.taxShield = taxShield; }
}
