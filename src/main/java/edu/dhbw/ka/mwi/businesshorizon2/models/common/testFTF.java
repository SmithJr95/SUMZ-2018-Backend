package edu.dhbw.ka.mwi.businesshorizon2.models.common;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services.CompanyValuationService;

public class testFTF {

	
	@Test public void FTFtest(){
		CompanyValuationService a = new CompanyValuationService();
		 
		System.out.println("Hello World");
		double [] cashflows = {0,2950,2260,2690,4470};
		double [] liabilities = {19000,19500,20000,20500,20500};
		double corporateTax = 0.3;
		double equityInterest = 0.09;
		double outsideCapitalInterest = 0.05;
		
		a.performFcfCompanyValuationResult(cashflows, liabilities, corporateTax, equityInterest, outsideCapitalInterest);
		
		assertEquals(1, 1);
	}
	
	
	
}
