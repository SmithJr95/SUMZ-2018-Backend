package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

import java.util.List;

public class CompanyValueDistributionDto {
	
	private List<Double> xValues;
	private List<Double> yValues;
	
	public CompanyValueDistributionDto() {}
	
	public CompanyValueDistributionDto(List<Double> xValues, List<Double> yValues) {
		this.xValues = xValues;
		this.yValues = yValues;
	}
	
	public List<Double> getxValues() { return xValues; }
	public void setxValues(List<Double> xValues) { this.xValues = xValues; }
	
	public List<Double> getyValues() { return yValues; }
	public void setyValues(List<Double> yValues) { this.yValues = yValues; }
}
