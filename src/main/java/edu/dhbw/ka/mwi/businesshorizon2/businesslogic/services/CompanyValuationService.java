package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.ICompanyValuationService;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.ApvCompanyValuationResult;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.FcfCompanyValuationResult;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.FteCompanyValuationResult;

public class CompanyValuationService implements ICompanyValuationService{
	
	public ApvCompanyValuationResult performApvCompanyValuation(double[] cashflows, double[] liabilities, double equityInterest, double outsideCapitalInterest, double corporateTax) {	
		double companyValue = 0; 
		double presentValueOfCashflows = 0; 
		double capitalStructureEffect = 0;
		
		for (int i = 0; i < cashflows.length - 1; i++) {
			presentValueOfCashflows += (cashflows[i] / Math.pow((1 + equityInterest), i + 1));
			
			double taxShield = corporateTax * outsideCapitalInterest * liabilities[i];
			capitalStructureEffect += (taxShield / Math.pow((1 + outsideCapitalInterest), i + 1));
		}
		
		presentValueOfCashflows += (cashflows[cashflows.length - 1] / (equityInterest * Math.pow((1 + equityInterest), cashflows.length - 1)));
		
		double taxShield = corporateTax * outsideCapitalInterest * liabilities[cashflows.length - 1];
		capitalStructureEffect += (taxShield / (outsideCapitalInterest * Math.pow((1 + outsideCapitalInterest), cashflows.length - 1))); 
		
		companyValue = presentValueOfCashflows + capitalStructureEffect - liabilities[0];
		
		System.out.println(presentValueOfCashflows + " " + capitalStructureEffect + " " + liabilities[0]);
		
		return new ApvCompanyValuationResult(companyValue, presentValueOfCashflows + capitalStructureEffect, liabilities[0], 0, 0);
		
/*		for (int i = 0; i < cashflows.length; i++) {
			debtFreeMarketValueOfEquity += (cashflows[i] / Math.pow((1 + equityInterest), i + 1)); 
		}
		
		
		
		for (int i = 0; i < liabilities.length; i++) {
			double taxShield = liabilities[i] * outsideCapitalInterest * corporateTax;
			capitalStructureEffect += taxShield / Math.pow((1 + outsideCapitalInterest), 1 + i);
		}
		
		double marketValueTotalAssets = debtFreeMarketValueOfEquity + capitalStructureEffect;
		double companyValue = marketValueTotalAssets - liabilities[0];
		//double valuationResult = new ApvCompanyValuationResult(companyValue, marketValueTotalAssets, totalLiabilities, marketValueEquity, taxShield)
		*/
		
	}
	
	public FcfCompanyValuationResult performFcfCompanyValuationResult() {
		
		
		return null;
	}
	
	public FteCompanyValuationResult performFteCompanyValuationResult() {
		
		
		return null;
	}
}
