package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

public class CashflowCalculationService {
	
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
		System.out.println("CF: "+cashFlow);
		double absoluteTaxes = (cashFlow - depreciation) * (businessTaxRate + (corporateTaxRate * (1 + solidaryTaxRate)));
		double operatingCashFlow = cashFlow - absoluteTaxes;
		System.out.println("operating CF: "+ operatingCashFlow);
		double freeCashFlow = operatingCashFlow - (investments - divestments);
		
		System.out.println("Free CF:" + freeCashFlow);
		return freeCashFlow;
	}
	
}
