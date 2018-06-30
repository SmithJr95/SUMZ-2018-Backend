package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.ICompanyValuationService;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.ApvCompanyValuationResult;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.FcfCompanyValuationResult;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.FteCompanyValuationResult;

public class CompanyValuationService implements ICompanyValuationService {

	public ApvCompanyValuationResult performApvCompanyValuation(double[] freeCashFlow, double[] liabilities,
			double equityInterest, double interestOnLiabilities, double effectiveTaxRate) {
		double companyValue = 0;
		double presentValueOfCashflows = 0;
		double capitalStructureEffect = 0;

		for (int i = 0; i < freeCashFlow.length - 1; i++) {
			presentValueOfCashflows += (freeCashFlow[i] / Math.pow((1 + equityInterest), i + 1));

			double taxShield = effectiveTaxRate * interestOnLiabilities * liabilities[i];
			capitalStructureEffect += (taxShield / Math.pow((1 + interestOnLiabilities), i + 1));
		}

		presentValueOfCashflows += (freeCashFlow[freeCashFlow.length - 1]
				/ (equityInterest * Math.pow((1 + equityInterest), freeCashFlow.length - 1)));

		double taxShield = effectiveTaxRate * interestOnLiabilities * liabilities[freeCashFlow.length - 1];
		capitalStructureEffect += (taxShield
				/ (interestOnLiabilities * Math.pow((1 + interestOnLiabilities), freeCashFlow.length - 1)));

		companyValue = presentValueOfCashflows + capitalStructureEffect - liabilities[0];

		return new ApvCompanyValuationResult(companyValue, presentValueOfCashflows + capitalStructureEffect,
				liabilities[0], presentValueOfCashflows, capitalStructureEffect);

	}

	public FcfCompanyValuationResult performFcfCompanyValuationResult(double[] freeCashFlow, double[] liabilities,
			 double equityInterest, double interestOnLiabilities, double effectiveTaxRate) {
		
		double companyValue = 0;
		double marketValueTotalAssets = 0;
		double[] capitalStructureEffect = new double[liabilities.length];

		for (int e = 0; e < liabilities.length - 1; e++) {
			double capitalStructureEffectForPeriod_E = 0;

			int count = 0;

			for (int i = e; i < freeCashFlow.length - 1; i++) {

				double taxShield = effectiveTaxRate * interestOnLiabilities * liabilities[i];
				capitalStructureEffectForPeriod_E += (taxShield / Math.pow((1 + interestOnLiabilities), count + 1));
				count++;
			}

			double taxShield = effectiveTaxRate * interestOnLiabilities * liabilities[freeCashFlow.length - 1];
			capitalStructureEffectForPeriod_E += (taxShield
					/ (interestOnLiabilities * Math.pow((1 + interestOnLiabilities), count)));
			capitalStructureEffect[e] = capitalStructureEffectForPeriod_E;
		}

		double taxShield = effectiveTaxRate * interestOnLiabilities * liabilities[liabilities.length - 1];
		capitalStructureEffect[capitalStructureEffect.length - 1] = (taxShield / (interestOnLiabilities)
				* (1 + interestOnLiabilities));

		double[] cashflowsWithPeriodZero = new double[freeCashFlow.length + 1];
		cashflowsWithPeriodZero[0] = 0;
		for (int i = 0; i < freeCashFlow.length; i++) {
			cashflowsWithPeriodZero[i + 1] = freeCashFlow[i];
		}

		double totalCapitalMarketValueOfLastPeriod = (cashflowsWithPeriodZero[cashflowsWithPeriodZero.length - 1]
				+ liabilities[liabilities.length - 1] * effectiveTaxRate * equityInterest) / equityInterest;

		double totalCapitalMarketValueOfPeriod_i = totalCapitalMarketValueOfLastPeriod;

		for (int i = liabilities.length - 2; i > 0; i--) {

			double ValueEquityOfPeriod_iMinus1 = (totalCapitalMarketValueOfPeriod_i + cashflowsWithPeriodZero[i]
					- liabilities[i - 1]
					- (equityInterest - interestOnLiabilities) * (liabilities[i - 1] - capitalStructureEffect[i - 1])
					- interestOnLiabilities * (1 - effectiveTaxRate) * liabilities[i - 1]) / (1 + equityInterest);

			totalCapitalMarketValueOfPeriod_i = ValueEquityOfPeriod_iMinus1 + liabilities[i - 1];
			companyValue = ValueEquityOfPeriod_iMinus1;
			marketValueTotalAssets = totalCapitalMarketValueOfPeriod_i;
		}
		
		
		return new FcfCompanyValuationResult(companyValue, marketValueTotalAssets, 0);
	}

	public FteCompanyValuationResult performFteCompanyValuationResult(double[] flowToEquity, double[] liabilities,
			double equityInterest, double interestOnLiabilities, double effectiveTaxRate) {
		double companyValue = 0;
		double[] equity = new double[liabilities.length];
		double[] adjustedEquityInterest = new double[flowToEquity.length];
		double[] marketValueEquity = new double[liabilities.length];
		double[] discountedTaxShields = new double[liabilities.length];

		// calculate discountedTaxShields
		for (int i = 0; i < discountedTaxShields.length; i++) {
			double taxShield = 0;
			double discountedTaxShield = 0;

			for (int j = i; j < discountedTaxShields.length - 1; j++) {
				taxShield = effectiveTaxRate * interestOnLiabilities * liabilities[j];
				discountedTaxShield += (taxShield / Math.pow((1 + interestOnLiabilities), j + 1 - i));
			}

			discountedTaxShield += (effectiveTaxRate * liabilities[liabilities.length - 1])
					/ Math.pow((1 + interestOnLiabilities), liabilities.length - 1 - i);
			discountedTaxShields[i] = discountedTaxShield;
			// System.out.println(discountedTaxShield);
		}

		// calculate marketValuesEquity
		marketValueEquity[marketValueEquity.length - 2] = (flowToEquity[flowToEquity.length - 1]
				- (equityInterest - interestOnLiabilities) * (1 - effectiveTaxRate) * liabilities[liabilities.length - 2])
				/ equityInterest;
		marketValueEquity[marketValueEquity.length - 1] = marketValueEquity[marketValueEquity.length - 2];

		for (int i = marketValueEquity.length - 3; i >= 0; i--) {
			marketValueEquity[i] = (marketValueEquity[i + 1] + flowToEquity[i]
					- (equityInterest - interestOnLiabilities) * ((liabilities[i]) - discountedTaxShields[i]))
					/ (1 + equityInterest);
		}

		return new FteCompanyValuationResult(marketValueEquity[0]);

	}
}
