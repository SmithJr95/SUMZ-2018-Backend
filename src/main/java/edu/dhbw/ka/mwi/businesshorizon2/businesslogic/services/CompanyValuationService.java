package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.ICompanyValuationService;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ApvCompanyValuationResultDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.CompanyValueDistributionDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.FcfCompanyValuationResultDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.FteCompanyValuationResultDto;

@Service
public class CompanyValuationService implements ICompanyValuationService {

	public ApvCompanyValuationResultDto performApvCompanyValuation(List<Double> freeCashFlow, List<Double> liabilities,
			double equityInterest, double interestOnLiabilities, double effectiveTaxRate) {
		double companyValue = 0;
		double presentValueOfCashflows = 0;
		double capitalStructureEffect = 0;
		
		Double duplicateLast = liabilities.get(liabilities.size() - 1); 
		liabilities.add(duplicateLast);

		for (int i = 0; i < freeCashFlow.size() - 1; i++) {
			presentValueOfCashflows += (freeCashFlow.get(i) / Math.pow((1 + equityInterest), i + 1));

			double taxShield = effectiveTaxRate * interestOnLiabilities * liabilities.get(i);
			capitalStructureEffect += (taxShield / Math.pow((1 + interestOnLiabilities), i + 1));
		}

		presentValueOfCashflows += (freeCashFlow.get(freeCashFlow.size() - 1)
				/ (equityInterest * Math.pow((1 + equityInterest), freeCashFlow.size() - 1)));

		double taxShield = effectiveTaxRate * interestOnLiabilities * liabilities.get(freeCashFlow.size() - 1);
		capitalStructureEffect += (taxShield
				/ (interestOnLiabilities * Math.pow((1 + interestOnLiabilities), freeCashFlow.size() - 1)));

		companyValue = presentValueOfCashflows + capitalStructureEffect - liabilities.get(0);

		return new ApvCompanyValuationResultDto(companyValue, presentValueOfCashflows + capitalStructureEffect,
				liabilities.get(0), presentValueOfCashflows, capitalStructureEffect);

	}

	public FcfCompanyValuationResultDto performFcfCompanyValuationResult(List<Double> freeCashFlow, List<Double> liabilities,
			 double equityInterest, double interestOnLiabilities, double effectiveTaxRate) {
		
		Double duplicateLast = liabilities.get(liabilities.size() - 1); 
		liabilities.add(duplicateLast);
		
		double companyValue = 0;
		double marketValueTotalAssets = 0;
		double[] capitalStructureEffect = new double[liabilities.size()];

		for (int e = 0; e < liabilities.size() - 1; e++) {
			double capitalStructureEffectForPeriod_E = 0;

			int count = 0;

			for (int i = e; i < freeCashFlow.size() - 1; i++) {

				double taxShield = effectiveTaxRate * interestOnLiabilities * liabilities.get(i);
				capitalStructureEffectForPeriod_E += (taxShield / Math.pow((1 + interestOnLiabilities), count + 1));
				count++;
			}

			double taxShield = effectiveTaxRate * interestOnLiabilities * liabilities.get(freeCashFlow.size()- 1);
			capitalStructureEffectForPeriod_E += (taxShield
					/ (interestOnLiabilities * Math.pow((1 + interestOnLiabilities), count)));
			capitalStructureEffect[e] = capitalStructureEffectForPeriod_E;
		}

		double taxShield = effectiveTaxRate * interestOnLiabilities * liabilities.get(liabilities.size()- 1);
		capitalStructureEffect[capitalStructureEffect.length - 1] = (taxShield / (interestOnLiabilities)
				* (1 + interestOnLiabilities));

		double[] cashflowsWithPeriodZero = new double[freeCashFlow.size() + 1];
		cashflowsWithPeriodZero[0] = 0;
		for (int i = 0; i < freeCashFlow.size(); i++) {
			cashflowsWithPeriodZero[i + 1] = freeCashFlow.get(i);
		}

		double totalCapitalMarketValueOfLastPeriod = (cashflowsWithPeriodZero[cashflowsWithPeriodZero.length - 1]
				+ liabilities.get(liabilities.size()- 1) * effectiveTaxRate * equityInterest) / equityInterest;

		double totalCapitalMarketValueOfPeriod_i = totalCapitalMarketValueOfLastPeriod;

		for (int i = liabilities.size() - 2; i > 0; i--) {

			double ValueEquityOfPeriod_iMinus1 = (totalCapitalMarketValueOfPeriod_i + cashflowsWithPeriodZero[i]
					- liabilities.get(i - 1)
					- (equityInterest - interestOnLiabilities) * (liabilities.get(i - 1) - capitalStructureEffect[i - 1])
					- interestOnLiabilities * (1 - effectiveTaxRate) * liabilities.get(i - 1)) / (1 + equityInterest);

			totalCapitalMarketValueOfPeriod_i = ValueEquityOfPeriod_iMinus1 + liabilities.get(i - 1);
			companyValue = ValueEquityOfPeriod_iMinus1;
			marketValueTotalAssets = totalCapitalMarketValueOfPeriod_i;
		}
		
		
		return new FcfCompanyValuationResultDto(companyValue, marketValueTotalAssets, 0);
	}

