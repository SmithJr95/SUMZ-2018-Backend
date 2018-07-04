package dhbw.ka.mwi.businesshorizon2.businesshorizon2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services.CompanyValuationService;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ApvCompanyValuationResultDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.FcfCompanyValuationResultDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.FteCompanyValuationResultDto;


public class CompanyValuationServiceTests {

	@Test
	public void performApvCompanyValuation() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(2950.0);
		cashflows.add(2260.0);
		cashflows.add(2690.0);
		cashflows.add(4470.0);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(19000.0);
		liabilities.add(19500.0);
		liabilities.add(20000.0);
		liabilities.add(20500.0);
		liabilities.add(20500.0);
		
		double equityInterest = 0.09;
		double outsideCapitalInterest = 0.05;
		double corporateTax = 0.3;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResultDto apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(32146.0, apvCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performFcfCompanyValuation() {

		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(2950.0);
		cashflows.add(2260.0);
		cashflows.add(2690.0);
		cashflows.add(4470.0);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(19000.0);
		liabilities.add(19500.0);
		liabilities.add(20000.0);
		liabilities.add(20500.0);
		liabilities.add(20500.0);
		
		double corporateTax = 0.3;
		double equityInterest = 0.09;
		double outsideCapitalInterest = 0.05;
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResultDto fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, equityInterest,
				outsideCapitalInterest, corporateTax);

		Assert.assertEquals(32146.0,fcfCompanyValuationResult.getCompanyValue(), 0.1);
	}
	

	@Test
	public void performFteCompanyValuation() {
		
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(124.34);
		cashflows.add(134.51);
		cashflows.add(166.02);
		cashflows.add(120.0);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1260.0);
		liabilities.add(1320.0);
		liabilities.add(1330.0);
		liabilities.add(1400.0);
		liabilities.add(1400.0);
		
		double equityInterest = 0.09969137;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.26325;

		CompanyValuationService valuationService = new CompanyValuationService();
		FteCompanyValuationResultDto fteCompanyValuationResult = valuationService.performFteCompanyValuationResult(
				cashflows, liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(1055.24, fteCompanyValuationResult.getCompanyValue(), 0.1);

	}
}
