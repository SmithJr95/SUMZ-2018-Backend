package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigure;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigureNames;
import edu.dhbw.ka.mwi.businesshorizon2.validators.IsContinuousTimeSeries;
import edu.dhbw.ka.mwi.businesshorizon2.validators.IsDateFormatConsistent;
import edu.dhbw.ka.mwi.businesshorizon2.validators.IsValidAccountingFigureCombination;
import edu.dhbw.ka.mwi.businesshorizon2.validators.IsValidTimeSeriesRanges;

@IsValidAccountingFigureCombination()
@IsDateFormatConsistent()
@IsContinuousTimeSeries()
@IsValidTimeSeriesRanges()
public class ScenarioPostRequestDto {
	
	@NotNull(message = "scenarioName must not be null.")
	@Size(min=1, max=20, message="scenarioName must consist of 1-20 characters.")
	private String scenarioName;
	
	@NotNull(message = "scenarioDescription must not be null.")
	@Size(min=1, max=100, message="scenarioDescription must consist of 1-100 characters.")
	private String scenarioDescription;
	
	@NotNull(message = "periods must not be null.")
	@Min(value=1, message="periods must be >=1 and <=10.")
	@Max(value=10, message="periods must be >=1 and <=10.")
	private Integer periods;
	
	@NotNull(message = "businessTaxRate must not be null.")
	@DecimalMin(value="0.0", message="businessTaxRate must be >=0 and <=100.")
	@DecimalMax(value="100.0", message="businessTaxRate must be >= 0 and <=100.")
	private Double businessTaxRate;
	
	@NotNull(message = "corporateTaxRate must not be null.")
	@DecimalMin(value="0.0", message="corporateTaxRate must be >=0 and <=100.")
	@DecimalMax(value="100.0", message="corporateTaxRate must be >=0 and <=100.")
	private Double corporateTaxRate;
	
	@NotNull(message = "solidaryTaxRate must not be null.")
	@DecimalMin(value="0.0", message="solidaryTaxRate must be >=0 and <=100.")
	@DecimalMax(value="100.0", message="solidaryTaxRate must be >=0 and <=100.")
	private Double solidaryTaxRate;
	
	@NotNull(message = "costOfEquity must not be null.")
	@DecimalMin(value="0.0", message="costOfEquity must be >=0 and <=1000.")
	@DecimalMax(value="1000.0", message="costOfEquity must be >=0 and <=1000.")
	private Double costOfEquity;
	
	@NotNull(message = "interestOnLiabilitiesRate must not be null.")
	private Double interestOnLiabilitiesRate;
	
	@Valid
	private MultiPeriodAccountingFigure depreciation;
	
	@Valid
	private MultiPeriodAccountingFigure additionalIncome;
	
	@Valid
	private MultiPeriodAccountingFigure additionalCosts;
	
	@Valid
	private MultiPeriodAccountingFigure investments;
	
	@Valid
	private MultiPeriodAccountingFigure divestments;
	
	@Valid
	private MultiPeriodAccountingFigure revenue;
	
	@Valid
	private MultiPeriodAccountingFigure costOfMaterial;
	
	@Valid
	private MultiPeriodAccountingFigure costOfStaff;
	
	@Valid
	private MultiPeriodAccountingFigure liabilities;
	
	@Valid
	private MultiPeriodAccountingFigure freeCashFlows;
	
	public String getScenarioName() { return scenarioName; }
	public void setScenarioName(String name) { this.scenarioName = name; }
	
	public String getScenarioDescription() { return scenarioDescription; }
	public void setScenarioDescription(String description) { this.scenarioDescription = description; }
	
	public Integer getPeriods() { return periods; }
	public void setPeriods(Integer periods) { this.periods = periods; }
	
	public Double getBusinessTaxRate() { return businessTaxRate; }
	public void setBusinessTaxRate(Double businessTaxRate) { this.businessTaxRate = businessTaxRate; }
	
	public Double getCorporateTaxRate() { return corporateTaxRate; }
	public void setCorporateTaxRate(Double corporateTaxRate) { this.corporateTaxRate = corporateTaxRate; }
	
