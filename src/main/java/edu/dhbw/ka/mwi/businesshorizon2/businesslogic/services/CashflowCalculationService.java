package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

public class CashflowCalculationService {

	// input variables 
	// Translations: Einzahlungen, Auszahlungen, Abschreibungen, Zinsen, Körperschaftssteuer, Gewerbesteuer, Soli, , Auszahlungen aus Investitionen, Einzahlungen aus Investitionen, Fremdkapital
	private double 
	proceeds, 
	payments, 
	deprication,  
	investments, 
	proceedsFromDeinvestments, 
	foreignCapital;
	
	private final double
	BUSINESS_TAX, 
	CORPORATION_TAX, 
	SOLIDARY_TAX;
	
	




	// variables to be calculated
	private double cf, operatingCF, freeCF, totalCF, flowToEquity;
	
	
	/**
	 * @param proceeds = Einzahlungen
	 * @param payments = Auszahlungen 
	 * @param deprication = Abschreibung
	 * @param businessTax = Gewerbesteuersatz
	 * @param corporationTax = Körperschaftssteuersatz
	 * @param solidaryTax = Solidaritätszuschlag
	 * @param interest = gezahlte Zinsen (absolut)
	 * @param investments = getätigte Investitionen
	 * @param proceedsFromDeinvestments = Einzahlungen aus Desinvestitionen
	 */
	public CashflowCalculationService(double proceeds, double payments, double deprication, double businessTax, double corporationTax, double solidaryTax, double investments, double proceedsFromDeinvestments){
		
		this.proceeds = proceeds;
		this.payments = payments;
		this.deprication = deprication;
		this.BUSINESS_TAX = businessTax;
		this.CORPORATION_TAX = corporationTax;
		this.SOLIDARY_TAX = solidaryTax;
		this.investments = investments;
		this.proceedsFromDeinvestments = proceedsFromDeinvestments;


		
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
		double ebit = calculateEBIT(cf, deprication);
		double absoluteTax = calculateAbsoluteTax(ebit);
		double operatingCF = calculateOperatingCF(cf, absoluteTax);
		
		// 3. free cashflow
		double fcf = operatingCF - (investments - proceedsFromDeinvestments);
		
		this.cf = cf;
		this.operatingCF = operatingCF;
		this.freeCF = fcf;
		
		return fcf;
		
		
	}
	
	
	
	private double calculateCF(double proceeds, double payments) {
		return proceeds - payments;
	}
	
	
	private double calculateOperatingCF(double cf, double absoluteTax) {
				
		double operatingCF = cf - absoluteTax;
		return operatingCF;
				
	}
	
	
	
	// calculate absolute value of taxes to pay
	// CAUTION: This method is based on the assumption that the company is fully financed without foreign capital
	protected double calculateAbsoluteTax(double ebit){
		

		//double absouluteBusinessTax = (ebit + interest / 4) * businessTax;
		double absouluteBusinessTax = (ebit) * BUSINESS_TAX;
		double absoluteCorporationTax = (CORPORATION_TAX * (1 + SOLIDARY_TAX)) * ebit;
		return absouluteBusinessTax + absoluteCorporationTax;
		
			
	}
	

	
	public double calculateEBIT(double cf, double deprication){
		return cf - deprication;
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






	public double getDeprication() {
		return deprication;
	}






	public void setDeprication(double deprication) {
		this.deprication = deprication;
		runCashflowCalculation();
	}



	public double getBusinessTax() {
		return BUSINESS_TAX;
	}







	public double getCorporationTax() {
		return CORPORATION_TAX;
	}






	public double getSolidaryTax() {
		return SOLIDARY_TAX;
	}






	public double getInvestments() {
		return investments;
	}






	public void setInvestments(double investments) {
		this.investments = investments;
		runCashflowCalculation();
	}






	public double getProceedsFromDeinvestments() {
		return proceedsFromDeinvestments;
	}






	public void setProceedsFromDeinvestments(double proceedsFromDeinvestments) {
		this.proceedsFromDeinvestments = proceedsFromDeinvestments;
		runCashflowCalculation();
	}






	public double getForeignCapital() {
		return foreignCapital;
	}






	public void setForeignCapital(double foreignCapital) {
		this.foreignCapital = foreignCapital;
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
