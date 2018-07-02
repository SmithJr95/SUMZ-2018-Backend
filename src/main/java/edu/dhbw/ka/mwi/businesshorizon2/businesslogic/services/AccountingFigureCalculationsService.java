package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.IAccountingFigureCalculationsService;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigureNames;

@Service
public class AccountingFigureCalculationsService implements IAccountingFigureCalculationsService {

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
	
	/**
	 * @param freeCashFlow
	 * @param liabilities
	 * @param previousLiabilities
	 * @param interestOnLiabilities
	 * @param effectiveTaxRate
	 * @return
	 */
	public double calculateFlowToEquity(double freeCashFlow, double liabilities, double previousLiabilities, double interestOnLiabilities,  
			double effectiveTaxRate) {

		double taxShield = effectiveTaxRate * interestOnLiabilities * liabilities;
		double totalCashFlow = freeCashFlow + taxShield;
		double flowToEquity = totalCashFlow - (interestOnLiabilities * liabilities) + (liabilities - previousLiabilities);
		
		return flowToEquity; 
	}	
	
	/**
	 * @param businessTaxRate
	 * @param corporateTaxRate
	 * @param solidaryTaxRate
	 */
	public double calculateEffectiveTaxRate(double businessTaxRate, double corporateTaxRate, double solidaryTaxRate) {
		double effectiveTaxRate = 0.75 * businessTaxRate + corporateTaxRate * (1 + solidaryTaxRate);
		
		return effectiveTaxRate;
	}
	
	public List<Double> getMeanAccountingFigureValues(HashMap<MultiPeriodAccountingFigureNames, HashMap<Integer, List<Double>>> stochasticAccountingFigures, MultiPeriodAccountingFigureNames figureName, int periods) {
		
		List<Double> meanAccountingFigureValues = new ArrayList<Double>();
		
		for (int i = 0; i < periods; i++) {
			final int j = i;
			
			Double meanAccountingFigureValue = stochasticAccountingFigures.get(figureName)
					.values()
					.stream()
					.map(x -> x.get(j))
					.mapToDouble(x -> x)
					.average()
					.getAsDouble();
			
			meanAccountingFigureValues.add(meanAccountingFigureValue);
		}
		
		return meanAccountingFigureValues;
	}
}
