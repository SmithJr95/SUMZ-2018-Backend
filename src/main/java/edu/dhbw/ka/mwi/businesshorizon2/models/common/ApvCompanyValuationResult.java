package edu.dhbw.ka.mwi.businesshorizon2.models.common;

public class ApvCompanyValuationResult {
	private double companyValue;
	private double marketValueTotalAssets;
	private double totalLiabilities;
	private double marketValueEquity;
	private double taxShield;
	
	public ApvCompanyValuationResult(double companyValue, double marketValueTotalAssets, double totalLiabilities, double marketValueEquity, double taxShield) {
		this.companyValue = companyValue;
		this.marketValueTotalAssets = marketValueTotalAssets;
		this.totalLiabilities = totalLiabilities;
		this.marketValueEquity = marketValueEquity;
		this.taxShield = taxShield;
	}
	
	public double getCompanyValue() { return companyValue; }
	public void setCompanyValue(double companyValue) { this.companyValue = companyValue; }
	public double getMarketValueTotalAssets() { return marketValueTotalAssets; }
	public void setMarketValueTotalAssets(double marketValueTotalAssets) { this.marketValueTotalAssets = marketValueTotalAssets; }
	public double getMarketValueEquity() { return marketValueEquity; }
	public void setMarketValueEquity(double marketValueEquity) { this.marketValueEquity = marketValueEquity; }
	public double getTotalLiabilities() { return totalLiabilities; }
	public void setTotalLiabilities(double totalLiabilities) { this.totalLiabilities = totalLiabilities; }
	public double getTaxShield() { return taxShield; }
	public void setTaxShield(double taxShield) { this.taxShield = taxShield; }
}
