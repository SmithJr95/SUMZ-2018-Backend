package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.ICompanyValuationService;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.ApvCompanyValuationResult;

public class CompanyValuationService implements ICompanyValuationService{
	public ApvCompanyValuationResult performApvCompanyValuation(double[] cashflows, double[] liabilities, double equityInterest, double outsideCapitalInterest, double corporateTax) {
		
		double debtFreeMarketValueOfEquity = 0;
		
		for (int i = 0; i < cashflows.length; i++) {
			debtFreeMarketValueOfEquity += (cashflows[i] / Math.pow((1 + equityInterest), i + 1)); 
		}
		
		double capitalStructureEffect = 0;
		
		for (int i = 0; i < liabilities.length; i++) {
			double taxShield = liabilities[i] * outsideCapitalInterest * corporateTax;
			capitalStructureEffect += taxShield / Math.pow((1 + outsideCapitalInterest), 1 + i);
		}
		
		double marketValueTotalAssets = debtFreeMarketValueOfEquity + capitalStructureEffect;
					
		
		return null;
	}
}
