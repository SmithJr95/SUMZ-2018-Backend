package edu.dhbw.ka.mwi.businesshorizon2.models.daos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "CompanyValueDistributionPoint")
@Table(name = "CompanyValueDistributionPoint")
public class CompanyValueDistributionPointDao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CompanyValueDistributionPointId")
	private Long companyValueDistributionPointId;
	
	@Column(name="XValue", columnDefinition="float")
	private Double xValue;
	
	@Column(name="YValue", columnDefinition="float")
	private Double yValue;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ScenarioId")
	private ScenarioDao scenario;
	
	public CompanyValueDistributionPointDao() {}
	
	public CompanyValueDistributionPointDao(Double xValue, Double yValue) {
		this.xValue = xValue;
		this.yValue = yValue;
	}
	
	public Long getCompanyValueDistributionPointId() { return companyValueDistributionPointId; }
	
	public Double getxValue() { return xValue; }
	public void setxValue(Double xValue) { this.xValue = xValue; }

	public Double getyValue() { return yValue; }
	public void setyValue(Double yValue) { this.yValue = yValue; }
	
	public ScenarioDao getScenario() { return scenario; }
	public void setScenario(ScenarioDao scenario) { this.scenario = scenario; }
}
