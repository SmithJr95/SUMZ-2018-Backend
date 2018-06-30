package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.ICashFlowCalculationService;

public class CashFlowCalculationService implements ICashFlowCalculationService {
	
	/**
	 * @param revenue
	 * @param additionalIncome
	 * @param costOfMaterial
	 * @param costOfStaff
	 * @param additionalCosts
	 * @param depreciation
	 * @param businessTaxRate
	 * @param corporateTaxRate
	 * @param solidaryTaxRate
	 * @param investments
	 * @param divestments
	 * @return
	 */
	public double calculateFreeCashFlow(double revenue, double additionalIncome, double costOfMaterial, 
			double costOfStaff, double additionalCosts, double depreciation, double businessTaxRate, 
			double corporateTaxRate, double solidaryTaxRate, double investments, double divestments){
		double proceeds = revenue + additionalIncome;
		double payments = costOfMaterial + costOfStaff + additionalCosts;
		
		double cashFlow = proceeds - payments;

		double absoluteTaxes = (cashFlow - depreciation) * (businessTaxRate + (corporateTaxRate * (1 + solidaryTaxRate)));
		double operatingCashFlow = cashFlow - absoluteTaxes;
		
		double freeCashFlow = operatingCashFlow - (investments - divestments);
		return freeCashFlow;
	}
	
}