	public Double getSolidaryTaxRate() { return solidaryTaxRate; }
	public void setSolidaryTaxRate(Double solidaryTaxRate) { this.solidaryTaxRate = solidaryTaxRate; }
	
	public Double getCostOfEquity() { return costOfEquity; }
	public void setCostOfEquity(Double costOfEquity) { this.costOfEquity = costOfEquity; }
	
	public MultiPeriodAccountingFigure getRevenue() { return revenue; }
	public void setRevenue(MultiPeriodAccountingFigure revenue) {
		this.revenue = revenue; 
		this.revenue.setFigureName(MultiPeriodAccountingFigureNames.Revenue);
	}
	
	public MultiPeriodAccountingFigure getAdditionalIncome() { return additionalIncome; }
	public void setAdditionalIncome(MultiPeriodAccountingFigure additionalIncome) { 
		this.additionalIncome = additionalIncome; 
		this.additionalIncome.setFigureName(MultiPeriodAccountingFigureNames.AdditionalIncome);
	}
	
	public MultiPeriodAccountingFigure getCostOfMaterial() { return costOfMaterial; }
	public void setCostOfMaterial(MultiPeriodAccountingFigure costOfMaterial) { 
		this.costOfMaterial = costOfMaterial; 
		this.costOfMaterial.setFigureName(MultiPeriodAccountingFigureNames.CostOfMaterial);
	}
	
	public MultiPeriodAccountingFigure getCostOfStaff() { return costOfStaff; }
	public void setCostOfStaff(MultiPeriodAccountingFigure costOfStaff) { 
		this.costOfStaff = costOfStaff; 
		this.costOfStaff.setFigureName(MultiPeriodAccountingFigureNames.CostOfStaff);
	}
	
	public MultiPeriodAccountingFigure getAdditionalCosts() { return additionalCosts; }
	public void setAdditionalCosts(MultiPeriodAccountingFigure additionalCosts) { 
		this.additionalCosts = additionalCosts; 
		this.additionalCosts.setFigureName(MultiPeriodAccountingFigureNames.AdditionalCosts);
	}
	
	public MultiPeriodAccountingFigure getInterestOnLiabilities() { return interestOnLiabilities; }
	public void setInterestOnLiabilities(MultiPeriodAccountingFigure interestOnLiabilites) { 
		this.interestOnLiabilities = interestOnLiabilites; 
		this.interestOnLiabilities.setFigureName(MultiPeriodAccountingFigureNames.InterestOnLiabilities);
	}
	
	public MultiPeriodAccountingFigure getInvestments() { return investments; }
	public void setInvestments(MultiPeriodAccountingFigure investments) { 
		this.investments = investments; 
		this.investments.setFigureName(MultiPeriodAccountingFigureNames.Investments);
	}
	
	public MultiPeriodAccountingFigure getDivestments() { return divestments; }
	public void setDivestments(MultiPeriodAccountingFigure divestments) { 
		this.divestments = divestments; 
		this.divestments.setFigureName(MultiPeriodAccountingFigureNames.Divestments);
	}
	
	public MultiPeriodAccountingFigure getLiabilities() { return liabilities; }
	public void setLiabilities(MultiPeriodAccountingFigure liabilities) { 
		this.liabilities = liabilities; 
		this.liabilities.setFigureName(MultiPeriodAccountingFigureNames.Liabilities);
	}
	
	public MultiPeriodAccountingFigure getFreeCashFlows() { return freeCashFlows; }
	public void setFreeCashFlows(MultiPeriodAccountingFigure freeCashFlows) { 
		this.freeCashFlows = freeCashFlows; 
		this.freeCashFlows.setFigureName(MultiPeriodAccountingFigureNames.FreeCashFlows);
	}
	
	public MultiPeriodAccountingFigure getDepreciation() { return depreciation; }
	public void setDepreciation(MultiPeriodAccountingFigure depreciation) { 
		this.depreciation = depreciation; 
		this.depreciation.setFigureName(MultiPeriodAccountingFigureNames.Depreciation);
	} 
	
