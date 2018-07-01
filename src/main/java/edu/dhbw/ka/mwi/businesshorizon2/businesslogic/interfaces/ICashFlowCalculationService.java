package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces;

public interface ICashFlowCalculationService {

	public double calculateFreeCashFlow(double revenue, double additionalIncome, double costOfMaterial, 
			double costOfStaff, double additionalCosts, double depreciation, double businessTaxRate, 
			double corporateTaxRate, double solidaryTaxRate, double investments, double divestments);
	
}
