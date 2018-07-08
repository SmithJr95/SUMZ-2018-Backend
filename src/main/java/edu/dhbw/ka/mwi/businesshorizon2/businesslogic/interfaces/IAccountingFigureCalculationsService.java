package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigureNames;

@Service
public interface IAccountingFigureCalculationsService {

	public List<Double> calculateFreeCashFlow(
			List<Double> revenue, 
			List<Double> additionalIncome, 
			List<Double> costOfMaterial, 
			List<Double> costOfStaff, 
			List<Double> additionalCosts, 
			List<Double> depreciation, 
			Double businessTaxRate, 
			Double corporateTaxRate, 
			Double solidaryTaxRate, 
			List<Double> investments, 
			List<Double> divestments);
	
	public List<Double> calculateFlowToEquity(
			List<Double> freeCashFlow, 
			List<Double> liabilities, 
			Double interestOnLiabilities, 
			Double effectiveTaxRate);
	
	public double calculateEffectiveTaxRate(double businessTaxRate, double corporateTaxRate, double solidaryTaxRate);
	
	public List<Double> getMeanAccountingFigureValues(
			HashMap<MultiPeriodAccountingFigureNames, 
			HashMap<Integer, 
			List<Double>>> stochasticAccountingFigures, 
			MultiPeriodAccountingFigureNames figureName, 
			int periods);
}
