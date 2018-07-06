package edu.dhbw.ka.mwi.businesshorizon2.models.daos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "FcfCompanyValuationResult")
@Table(name = "FcfCompanyValuationResult")
public class FcfCompanyValuationResultDao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FcfCompanyValuationResultId")
	private Long fcfCompanyValuationResultId;
	
	@Column(name="CompanyValue")
	private Double companyValue;
	
	@Column(name="MarketValueTotalAssets")
	private Double marketValueTotalAssets;
	
	@Column(name="TotalLiabilities")
	private Double totalLiabilities;
	
	@OneToOne
	@JoinColumn(name="ScenarioId")
	private ScenarioDao scenario;
	
	public FcfCompanyValuationResultDao() {}
	
	public FcfCompanyValuationResultDao(Double companyValue, Double marketValueTotalAssets, Double totalLiabilities) {
		this.companyValue = companyValue;
		this.marketValueTotalAssets = marketValueTotalAssets;
		this.totalLiabilities = totalLiabilities;
	}
	
	public Long getFcfCompanyValuationResultId() { return fcfCompanyValuationResultId; }

	public Double getCompanyValue() { return companyValue; }
	public void setCompanyValue(Double companyValue) { this.companyValue = companyValue; }

	public Double getMarketValueTotalAssets() { return marketValueTotalAssets; }
	public void setMarketValueTotalAssets(Double marketValueTotalAssets) { this.marketValueTotalAssets = marketValueTotalAssets; }

	public Double getTotalLiabilities() { return totalLiabilities; }
	public void setTotalLiabilities(Double totalLiabilities) { this.totalLiabilities = totalLiabilities; }
	
	public ScenarioDao getScenario() { return scenario; }
	public void setScenario(ScenarioDao scenario) { this.scenario = scenario; }
}