	public FteCompanyValuationResultDto performFteCompanyValuationResult(List<Double> flowToEquity, List<Double> liabilities,
			double equityInterest, double interestOnLiabilities, double effectiveTaxRate) {
		
		Double duplicateLast = liabilities.get(liabilities.size() - 1); 
		liabilities.add(duplicateLast);
		
		double companyValue = 0;
		double[] equity = new double[liabilities.size()];
		double[] adjustedEquityInterest = new double[flowToEquity.size()];
		double[] marketValueEquity = new double[liabilities.size()];
		double[] discountedTaxShields = new double[liabilities.size()];

		// calculate discountedTaxShields
		for (int i = 0; i < discountedTaxShields.length; i++) {
			double taxShield = 0;
			double discountedTaxShield = 0;

			for (int j = i; j < discountedTaxShields.length - 1; j++) {
				taxShield = effectiveTaxRate * interestOnLiabilities * liabilities.get(j);
				discountedTaxShield += (taxShield / Math.pow((1 + interestOnLiabilities), j + 1 - i));
			}

			discountedTaxShield += (effectiveTaxRate * liabilities.get(liabilities.size()- 1))
					/ Math.pow((1 + interestOnLiabilities), liabilities.size() - 1 - i);
			discountedTaxShields[i] = discountedTaxShield;
			// System.out.println(discountedTaxShield);
		}

		// calculate marketValuesEquity
		marketValueEquity[marketValueEquity.length - 2] = (flowToEquity.get(flowToEquity.size() - 1)
				- (equityInterest - interestOnLiabilities) * (1 - effectiveTaxRate) * liabilities.get(liabilities.size() - 2))
				/ equityInterest;
		marketValueEquity[marketValueEquity.length - 1] = marketValueEquity[marketValueEquity.length - 2];

		for (int i = marketValueEquity.length - 3; i >= 0; i--) {
			marketValueEquity[i] = (marketValueEquity[i + 1] + flowToEquity.get(i)
					- (equityInterest - interestOnLiabilities) * ((liabilities.get(i)) - discountedTaxShields[i]))
					/ (1 + equityInterest);
		}

		return new FteCompanyValuationResultDto(marketValueEquity[0]);

	}
	
	public CompanyValueDistributionDto getCompanyValueDistribution(List<Double> companyValues) {
		
		double mean = companyValues.stream().mapToDouble(x -> x).average().getAsDouble();
		double standardDeviation = Math.sqrt(companyValues.stream().mapToDouble(x -> Math.pow((x - mean), 2)).sum() / companyValues.size());
		
		double xInterval = standardDeviation / 5;
		
		List<Double> xValues = new ArrayList<Double>();
		List<Double> yValues = new ArrayList<Double>();
		
		double currentXValue = mean - (3 * standardDeviation);
		
		for (int i = 0; i < 31; i++) {
			
			Double probabilityDensity = (1 / Math.sqrt(2 * Math.PI * Math.pow(standardDeviation, 2))) 
					* Math.exp(- Math.pow(currentXValue - mean, 2)/(2 * Math.pow(standardDeviation, 2)));
			
			xValues.add(currentXValue);
			yValues.add(probabilityDensity);		
			
			currentXValue += xInterval;
		}
		
		CompanyValueDistributionDto distribution = new CompanyValueDistributionDto(xValues, yValues);
		
		return distribution;
	}
}
