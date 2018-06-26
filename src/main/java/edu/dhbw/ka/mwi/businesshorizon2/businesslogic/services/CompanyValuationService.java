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
		
		return new ApvCompanyValuationResult(companyValue, presentValueOfCashflows + capitalStructureEffect, liabilities[0], 0, 0);
		
	}
	
	public FcfCompanyValuationResult performFcfCompanyValuationResult() {
		throw new UnsupportedOperationException();
	}
	
	public FteCompanyValuationResult performFteCompanyValuationResult(double[] cashflows, double[] liabilities, double equityInterest, double outsideCapitalInterest, double corporateTax) {
		double companyValue = 0; 
		double[] equity = new double[liabilities.length];
		double[] adjustedEquityInterest = new double[cashflows.length]; 
		double[] marketValueEquity = new double[liabilities.length]; 
		double[] discountedTaxShields = new double[liabilities.length]; 
		
		//calculate discountedTaxShields
		for (int i = 0; i < discountedTaxShields.length; i++) {
			double taxShield = 0;
			double discountedTaxShield = 0;
			
			for (int j = i; j < discountedTaxShields.length - 1; j++) {
				taxShield = corporateTax * outsideCapitalInterest * liabilities[j];
				discountedTaxShield += (taxShield / Math.pow((1 + outsideCapitalInterest), j + 1 - i));
			}
			
			discountedTaxShield += (corporateTax * liabilities[liabilities.length - 1]) / Math.pow((1 + outsideCapitalInterest), liabilities.length - 1 - i);
			discountedTaxShields[i] = discountedTaxShield;
			//System.out.println(discountedTaxShield);
		}
		
		//calculate marketValuesEquity
		marketValueEquity[marketValueEquity.length - 2] = (cashflows[cashflows.length - 1] - (equityInterest - outsideCapitalInterest) * (1 - corporateTax) * liabilities[liabilities.length - 2]) / equityInterest;
		marketValueEquity[marketValueEquity.length - 1] = marketValueEquity[marketValueEquity.length - 2];

		
		for (int i = marketValueEquity.length - 3; i >= 0; i--) {
			marketValueEquity[i] = (marketValueEquity[i + 1] + cashflows[i] - (equityInterest - outsideCapitalInterest) * ((liabilities[i]) - discountedTaxShields[i])) / (1 + equityInterest);
		}
		
		return new FteCompanyValuationResult(marketValueEquity[0]);
		
	}
}
