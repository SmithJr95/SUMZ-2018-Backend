package edu.dhbw.ka.mwi.businesshorizon2.models.common;

public class FteCompanyValuationResult {
	private double companyValue;
	
	public FteCompanyValuationResult(double companyValue) {
		this.companyValue = companyValue;
	}

	public double getCompanyValue() { return companyValue; }
	public void setCompanyValue(double companyValue) { this.companyValue = companyValue; }
}
