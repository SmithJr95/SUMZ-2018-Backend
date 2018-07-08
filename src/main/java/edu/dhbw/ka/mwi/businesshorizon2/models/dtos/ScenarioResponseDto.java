package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;


public class ScenarioResponseDto {
	
	private Long id;
	private Boolean stochastic;
	private String scenarioName;
	private String scenarioDescription;
	private Integer periods;

	private Double businessTaxRate;
	private Double corporateTaxRate;
	private Double solidaryTaxRate;
	private Double equityInterestRate;
	private Double interestOnLiabilitiesRate;
	
	private MultiPeriodAccountingFigureResponseDto depreciation;
	private MultiPeriodAccountingFigureResponseDto additionalIncome;
	private MultiPeriodAccountingFigureResponseDto additionalCosts;
	private MultiPeriodAccountingFigureResponseDto investments;
	private MultiPeriodAccountingFigureResponseDto divestments;
	private MultiPeriodAccountingFigureResponseDto revenue;
	private MultiPeriodAccountingFigureResponseDto costOfMaterial;
	private MultiPeriodAccountingFigureResponseDto costOfStaff;
	private MultiPeriodAccountingFigureResponseDto liabilities;
	private MultiPeriodAccountingFigureResponseDto freeCashFlows;
	
	private CompanyValueDistributionDto companyValueDistribution;
	private ApvCompanyValuationResultDto apvValuationResult;
	private FteCompanyValuationResultDto fteValuationResult;
	private FcfCompanyValuationResultDto fcfValuationResult;
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; } 
	
	public Boolean getStochastic() { return stochastic; }
	public void setStochastic(Boolean stochastic) { this.stochastic = stochastic; }
	
	public String getScenarioName() { return scenarioName; }
	public void setScenarioName(String scenarioName) { this.scenarioName = scenarioName; }
	
	public String getScenarioDescription() { return scenarioDescription; }
	public void setScenarioDescription(String scenarioDescription) { this.scenarioDescription = scenarioDescription; }
	
	public Integer getPeriods() { return periods; }
	public void setPeriods(Integer periods) { this.periods = periods; }
	
	public Double getBusinessTaxRate() { return businessTaxRate; }
	public void setBusinessTaxRate(Double businessTaxRate) { this.businessTaxRate = businessTaxRate; }
	
	public Double getCorporateTaxRate() { return corporateTaxRate; }
	public void setCorporateTaxRate(Double corporateTaxRate) { this.corporateTaxRate = corporateTaxRate; }
	
	public Double getSolidaryTaxRate() { return solidaryTaxRate; }
	public void setSolidaryTaxRate(Double solidaryTaxRate) { this.solidaryTaxRate = solidaryTaxRate; }
	
	public Double getEquityInterestRate() { return equityInterestRate; }
	public void setEquityInterestRate(Double equityInterestRate) { this.equityInterestRate = equityInterestRate; }
	
	public MultiPeriodAccountingFigureResponseDto getRevenue() { return revenue; }
	public void setRevenue(MultiPeriodAccountingFigureResponseDto revenue) { this.revenue = revenue;  }
	
	public MultiPeriodAccountingFigureResponseDto getAdditionalIncome() { return additionalIncome; }
	public void setAdditionalIncome(MultiPeriodAccountingFigureResponseDto additionalIncome) { this.additionalIncome = additionalIncome; }
	
	public MultiPeriodAccountingFigureResponseDto getCostOfMaterial() { return costOfMaterial; }
	public void setCostOfMaterial(MultiPeriodAccountingFigureResponseDto costOfMaterial) { this.costOfMaterial = costOfMaterial; }
	
	public MultiPeriodAccountingFigureResponseDto getCostOfStaff() { return costOfStaff; }
	public void setCostOfStaff(MultiPeriodAccountingFigureResponseDto costOfStaff) { this.costOfStaff = costOfStaff; }
	
	public MultiPeriodAccountingFigureResponseDto getAdditionalCosts() { return additionalCosts; }
	public void setAdditionalCosts(MultiPeriodAccountingFigureResponseDto additionalCosts) { this.additionalCosts = additionalCosts; }
	
	public Double getInterestOnLiabilitiesRate() { return interestOnLiabilitiesRate; }
	public void setInterestOnLiabilitiesRate(Double interestOnLiabilitiesRate) { this.interestOnLiabilitiesRate = interestOnLiabilitiesRate; }
	
	public MultiPeriodAccountingFigureResponseDto getInvestments() { return investments; }
	public void setInvestments(MultiPeriodAccountingFigureResponseDto investments) { this.investments = investments; }
	
	public MultiPeriodAccountingFigureResponseDto getDivestments() { return divestments; }
	public void setDivestments(MultiPeriodAccountingFigureResponseDto divestments) { this.divestments = divestments; }
	
	public MultiPeriodAccountingFigureResponseDto getLiabilities() { return liabilities; }
	public void setLiabilities(MultiPeriodAccountingFigureResponseDto liabilities) { this.liabilities = liabilities; }
	
	public MultiPeriodAccountingFigureResponseDto getFreeCashFlows() { return freeCashFlows; }
	public void setFreeCashFlows(MultiPeriodAccountingFigureResponseDto freeCashFlows) { this.freeCashFlows = freeCashFlows; }
	
	public MultiPeriodAccountingFigureResponseDto getDepreciation() { return depreciation; }
	public void setDepreciation(MultiPeriodAccountingFigureResponseDto depreciation) { this.depreciation = depreciation; }
	
	public CompanyValueDistributionDto getCompanyValueDistribution() { return companyValueDistribution; }
	public void setCompanyValueDistribution(CompanyValueDistributionDto companyValueDistribution) { this.companyValueDistribution = companyValueDistribution; }
	
	public ApvCompanyValuationResultDto getApvValuationResult() { return apvValuationResult; }
	public void setApvValuationResult(ApvCompanyValuationResultDto apvValuationResult) { this.apvValuationResult = apvValuationResult; }
	
	public FteCompanyValuationResultDto getFteValuationResult() { return fteValuationResult; }
	public void setFteValuationResult(FteCompanyValuationResultDto fteValuationResult) { this.fteValuationResult = fteValuationResult; }
	
	public FcfCompanyValuationResultDto getFcfValuationResult() { return fcfValuationResult; }
	public void setFcfValuationResult(FcfCompanyValuationResultDto fcfValuationResult) { this.fcfValuationResult = fcfValuationResult; }
}
