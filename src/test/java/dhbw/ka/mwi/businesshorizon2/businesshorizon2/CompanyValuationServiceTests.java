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
		
		double equityInterest = 0.09;
		double outsideCapitalInterest = 0.05;
		double corporateTax = 0.3;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResultDto apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(32146.0, apvCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performApvCompanyValuationWithBallwieserData() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(138.61);
		cashflows.add(202.31);
		cashflows.add(174.41);
		cashflows.add(202.51);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1260.0);
		liabilities.add(1320.0);
		liabilities.add(1330.0);
		liabilities.add(1400.0);
		
		double equityInterest = 0.09969137;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.26325;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResultDto apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(1055.24, apvCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performApvCompanyValuationWithPohlData() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(176.76);
		cashflows.add(520.13);
		cashflows.add(404.87);
		cashflows.add(203.78);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1260.0);
		liabilities.add(1300.0);
		liabilities.add(1000.0);
		liabilities.add(1400.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResultDto apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(1569.18934438987, apvCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performApvCompanyValuationWithAllZeroAmounts() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(0.0);
		cashflows.add(0.0);
		cashflows.add(0.0);
		cashflows.add(0.0);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(0.0);
		liabilities.add(0.0);
		liabilities.add(0.0);
		liabilities.add(0.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResultDto apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(0, apvCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performApvCompanyValuationWithAllOnesAmounts() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(1.0);
		cashflows.add(1.0);
		cashflows.add(1.0);
		cashflows.add(1.0);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1.0);
		liabilities.add(1.0);
		liabilities.add(1.0);
		liabilities.add(1.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResultDto apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(9.248386764, apvCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	public void performApvCompanyValuationWithAllBillionsAmounts() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(1450000000.0);
		cashflows.add(1260000000.0);
		cashflows.add(3340000000.0);
		cashflows.add(1680000000.0);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1360000000.0);
		liabilities.add(1600000000.0);
		liabilities.add(2200000000.0);
		liabilities.add(1500000000.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResultDto apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(16504187818.2333000000, apvCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	public void performApvCompanyValuationWithNegativAmounts() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(176.76);
		cashflows.add(-520.13);
		cashflows.add(404.87);
		cashflows.add(-203.78);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(-1260.0);
		liabilities.add(-1300.0);
		liabilities.add(1000.0);
		liabilities.add(-1400.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResultDto apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(-601.6495353431, apvCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	public void performApvCompanyValuationWithSmallAmounts() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(1.12);
		cashflows.add(0.78);
		cashflows.add(0.56);
		cashflows.add(1.01);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(0.34);
		liabilities.add(1.2);
		liabilities.add(0.8);
		liabilities.add(0.51);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResultDto apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(9.4465325137, apvCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	public void performApvCompanyValuationWithDifferentTaxRates() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(176.76);
		cashflows.add(520.13);
		cashflows.add(404.87);
		cashflows.add(203.78);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1260.0);
		liabilities.add(1300.0);
		liabilities.add(1000.0);
		liabilities.add(1400.0);
		
		
		double equityInterest = 0.080722;
		double outsideCapitalInterest = 0.06;
		double corporateTax = 0.349;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResultDto apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(2146.60456861283, apvCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	public void performApvCompanyValuationWithThreePeriods() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(404.8692500000);
		cashflows.add(203.7832500000);

		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1300.00);
		liabilities.add(1400.00);

		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResultDto apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(1335.2312081890, apvCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	public void performApvCompanyValuationWithTenPeriods() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(3960.0);
		cashflows.add(4158.0);
		cashflows.add(4365.0);
		cashflows.add(4584.0);
		cashflows.add(4813.0);
		cashflows.add(5054.0);
		cashflows.add(4587.0);
		cashflows.add(5035.0);
		cashflows.add(4035.0);

		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1625.0);
		liabilities.add(1771.0);
		liabilities.add(1931.0);
		liabilities.add(2104.0);
		liabilities.add(2294.0);
		liabilities.add(2500.0);
		liabilities.add(1850.0);
		liabilities.add(2300.0);
		liabilities.add(2468.0);
		
		
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResultDto apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(41640.17149257649, apvCompanyValuationResult.getCompanyValue(), 0.1);
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
		
		double corporateTax = 0.3;
		double equityInterest = 0.09;
		double outsideCapitalInterest = 0.05;
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResultDto fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, equityInterest,
				outsideCapitalInterest, corporateTax);

		Assert.assertEquals(32146.0,fcfCompanyValuationResult.getCompanyValue(), 0.1);
	}
	@Test
	public void performFcfCompanyValuationwithBallwieserData() {

		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(138.61);
		cashflows.add(202.31);
		cashflows.add(174.41);
		cashflows.add(202.51);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1260.0);
		liabilities.add(1320.0);
		liabilities.add(1330.0);
		liabilities.add(1400.0);
		
		double equityInterest = 0.09969137;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.26325;
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResultDto fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, equityInterest,
				outsideCapitalInterest, corporateTax);

		Assert.assertEquals(1055.24,fcfCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performFcfCompanyValuationwithPohlData() {

		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(176.76);
		cashflows.add(520.13);
		cashflows.add(404.87);
		cashflows.add(203.78);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1260.0);
		liabilities.add(1300.0);
		liabilities.add(1000.0);
		liabilities.add(1400.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResultDto fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, equityInterest,
				outsideCapitalInterest, corporateTax);

		Assert.assertEquals(1569.18934438987,fcfCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performFcfCompanyValuationwithAllZeroAmounts() {

		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(0.0);
		cashflows.add(0.0);
		cashflows.add(0.0);
		cashflows.add(0.0);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(0.0);
		liabilities.add(0.0);
		liabilities.add(0.0);
		liabilities.add(0.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResultDto fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, equityInterest,
				outsideCapitalInterest, corporateTax);

		Assert.assertEquals(0,fcfCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performFcfCompanyValuationwithAllOnesAmounts() {

		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(1.0);
		cashflows.add(1.0);
		cashflows.add(1.0);
		cashflows.add(1.0);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1.0);
		liabilities.add(1.0);
		liabilities.add(1.0);
		liabilities.add(1.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResultDto fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, equityInterest,
				outsideCapitalInterest, corporateTax);

		Assert.assertEquals(9.248386764,fcfCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performFcfCompanyValuationwithAllBillionsAmounts() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(1450000000.0);
		cashflows.add(1260000000.0);
		cashflows.add(3340000000.0);
		cashflows.add(1680000000.0);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1360000000.0);
		liabilities.add(1600000000.0);
		liabilities.add(2200000000.0);
		liabilities.add(1500000000.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;
		
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResultDto fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, equityInterest,
				outsideCapitalInterest, corporateTax);

		Assert.assertEquals(16504187818.2333000000,fcfCompanyValuationResult.getCompanyValue(), 0.1);
	}

	@Test
	public void performFcfCompanyValuationwithNegativAmounts() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(176.76);
		cashflows.add(-520.13);
		cashflows.add(404.87);
		cashflows.add(-203.78);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(-1260.0);
		liabilities.add(-1300.0);
		liabilities.add(1000.0);
		liabilities.add(-1400.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResultDto fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, equityInterest,
				outsideCapitalInterest, corporateTax);

		Assert.assertEquals(-601.6495353431,fcfCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performFcfCompanyValuationWithSmallAmounts() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(1.12);
		cashflows.add(0.78);
		cashflows.add(0.56);
		cashflows.add(1.01);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(0.34);
		liabilities.add(1.2);
		liabilities.add(0.8);
		liabilities.add(0.51);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResultDto fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, equityInterest,
				outsideCapitalInterest, corporateTax);

		Assert.assertEquals(9.4465325137,fcfCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performFcfCompanyValuationWithDifferentTaxRates() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(176.76);
		cashflows.add(520.13);
		cashflows.add(404.87);
		cashflows.add(203.78);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1260.0);
		liabilities.add(1300.0);
		liabilities.add(1000.0);
		liabilities.add(1400.0);
		
		
		double equityInterest = 0.080722;
		double outsideCapitalInterest = 0.06;
		double corporateTax = 0.349;

		
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResultDto fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, equityInterest,
				outsideCapitalInterest, corporateTax);

		Assert.assertEquals(2146.60456861283,fcfCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performFcfCompanyValuationWithThreePeriods() {

		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(404.8692500000);
		cashflows.add(203.7832500000);

		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1300.00);
		liabilities.add(1400.00);

		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResultDto fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, equityInterest,
				outsideCapitalInterest, corporateTax);

		Assert.assertEquals(1335.2312081890,fcfCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performFcfCompanyValuationWithTenPeriods() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(3960.0);
		cashflows.add(4158.0);
		cashflows.add(4365.0);
		cashflows.add(4584.0);
		cashflows.add(4813.0);
		cashflows.add(5054.0);
		cashflows.add(4587.0);
		cashflows.add(5035.0);
		cashflows.add(4035.0);

		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1625.0);
		liabilities.add(1771.0);
		liabilities.add(1931.0);
		liabilities.add(2104.0);
		liabilities.add(2294.0);
		liabilities.add(2500.0);
		liabilities.add(1850.0);
		liabilities.add(2300.0);
		liabilities.add(2468.0);
		
		
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;
		
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResultDto fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, equityInterest,
				outsideCapitalInterest, corporateTax);

		Assert.assertEquals(41640.17149257649,fcfCompanyValuationResult.getCompanyValue(), 0.1);
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
		
		double equityInterest = 0.09969137;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.26325;

		CompanyValuationService valuationService = new CompanyValuationService();
		FteCompanyValuationResultDto fteCompanyValuationResult = valuationService.performFteCompanyValuationResult(
				cashflows, liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(1055.24, fteCompanyValuationResult.getCompanyValue(), 0.1);

	}
}
