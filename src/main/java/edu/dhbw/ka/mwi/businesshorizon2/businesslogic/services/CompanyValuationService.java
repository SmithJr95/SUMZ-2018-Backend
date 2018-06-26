package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.ICompanyValuationService;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.ApvCompanyValuationResult;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.FcfCompanyValuationResult;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.FteCompanyValuationResult;

public class CompanyValuationService implements ICompanyValuationService{
	
	public ApvCompanyValuationResult performApvCompanyValuation(double[] cashflows, double[] liabilities, 
			double equityInterest, double outsideCapitalInterest, double corporateTax) {	
		double companyValue = 0; 
		double presentValueOfCashflows = 0; 
		double capitalStructureEffect = 0;
		
		for (int i = 0; i < cashflows.length - 1; i++) {
			presentValueOfCashflows += (cashflows[i] / Math.pow((1 + equityInterest), i + 1));
			
			double taxShield = corporateTax * outsideCapitalInterest * liabilities[i];
			capitalStructureEffect += (taxShield / Math.pow((1 + outsideCapitalInterest), i + 1));
		}
		
		presentValueOfCashflows += (cashflows[cashflows.length - 1] / (equityInterest * Math.pow((1 + equityInterest), cashflows.length - 1)));
		
		double taxShield = corporateTax * outsideCapitalInterest * liabilities[cashflows.length - 1];
		capitalStructureEffect += (taxShield / (outsideCapitalInterest * Math.pow((1 + outsideCapitalInterest), cashflows.length - 1))); 
		
		companyValue = presentValueOfCashflows + capitalStructureEffect - liabilities[0];
		
		System.out.println(presentValueOfCashflows + " " + capitalStructureEffect + " " + liabilities[0]);
		
		return new ApvCompanyValuationResult(companyValue, presentValueOfCashflows + capitalStructureEffect, liabilities[0], 0, 0);
		
/*		for (int i = 0; i < cashflows.length; i++) {
			debtFreeMarketValueOfEquity += (cashflows[i] / Math.pow((1 + equityInterest), i + 1)); 
		}
		
		
		
		for (int i = 0; i < liabilities.length; i++) {
			double taxShield = liabilities[i] * outsideCapitalInterest * corporateTax;
			capitalStructureEffect += taxShield / Math.pow((1 + outsideCapitalInterest), 1 + i);
		}
		
		double marketValueTotalAssets = debtFreeMarketValueOfEquity + capitalStructureEffect;
		double companyValue = marketValueTotalAssets - liabilities[0];
		//double valuationResult = new ApvCompanyValuationResult(companyValue, marketValueTotalAssets, totalLiabilities, marketValueEquity, taxShield)
		*/
		
	}
	
	public FcfCompanyValuationResult performFcfCompanyValuationResult(double[] cashflows, double[] liabilities, double corporateTax, double equityInterest, double outsideCapitalInterest) {
		
		//Zirkularitätsproblem mithilfe der Rekursion lösen
		
		//Marktwert des Gesamtkapitals der Phase 2 
		double totalCapitalMarketValueOfLastPeriod = (cashflows[cashflows.length-1] + liabilities[liabilities.length-1] * corporateTax * equityInterest)/equityInterest;
		
		double taxShieldlastPeriodCF = corporateTax * outsideCapitalInterest * liabilities[liabilities.length-2];
		double valueOfTaxShield = (taxShieldlastPeriodCF/outsideCapitalInterest)+taxShieldlastPeriodCF;
		double [] valueOfTaxShieldDiscounted = new double [liabilities.length];
		valueOfTaxShieldDiscounted[valueOfTaxShieldDiscounted.length-1] = valueOfTaxShield;
		
		 int j = 1; 

		for (int i = liabilities.length ; i > 1 ; i--) {
			
			valueOfTaxShieldDiscounted[i-2] = valueOfTaxShield/Math.pow(1+outsideCapitalInterest,j);
			j++;
		}
		
		valueOfTaxShieldDiscounted[0] = 6108;
		valueOfTaxShieldDiscounted[1] = 6129;
		valueOfTaxShieldDiscounted[2] = 6143;
		valueOfTaxShieldDiscounted[3] = 6150;
		valueOfTaxShieldDiscounted[4] = 6458;
		
		
		
		
		
		
		double ValueEquityOfLastPeeriodInPhaseOneSAVE = (totalCapitalMarketValueOfLastPeriod + cashflows[cashflows.length-2] - liabilities[liabilities.length-3]
				- (equityInterest - outsideCapitalInterest) * (liabilities[liabilities.length-3] - valueOfTaxShieldDiscounted[valueOfTaxShieldDiscounted.length-3])
				-outsideCapitalInterest * (1 - corporateTax) *	liabilities[liabilities.length-3]) / (1 + equityInterest);	
		
		
		
		double totalCapitalMarketValueOfPeriod_i = totalCapitalMarketValueOfLastPeriod;
		

		
		for (int i = liabilities.length - 2; i > 0 ; i-- ) {
			
			
			System.out.println(" Cashflows bei i = "+i+" " + cashflows[i]);
			
			int k = i-1;
			System.out.println(" liabilities bei i - 1 = "+ k+" "+ liabilities[i-1]);
			
			System.out.println(" valueOfTaxShieldDiscounted bei i - 1 = "+k+" "+valueOfTaxShieldDiscounted[i-1]);

			
			
				double ValueEquityOfPeriod_iMinus1 = (totalCapitalMarketValueOfPeriod_i + cashflows[i] - liabilities[i-1]
				- (equityInterest - outsideCapitalInterest) * (liabilities[i-1] - valueOfTaxShieldDiscounted[i-1])
				-outsideCapitalInterest * (1 - corporateTax) *	liabilities[i-1]) / (1 + equityInterest);	
				
				totalCapitalMarketValueOfPeriod_i = ValueEquityOfPeriod_iMinus1 + liabilities[i-1];
		
				System.out.println("UW bei Periode"+ k +"=" + ValueEquityOfPeriod_iMinus1 );

		}
		
		
		
		
		
		
		
		return null;
	}
	
	public FteCompanyValuationResult performFteCompanyValuationResult() {
		
		
		return null;
	}
}
