package edu.dhbw.ka.mwi.businesshorizon2.models.daos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "FteCompanyValuationResult")
@Table(name = "FteCompanyValuationResult")
public class FteCompanyValuationResultDao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FteCompanyValuationResultId")
	private Long fteCompanyValuationResultId;
	
	@Column(name="CompanyValue")
	private Double companyValue;

	public Long getFteCompanyValuationResultId() { return fteCompanyValuationResultId; }

	public Double getCompanyValue() { return companyValue; }
	public void setCompanyValue(Double companyValue) { this.companyValue = companyValue; }
	
}
