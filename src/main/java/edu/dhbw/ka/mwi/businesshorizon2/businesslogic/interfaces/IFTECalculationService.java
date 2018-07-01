package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces;

public interface IFTECalculationService {

	
	public double calculateFlowToEquity(double freeCashFlow, double liabilities, double previousLiabilities, double interestOnLiabilities,  
			double effectiveTaxRate);
}
