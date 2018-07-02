package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces;

import java.util.HashMap;
import java.util.List;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigureNames;

public interface IAccountingFigureCalculationsService {

	public double calculateFreeCashFlow(double revenue, double additionalIncome, double costOfMaterial, 
			double costOfStaff, double additionalCosts, double depreciation, double businessTaxRate, 
			double corporateTaxRate, double solidaryTaxRate, double investments, double divestments);
	
	public double calculateFlowToEquity(double freeCashFlow, double liabilities, double previousLiabilities, double interestOnLiabilities,  
			double effectiveTaxRate);
	
	public double calculateEffectiveTaxRate(double businessTaxRate, double corporateTaxRate, double solidaryTaxRate);
	
	public List<Double> getMeanAccountingFigureValues(HashMap<MultiPeriodAccountingFigureNames, HashMap<Integer, List<Double>>> stochasticAccountingFigures, MultiPeriodAccountingFigureNames figureName, int periods);
}
