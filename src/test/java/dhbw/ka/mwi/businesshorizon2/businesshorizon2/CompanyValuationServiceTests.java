package dhbw.ka.mwi.businesshorizon2.businesshorizon2;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services.CompanyValuationService;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.ApvCompanyValuationResult;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.FteCompanyValuationResult;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.FcfCompanyValuationResult;


import junit.framework.TestCase;

public class CompanyValuationServiceTests {

	@Test
	public void performApvCompanyValuation() {
		double[] cashflows = new double[] { 2950.0, 2260.0, 2690.0, 4470.0 };
		double[] liabilities = new double[] { 19000.0, 19500.0, 20000.0, 20500.0, 20500.0 };
		double equityInterest = 0.09;
		double outsideCapitalInterest = 0.05;
		double corporateTax = 0.3;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResult apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(32146.0, apvCompanyValuationResult.getCompanyValue(), 0.1);

	}
	
	/*
	@Test
	public void performFtfCompanyValuation() {

		double[] cashflows = { 2950, 2260, 2690, 4470 };
		double[] liabilities = { 19000, 19500, 20000, 20500, 20500 };
		double corporateTax = 0.3;
		double equityInterest = 0.09;
		double outsideCapitalInterest = 0.05;
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResult fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, corporateTax, equityInterest,
				outsideCapitalInterest);

		Assert.assertEquals(32146.0,fcfCompanyValuationResult.getCompanyValue(), 0.1);
	}
	*/

	@Test
	public void performFteCompanyValuation() {
		double[] cashflows = new double[] { 124.34, 134.51, 166.02, 120.00 };
		double[] liabilities = new double[] { 1260.0, 1320.0, 1330.0, 1400.0, 1400.0 };
		double equityInterest = 0.09969137;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.26325;

		CompanyValuationService valuationService = new CompanyValuationService();
		FteCompanyValuationResult fteCompanyValuationResult = valuationService.performFteCompanyValuationResult(
				cashflows, liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(1055.24, fteCompanyValuationResult.getCompanyValue(), 0.1);

	}
}
