package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

public class FTECalculationService extends CashflowCalculationService {

	
	// Input parameters
	private double
	interestOnLiabilities,
	previousLiabilities,
	liabilities;
	
	// Parameters to be calculated
	private double
	taxShield,
	totalCF,
	flowToEquity;
	
	
	/**
	 * @param proceeds = Einzahlungen
	 * @param payments = Auszahlungen 
	 * @param deprication = Abschreibung
	 * @param businessTax = Gewerbesteuersatz
	 * @param corporationTax = Körperschaftssteuersatz
	 * @param solidaryTax = Solidaritätszuschlag
	 * @param interestOnLiabilities = gezahlte Zinsen (absolut)
	 * @param investments = getätigte Investitionen
	 * @param divestments = Einzahlungen aus Desinvestitionen
	 * @param interestOnLiabilities = Zinsen --> paid interests
	 * @param previousLiabilities --> foreign capital at the end of the previous period
	 * @param liabilities --> foreign capital at the end of the relevant period
	 */
	public FTECalculationService(double proceeds, double payments, double depreciation, double businessTaxRate, double corporateTaxRate, double solidaryTaxRate, double investments, double divestments, double interestOnLiabilities, double previousLiabilities, double liabilities){
		
		super(proceeds, payments, depreciation, businessTaxRate, corporateTaxRate, solidaryTaxRate, investments, divestments);
		this.interestOnLiabilities = interestOnLiabilities;
		this.previousLiabilities = previousLiabilities;
		this.liabilities = liabilities;
		
		runCalculation();
		
		
		
	}
	
	private void runCalculation(){
		super.runCashflowCalculation();
		this.taxShield = calculateTaxShield();
		this.totalCF = calculateTotalCF();
		this.flowToEquity = calculateFTE();
			
		
	}
	
	private double calculateFTE() {
		double creditAdd = this.liabilities - previousLiabilities;
		
		double fte = this.calculateTotalCF() - this.interestOnLiabilities + creditAdd;
		
		return fte;
	}
	
	private double calculateTotalCF() {
		
		double totalCF = super.getFreeCF() + this.taxShield;
		
		return totalCF;
	}
	
	private double calculateTaxShield(){
		
		double ebit = calculateEBIT(super.getCf(), super.getDepreciation());
		double absoluteTaxWithoutForeignCapital = super.calculateAbsoluteTaxWithoutLiabilities(ebit);
		double ebt = ebit - interestOnLiabilities;
		
		double paidTaxes = (ebt + 0.25 * interestOnLiabilities) * super.getBusinessTaxRate() + ebt * (super.getCorporateTaxRate() * (1 + super.getSolidaryTaxRate()));
		
		double taxShield = Math.abs(absoluteTaxWithoutForeignCapital - paidTaxes);
		
		
		return taxShield;
		
				
	}

	public double getInterestOnLiabilities() {
		return interestOnLiabilities;
	}

	public void setInterestOnLiabilities(double interestOnLiabilities) {
		this.interestOnLiabilities = interestOnLiabilities;
	}

	public double getPreviousLiabilities() {
		return previousLiabilities;
	}

	public void setPreviousLiabilities(double previousLiabilities) {
		this.previousLiabilities = previousLiabilities;
	}

	public double getLiabilities() {
		return liabilities;
	}

	public void setLiabilities(double liabilities) {
		this.liabilities = liabilities;
	}

	public double getTaxShield() {
		return taxShield;
	}

	public double getTotalCF() {
		return totalCF;
	}

	public double getFlowToEquity() {
		return flowToEquity;
	}
	
	
	
}
