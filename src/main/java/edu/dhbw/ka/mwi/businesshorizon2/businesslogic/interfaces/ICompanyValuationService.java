package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces;

import java.util.List;

import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ApvCompanyValuationResultDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.CompanyValueDistributionDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.FcfCompanyValuationResultDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.FteCompanyValuationResultDto;

public interface ICompanyValuationService {
	public ApvCompanyValuationResultDto performApvCompanyValuation(List<Double> freeCashFlow, List<Double> liabilities,
			double equityInterest, double interestOnLiabilities, double effectiveTaxRate);

	public FcfCompanyValuationResultDto performFcfCompanyValuationResult(List<Double> freeCashFlow, List<Double> liabilities,
			 double equityInterest, double interestOnLiabilities, double effectiveTaxRate);

	public FteCompanyValuationResultDto performFteCompanyValuationResult(List<Double> flowToEquity, List<Double> liabilities,
			double equityInterest, double interestOnLiabilities, double effectiveTaxRate);
	
	public CompanyValueDistributionDto getCompanyValueDistribution(List<Double> companyValues);
}