	public List<MultiPeriodAccountingFigure> getAllMultiPeriodAccountingFigures(){
		List<MultiPeriodAccountingFigure> multiPeriodAccountingFigures = new ArrayList<MultiPeriodAccountingFigure>();
		
		multiPeriodAccountingFigures.add(this.interestOnLiabilities);
		multiPeriodAccountingFigures.add(this.depreciation);
		multiPeriodAccountingFigures.add(this.additionalIncome);
		multiPeriodAccountingFigures.add(this.additionalCosts);
		multiPeriodAccountingFigures.add(this.investments);
		multiPeriodAccountingFigures.add(this.divestments);
		multiPeriodAccountingFigures.add(this.revenue);
		multiPeriodAccountingFigures.add(this.costOfMaterial);
		multiPeriodAccountingFigures.add(this.costOfStaff);
		multiPeriodAccountingFigures.add(this.liabilities);
		multiPeriodAccountingFigures.add(this.freeCashFlows);
		
		return multiPeriodAccountingFigures;
	}
		
	@Override
	public String toString() {
		
		String newLine = System.getProperty("line.separator");

		StringBuilder sb = new StringBuilder();
		
		sb.append("------------------------------------------------------------------------");
		sb.append(newLine);
		sb.append("Name: ");
		sb.append(this.scenarioName);
		sb.append(", ");
		sb.append(newLine);
		sb.append("Description: ");
		sb.append(this.scenarioDescription);
		sb.append(", ");
		sb.append(newLine);
		sb.append("Periods: ");
		sb.append(this.periods);
		sb.append(", ");
		sb.append(newLine);
		sb.append("Business Tax: ");
		sb.append(this.businessTaxRate);
		sb.append(", ");
		sb.append(newLine);
		sb.append("Corporate Tax: ");
		sb.append(this.corporateTaxRate);
		sb.append(", ");
		sb.append(newLine);
		sb.append("Solidary Tax: ");
		sb.append(this.solidaryTaxRate);
		sb.append(", ");
		sb.append(newLine);
		sb.append("Cost Of Equity: ");
		sb.append(this.costOfEquity);
		sb.append(", ");
		sb.append(newLine);
		sb.append("Interest On Liabilites: ");
		sb.append(this.interestOnLiabilities != null ? this.interestOnLiabilities : "");
		sb.append(", ");
		sb.append(newLine);
		sb.append("Additional Income: ");
		sb.append(newLine);
		sb.append(this.additionalIncome != null ? this.additionalIncome : "");
		sb.append(", ");
		sb.append(newLine);
		sb.append("Depreciation: ");
		sb.append(newLine);
		sb.append(this.depreciation != null ? this.depreciation : "");
		sb.append(", ");
		sb.append(newLine);
		sb.append("Additional Costs: ");
		sb.append(newLine);
		sb.append(this.additionalCosts != null ? this.additionalCosts : "");
		sb.append(", ");
		sb.append(newLine);
		sb.append("Investments: ");
		sb.append(newLine);
		sb.append(this.investments != null ? this.investments : "");
		sb.append(", ");
		sb.append(newLine);
		sb.append("Divestments: ");
		sb.append(newLine);
		sb.append(this.divestments != null ? this.divestments : "");
		sb.append(", ");
		sb.append(newLine);
		sb.append("Revenue: ");
		sb.append(newLine);
		sb.append(this.revenue != null ? this.revenue : "");
		sb.append(", ");
		sb.append(newLine);
		sb.append("Cost Of Material: ");
		sb.append(newLine);
		sb.append(this.costOfMaterial != null ? this.costOfMaterial : "");
		sb.append(", ");
		sb.append(newLine);
		sb.append("Cost Of Staff: ");
		sb.append(newLine);
		sb.append(this.costOfStaff != null ? this.costOfStaff : "");
		sb.append(", ");
		sb.append(newLine);
		sb.append("Liabilites: ");
		sb.append(newLine);
		sb.append(this.liabilities != null ? this.liabilities : "");
		sb.append(", ");
		sb.append(newLine);
		sb.append("Free Cash Flows:  ");
		sb.append(newLine);
		sb.append(this.freeCashFlows != null ? this.freeCashFlows : "");
		sb.append(newLine);
		sb.append("------------------------------------------------------------------------");
		
		return sb.toString();
	}
}
