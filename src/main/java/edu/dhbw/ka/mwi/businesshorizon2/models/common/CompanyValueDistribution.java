package edu.dhbw.ka.mwi.businesshorizon2.models.common;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CompanyValueDistribution {
	
	@NotNull
	@Size(min=31, max=31, message="xValues must have be of length 31.")
	private List<Double> xValues;
	
	@NotNull
	@Size(min=31, max=31, message="yValues must have be of length 31.")
	private List<Double> yValues;
	
	public CompanyValueDistribution() {}
	
	public CompanyValueDistribution(List<Double> xValues, List<Double> yValues) {
		this.xValues = xValues;
		this.yValues = yValues;
	}
	
	public List<Double> getxValues() { return xValues; }
	public void setxValues(List<Double> xValues) { this.xValues = xValues; }
	
	public List<Double> getyValues() { return yValues; }
	public void setyValues(List<Double> yValues) { this.yValues = yValues; }
}
