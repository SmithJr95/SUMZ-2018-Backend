package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

public class CashflowCalculationService {

	// input variables 
	// Translations: Einzahlungen, Auszahlungen, Abschreibungen, Zinsen, Körperschaftssteuer, Gewerbesteuer, Soli, , Auszahlungen aus Investitionen, Einzahlungen aus Investitionen, Fremdkapital
	private double 
	proceeds, 
	payments, 
	depreciation,  
	investments, 
	divestments, 
	liabilities;
	
	private final double
	BUSINESS_TAX_RATE, 
	CORPORATE_TAX_RATE, 
	SOLIDARY_TAX_RATE;
	
	




	// variables to be calculated
	private double cf, operatingCF, freeCF, totalCF, flowToEquity;
	
	
	/**
	 * @param proceeds = Einzahlungen
	 * @param payments = Auszahlungen 
	 * @param depreciation = Abschreibung
	 * @param businessTaxRate = Gewerbesteuersatz
	 * @param corporateTax = Körperschaftssteuersatz
	 * @param solidaryTaxRate = Solidaritätszuschlag
	 * @param interest = gezahlte Zinsen (absolut)
	 * @param investments = getätigte Investitionen
	 * @param divestments = Einzahlungen aus Desinvestitionen
	 */
	public CashflowCalculationService(double proceeds, double payments, double depreciation, double businessTaxRate, double corporateTaxRate, double solidaryTaxRate, double investments, double divestments){
		
		this.proceeds = proceeds;
		this.payments = payments;
		this.depreciation = depreciation;
		this.BUSINESS_TAX_RATE = businessTaxRate;
		this.CORPORATE_TAX_RATE = corporateTaxRate;
		this.SOLIDARY_TAX_RATE = solidaryTaxRate;
		this.investments = investments;
		this.divestments = divestments;


		
		runCashflowCalculation();
		

		
	}
	
	
	public double runCashflowCalculation(){
		
		/*		Proceeds 
		 * 		- payments
		 * 		= cashflow
		 * 		- Taxes without foreign capital	
		 * 		= operating cashflow
		 * 		- investions
		 * 		+ desinvestions
		 * 		= free cashflow
		 */		
		
		// 1. Cashflow
		double cf =calculateCF(proceeds, payments);
		
		// 2. operating cashflow
		double ebit = calculateEBIT(cf, depreciation);
		double absoluteTaxWithoutLiabilities = calculateAbsoluteTaxWithoutLiabilities(ebit);
		double operatingCF = calculateOperatingCF(cf, absoluteTaxWithoutLiabilities);
		
		// 3. free cashflow
		double fcf = operatingCF - (investments - divestments);
		
		this.cf = cf;
		this.operatingCF = operatingCF;
		this.freeCF = fcf;
		
		return fcf;
		
		
	}
	
	
	
	private double calculateCF(double proceeds, double payments) {
		return proceeds - payments;
	}
	
	
	private double calculateOperatingCF(double cf, double absoluteTaxWithoutLiabilities) {
				
		double operatingCF = cf - absoluteTaxWithoutLiabilities;
		return operatingCF;
				
	}
	
	
	
	// calculate absolute value of taxes to pay
	// CAUTION: This method is based on the assumption that the company is fully financed without foreign capital
	protected double calculateAbsoluteTaxWithoutLiabilities(double ebit){
		

		//double absouluteBusinessTax = (ebit + interest / 4) * businessTax;
		double absouluteBusinessTax = (ebit) * BUSINESS_TAX_RATE;
		double absoluteCorporateTax = (CORPORATE_TAX_RATE * (1 + SOLIDARY_TAX_RATE)) * ebit;
		return absouluteBusinessTax + absoluteCorporateTax;
		
			
	}
	

	
	public double calculateEBIT(double cf, double depreciation){
		return cf - depreciation;
	}
	
	
	public double getProceeds() {
		return proceeds;
	}






	public void setProceeds(double proceeds) {
		
		this.proceeds = proceeds;
		runCashflowCalculation();
	}






	public double getPayments() {
		return payments;
	}






	public void setPayments(double payments) {
		this.payments = payments;
		runCashflowCalculation();
	}






	public double getDepreciation() {
		return depreciation;
	}






	public void setDepreciation(double depreciation) {
		this.depreciation = depreciation;
		runCashflowCalculation();
	}



	public double getBusinessTaxRate() {
		return BUSINESS_TAX_RATE;
	}







	public double getCorporateTaxRate() {
		return CORPORATE_TAX_RATE;
	}






	public double getSolidaryTaxRate() {
		return SOLIDARY_TAX_RATE;
	}






	public double getInvestments() {
		return investments;
	}






	public void setInvestments(double investments) {
		this.investments = investments;
		runCashflowCalculation();
	}






	public double getDivestments() {
		return divestments;
	}






	public void setDivestments(double divestments) {
		this.divestments = divestments;
		runCashflowCalculation();
	}






	public double getLiabilities() {
		return liabilities;
	}






	public void setLiabilities(double liabilities) {
		this.liabilities = liabilities;
		runCashflowCalculation();
	}


	public double getCf() {
		return cf;
	}


	public double getOperatingCF() {
		return operatingCF;
	}


	public double getFreeCF() {
		return freeCF;
	}


	public double getTotalCF() {
		return totalCF;
	}


	public double getFlowToEquity() {
		return flowToEquity;
	}
	
	
}
