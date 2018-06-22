package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

public class FTECalculationService extends CashflowCalculationService {

	
	// Input parameters
	private double
	interest,
	previousForeignCapital,
	foreignCapital;
	
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
	 * @param interest = gezahlte Zinsen (absolut)
	 * @param investments = getätigte Investitionen
	 * @param proceedsFromDeinvestments = Einzahlungen aus Desinvestitionen
	 * @param interest = Zinsen --> paid interests
	 * @param previousForeignCapital --> foreign capital at the end of the previous period
	 * @param foreignCapital --> foreign capital at the end of the relevant period
	 */
	public FTECalculationService(double proceeds, double payments, double deprication, double businessTax, double corporationTax, double solidaryTax, double investments, double proceedsFromDeinvestments, double interest, double previousForeignCapital, double foreignCapital){
		
		super(proceeds, payments, deprication, businessTax, corporationTax, solidaryTax, investments, proceedsFromDeinvestments);
		this.interest = interest;
		this.previousForeignCapital = previousForeignCapital;
		this.foreignCapital = foreignCapital;
		
		runCalculation();
		
		
		
	}
	
	private void runCalculation(){
		super.runCashflowCalculation();
		this.taxShield = calculateTaxShield();
		this.totalCF = calculateTotalCF();
		this.flowToEquity = calculateFTE();
			
		
	}
	
	private double calculateFTE() {
		double creditAdd = this.foreignCapital - previousForeignCapital;
		
		double fte = this.calculateTotalCF() - this.interest + creditAdd;
		
		return fte;
	}
	
	private double calculateTotalCF() {
		
		double totalCF = super.getFreeCF() + this.taxShield;
		
		return totalCF;
	}
	
	private double calculateTaxShield(){
		
		double ebit = calculateEBIT(super.getCf(), super.getDeprication());
		double absoluteTaxWithoutForeignCapital = super.calculateAbsoluteTax(ebit);
		double ebt = ebit - interest;
		
		double paidTaxes = (ebt + 0.25 * interest) * super.getBusinessTax() + ebt * (super.getCorporationTax() * (1 + super.getSolidaryTax()));
		
		double taxShield = Math.abs(absoluteTaxWithoutForeignCapital - paidTaxes);
		
		
		return taxShield;
		
				
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public double getPreviousForeignCapital() {
		return previousForeignCapital;
	}

	public void setPreviousForeignCapital(double previousForeignCapital) {
		this.previousForeignCapital = previousForeignCapital;
	}

	public double getForeignCapital() {
		return foreignCapital;
	}

	public void setForeignCapital(double foreignCapital) {
		this.foreignCapital = foreignCapital;
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
