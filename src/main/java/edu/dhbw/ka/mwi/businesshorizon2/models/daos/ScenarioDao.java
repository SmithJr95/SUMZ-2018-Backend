package edu.dhbw.ka.mwi.businesshorizon2.models.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;

@Entity(name = "Scenario")
@Table(name = "Scenario")
public class ScenarioDao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long scenarioId;
	
	@Column(name="ScenarioName", columnDefinition = "nvarchar")
	private String scenarioName;
	
	@Column(name="ScenarioDescription", columnDefinition = "nvarchar")
	private String scenarioDescription;
	
	@Column(name="ForecastPeriods")
	private Integer forecastPeriods;
	
	@Column(name="BusinessTaxRate")
	private Double businessTaxRate;
	
	@Column(name="CorporateTaxRate")
	private Double corporateTaxRate;
	
	@Column(name="SolidaryTaxRate")
	private Double solidaryTaxRate;
	
	@Column(name="EquityInterestRate")
	private Double equityInterestRate;
	
	@Column(name="InterestOnLiabilitiesRate")
	private Double interestOnLiabilitiesRate;
	
	@OneToOne(mappedBy="scenario")
	private ApvCompanyValuationResultDao apvCompanyValuationResultDao;
	
	@OneToOne(mappedBy="scenario")
	private FteCompanyValuationResultDao fteCompanyValuationResultDao;
	
	@OneToOne(mappedBy="scenario")
	private FcfCompanyValuationResultDao fcfCompanyValuationResultDao;
	
	@OneToMany(mappedBy="scenario")
	private List<MultiPeriodAccountingFigureDao> multiPeriodAccountingFigures = new ArrayList<>();
	
	@OneToMany(mappedBy="scenario")
	private List<CompanyValueDistributionPointDao> companyValueDistributionPoints = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AppUserId")
	private AppUserDao appUser;
	
	public Long getScenarioId() { return scenarioId; }

	public String getScenarioName() { return scenarioName; }
	public void setScenarioName(String scenarioName) { this.scenarioName = scenarioName; }

	public String getScenarioDescription() { return scenarioDescription; }
	public void setScenarioDescription(String scenarioDescription) { this.scenarioDescription = scenarioDescription; }

	public Integer getForecastPeriods() { return forecastPeriods; }
	public void setForecastPeriods(Integer forecastPeriods) { this.forecastPeriods = forecastPeriods; }

	public Double getBusinessTaxRate() { return businessTaxRate; }
	public void setBusinessTaxRate(Double businessTaxRate) { this.businessTaxRate = businessTaxRate; }

	public Double getCorporateTaxRate() { return corporateTaxRate; } 
	public void setCorporateTaxRate(Double corporateTaxRate) { this.corporateTaxRate = corporateTaxRate; }

	public Double getSolidaryTaxRate() { return solidaryTaxRate; }
	public void setSolidaryTaxRate(Double solidaryTaxRate) { this.solidaryTaxRate = solidaryTaxRate; }

	public Double getEquityInterestRate() { return equityInterestRate; }
	public void setEquityInterestRate(Double equityInterestRate) { this.equityInterestRate = equityInterestRate; }

	public Double getInterestOnLiabilitiesRate() { return interestOnLiabilitiesRate; }
	public void setInterestOnLiabilitiesRate(Double interestOnLiabilitiesRate) { this.interestOnLiabilitiesRate = interestOnLiabilitiesRate; }

	public ApvCompanyValuationResultDao getApvCompanyValuationResultDao() { return apvCompanyValuationResultDao; }
	public void setApvCompanyValuationResultDao(ApvCompanyValuationResultDao apvCompanyValuationResultDao) { this.apvCompanyValuationResultDao = apvCompanyValuationResultDao; }

	public FteCompanyValuationResultDao getFteCompanyValuationResultDao() { return fteCompanyValuationResultDao; }
	public void setFteCompanyValuationResultDao(FteCompanyValuationResultDao fteCompanyValuationResultDao) { this.fteCompanyValuationResultDao = fteCompanyValuationResultDao; }

	public FcfCompanyValuationResultDao getFcfCompanyValuationResultDao() { return fcfCompanyValuationResultDao; }
	public void setFcfCompanyValuationResultDao(FcfCompanyValuationResultDao fcfCompanyValuationResultDao) { this.fcfCompanyValuationResultDao = fcfCompanyValuationResultDao;}
	
	public List<CompanyValueDistributionPointDao> getCompanyValueDistributionPoints(){return companyValueDistributionPoints;}
	public void setCompanyValueDistributionPoints(List<CompanyValueDistributionPointDao> companyValueDistributionPoints) {this.companyValueDistributionPoints = companyValueDistributionPoints;}

	public AppUserDao getAppUser() { return appUser; }
	public void setAppUser(AppUserDao appUser) { this.appUser = appUser; }
	
	public List<MultiPeriodAccountingFigureDao> getMultiPeriodAccountingFigures(){ return multiPeriodAccountingFigures; }
	public void setMultiPeriodAccountingFigures(List<MultiPeriodAccountingFigureDao> multiPeriodAccountingFigures) { this.multiPeriodAccountingFigures = multiPeriodAccountingFigures; }
}
