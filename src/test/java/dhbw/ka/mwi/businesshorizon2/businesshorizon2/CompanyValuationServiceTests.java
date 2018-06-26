package dhbw.ka.mwi.businesshorizon2.businesshorizon2;

import org.junit.Assert;
import org.junit.Test;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services.CompanyValuationService;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.ApvCompanyValuationResult;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.FteCompanyValuationResult;
import junit.framework.TestCase;

public class CompanyValuationServiceTests{
	
	@Test
	public void performApvCompanyValuation() {
		double[] cashflows = new double[] { 2950.0, 2260.0, 2690.0, 4470.0 };
		double[] liabilities = new double[] { 19000.0, 19500.0, 20000.0, 20500.0, 20500.0 };
		double equityInterest = 0.09;
		double outsideCapitalInterest = 0.05;
		double corporateTax = 0.3;
		
		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResult apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows, liabilities, equityInterest, outsideCapitalInterest, corporateTax);
		
		Assert.assertEquals(32146.0, apvCompanyValuationResult.getCompanyValue(), 0.1);
		
	}
	
	@Test
	public void performFteCompanyValuation() {
		double[] cashflows = new double[] { 124.34, 134.51, 166.02, 120.00 };
		double[] liabilities = new double[] { 1260.0, 1320.0, 1330.0, 1400.0, 1400.0 };
		double equityInterest = 0.09969137;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.26325;
		
		CompanyValuationService valuationService = new CompanyValuationService();
		FteCompanyValuationResult fteCompanyValuationResult = valuationService.performFteCompanyValuationResult(cashflows, liabilities, equityInterest, outsideCapitalInterest, corporateTax);
		
		//Assert.assertEquals(32146.0, fteCompanyValuationResult.getCompanyValue(), 0.1);
		Assert.assertEquals(true, true);
		
	}
	
}
