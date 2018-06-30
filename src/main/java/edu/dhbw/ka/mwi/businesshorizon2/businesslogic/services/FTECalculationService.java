package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;




public class FTECalculationService{
	

	public double calculateFlowToEquity(double freeCashFlow, double liabilities, double previousLiabilities, double interestOnLiabilities,  
			double effectiveTaxRate) {

		double taxShield = effectiveTaxRate * interestOnLiabilities;
		double totalCashFlow = freeCashFlow + taxShield;
		double flowToEquity = totalCashFlow - interestOnLiabilities + (liabilities - previousLiabilities);
		return flowToEquity; 
	}
}
	
