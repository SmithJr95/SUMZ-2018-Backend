package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.AccountingFigure;

public class ScenarioPostRequestDto {
	private String name;
	private String description;
	private int periods;
	private double equityInterest;
	private double outsideCapitalInterest;
	private double corporateTax;
	private AccountingFigure[] accoutingFigures;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPeriods() {
		return periods;
	}

	public void setPeriods(int periods) {
		this.periods = periods;
	}

	public double getEquityInterest() {
		return equityInterest;
	}

	public void setEquityInterest(double equityInterest) {
		this.equityInterest = equityInterest;
	}

	public double getOutsideCapitalInterest() {
		return outsideCapitalInterest;
	}

	public void setOutsideCapitalInterest(double outsideCapitalInterest) {
		this.outsideCapitalInterest = outsideCapitalInterest;
	}

	public double getCorporateTax() {
		return corporateTax;
	}

	public void setCorporateTax(double corporateTax) {
		this.corporateTax = corporateTax;
	}

	public AccountingFigure[] getAccoutingFigures() {
		return accoutingFigures;
	}

	public void setAccoutingFigures(AccountingFigure[] accoutingFigures) {
		this.accoutingFigures = accoutingFigures;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: ");
		sb.append(this.name);
		sb.append(", ");
		sb.append("Description: ");
		sb.append(this.description);
		sb.append(", ");
		sb.append("Periods: ");
		sb.append(this.periods);
		sb.append(", ");
		sb.append("Equity Interest: ");
		sb.append(this.equityInterest);
		sb.append(", ");
		sb.append("Corporate Tax: ");
		sb.append(this.corporateTax);
		sb.append(", ");
		sb.append("Outside Capital Interest: ");
		sb.append(this.outsideCapitalInterest);
		sb.append(", ");
		sb.append(this.accoutingFigures.toString());
	
		return sb.toString();
	}
}
