package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.AccountingFigure;

public class ScenarioPostRequestDto {
	
	@NotNull
	private String name;
	
	@NotNull
	private String description;
	
	@DecimalMin("1")
	private int periods;
	
	@DecimalMin("0.0")
	private double equityInterest;
	
	@DecimalMin("0.0")
	private double outsideCapitalInterest;
	
	@DecimalMin("0.0")
	private double corporateTax;
	
	@NotNull
	@Valid
	private AccountingFigure[] accountingFigures;
	
	
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

	public AccountingFigure[] getAccountingFigures() {
		return accountingFigures;
	}

	public void setAccountingFigures(AccountingFigure[] accountingFigures) {
		this.accountingFigures = accountingFigures;
	}
	
	@Override
	public String toString() {
		
		String newLine = System.getProperty("line.separator");

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
		for (int i = 0; i < this.accountingFigures.length; i++) {
			sb.append(this.accountingFigures[i].toString() + newLine);
		}
	
		return sb.toString();
	}
}
