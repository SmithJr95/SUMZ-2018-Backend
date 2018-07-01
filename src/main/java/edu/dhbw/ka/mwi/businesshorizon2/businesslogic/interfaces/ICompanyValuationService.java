package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.ApvCompanyValuationResult;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.FcfCompanyValuationResult;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.FteCompanyValuationResult;

public interface ICompanyValuationService {
	public ApvCompanyValuationResult performApvCompanyValuation(double[] freeCashFlow, double[] liabilities,
			double equityInterest, double interestOnLiabilities, double effectiveTaxRate);

	public FcfCompanyValuationResult performFcfCompanyValuationResult(double[] freeCashFlow, double[] liabilities,
			 double equityInterest, double interestOnLiabilities, double effectiveTaxRate);

	public FteCompanyValuationResult performFteCompanyValuationResult(double[] flowToEquity, double[] liabilities,
			double equityInterest, double interestOnLiabilities, double effectiveTaxRate);
}
