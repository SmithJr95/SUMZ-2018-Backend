package dhbw.ka.mwi.businesshorizon2.businesshorizon2;

import org.junit.Assert;
import org.junit.Test;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services.CompanyValuationService;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.ApvCompanyValuationResult;
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
		
		Assert.assertEquals(32146.0, apvCompanyValuationResult.getCompanyValue(), 1.0);
		
	}
	
}
