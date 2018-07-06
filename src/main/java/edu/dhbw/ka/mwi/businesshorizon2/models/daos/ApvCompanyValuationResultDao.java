package edu.dhbw.ka.mwi.businesshorizon2.models.daos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "ApvCompanyValuationResult")
@Table(name = "ApvCompanyValuationResult")
public class ApvCompanyValuationResultDao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ApvCompanyValuationResultId")
	private Long apvCompanyValuationResultId;
	
	@Column(name="CompanyValue")
	private Double companyValue;
	
	@Column(name="MarketValueTotalAssets")
	private Double marketValueTotalAssets;
	
	@Column(name="TotalLiabilities")
	private Double totalLiabilities;
	
	@Column(name="PresentValueOfCashflows")
	private Double presentValueOfCashflows;
	
	@Column(name="TaxShield")
	private Double taxShield;
	
	@OneToOne
	@JoinColumn(name="ScenarioId")
	private ScenarioDao scenario;

	public ApvCompanyValuationResultDao() {}
	
	public ApvCompanyValuationResultDao(Double companyValue, Double marketValueTotalAssets, Double totalLiabilities, Double presentValueOfCashflows, Double taxShield) {
		this.companyValue = companyValue;
		this.marketValueTotalAssets = marketValueTotalAssets;
		this.totalLiabilities = totalLiabilities;
		this.presentValueOfCashflows = presentValueOfCashflows;
		this.taxShield = taxShield;
	}
	
	public Long getApvCompanyValuationResultId() { return apvCompanyValuationResultId; }

	public Double getCompanyValue() { return companyValue; }
	public void setCompanyValue(Double companyValue) { this.companyValue = companyValue; }
	
	public Double getMarketValueTotalAssets() { return marketValueTotalAssets; }
	public void setMarketValueTotalAssets(Double marketValueTotalAssets) { this.marketValueTotalAssets = marketValueTotalAssets; }

	public Double getTotalLiabilities() { return totalLiabilities; }
	public void setTotalLiabilities(Double totalLiabilities) { this.totalLiabilities = totalLiabilities; }

	public Double getPresentValueOfCashflows() { return presentValueOfCashflows; } 
	public void setPresentValueOfCashflows(Double presentValueOfCashflows) { this.presentValueOfCashflows = presentValueOfCashflows; }

	public Double getTaxShield() { return taxShield; }
	public void setTaxShield(Double taxShield) { this.taxShield = taxShield;}
	
	public ScenarioDao getScenario() { return scenario; }
	public void setScenario(ScenarioDao scenario) { this.scenario = scenario; }
}
