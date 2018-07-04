package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

public class FteCompanyValuationResultDto {
	private Double companyValue;
	
	public FteCompanyValuationResultDto() {}
	
	public FteCompanyValuationResultDto(Double companyValue) {
		this.companyValue = companyValue;
	}

	public Double getCompanyValue() { return companyValue; }
	public void setCompanyValue(Double companyValue) { this.companyValue = companyValue; }
}
