package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;




public class FTECalculationService{
	

	public double calculateFlowToEquity(double freeCashFlow, double liabilities, double interestOnLiabilities, double changesOnLiabilities,  
			double effectiveTaxRate) {

		double taxShield = effectiveTaxRate * interestOnLiabilities;
		double totalCashFlow = freeCashFlow + taxShield;
		double flowToEquity = totalCashFlow - interestOnLiabilities + changesOnLiabilities;
		return flowToEquity; 
	}
}
	
