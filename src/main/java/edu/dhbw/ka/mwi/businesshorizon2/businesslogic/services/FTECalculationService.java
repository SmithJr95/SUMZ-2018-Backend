package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

import org.springframework.stereotype.Service;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.IFTECalculationService;

@Service
public class FTECalculationService implements IFTECalculationService{
	

	/**
	 * @param freeCashFlow
	 * @param liabilities
	 * @param previousLiabilities
	 * @param interestOnLiabilities
	 * @param effectiveTaxRate
	 * @return
	 */
	public double calculateFlowToEquity(double freeCashFlow, double liabilities, double previousLiabilities, double interestOnLiabilities,  
			double effectiveTaxRate) {

		double taxShield = effectiveTaxRate * interestOnLiabilities;
		double totalCashFlow = freeCashFlow + taxShield;
		double flowToEquity = totalCashFlow - interestOnLiabilities + (liabilities - previousLiabilities);
		return flowToEquity; 
	}
}

