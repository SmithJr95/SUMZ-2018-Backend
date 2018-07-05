package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

public class FcfCompanyValuationResultDto {
	private double companyValue;
	private double marketValueTotalAssets;
	private double totalLiabilities;
	
	public FcfCompanyValuationResultDto(double companyValue, double marketValueTotalAssets, double totalLiabilities) {
		this.companyValue = companyValue;
		this.marketValueTotalAssets = marketValueTotalAssets;
		this.totalLiabilities = totalLiabilities;
	}
	
	public double getCompanyValue() { return companyValue; }
	public void setCompanyValue(double companyValue) { this.companyValue = companyValue; }
	
	public double getMarketValueTotalAssets() { return marketValueTotalAssets; }
	public void setMarketValueTotalAssets(double marketValueTotalAssets) { this.marketValueTotalAssets = marketValueTotalAssets; }
	
	public double getTotalLiabilities() { return totalLiabilities; }
	public void setTotalLiabilities(double totalLiabilities) { this.totalLiabilities = totalLiabilities; }
}
