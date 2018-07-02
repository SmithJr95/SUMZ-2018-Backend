package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces;

import java.util.List;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.ApvCompanyValuationResult;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.CompanyValueDistribution;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.FcfCompanyValuationResult;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.FteCompanyValuationResult;

public interface ICompanyValuationService {
	public ApvCompanyValuationResult performApvCompanyValuation(List<Double> freeCashFlow, List<Double> liabilities,
			double equityInterest, double interestOnLiabilities, double effectiveTaxRate);

	public FcfCompanyValuationResult performFcfCompanyValuationResult(List<Double> freeCashFlow, List<Double> liabilities,
			 double equityInterest, double interestOnLiabilities, double effectiveTaxRate);

	public FteCompanyValuationResult performFteCompanyValuationResult(List<Double> flowToEquity, List<Double> liabilities,
			double equityInterest, double interestOnLiabilities, double effectiveTaxRate);
	
	public CompanyValueDistribution getCompanyValueDistribution(List<Double> companyValues);
}
