package dhbw.ka.mwi.businesshorizon2.businesshorizon2;

import org.junit.Test;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services.CompanyValuationService;
import junit.framework.TestCase;

public class CompanyValuationServiceTests{
	
	@Test
	public void performApvCompanyValuation() {
		double[] cashflows = new double[] { 0.0, 138.61, 202.31, 174.41, 202.52 };
		double[] liabilities = new double[] { 1260.0, 1320.0, 1330.0, 1400.0, 0.0 };
		double equityInterest = 0.09969137;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.15825;
		
		CompanyValuationService valuationService = new CompanyValuationService();
		valuationService.performApvCompanyValuation(cashflows, liabilities, equityInterest, outsideCapitalInterest, corporateTax);
	}
	
}
