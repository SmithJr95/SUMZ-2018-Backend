package dhbw.ka.mwi.businesshorizon2.businesshorizon2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services.AccountingFigureCalculationsService;


public class AccountingFigureCalculationsServiceTest {
	

	
	
	@Test
	public void calculateFreeCashFlow(){
		//Arrange
		AccountingFigureCalculationsService accountingService = new AccountingFigureCalculationsService();
		List<Double> expectedRes1 = new ArrayList<>();
		expectedRes1.add(202.52);
		expectedRes1.add(202.52);
		expectedRes1.add(202.8);
		expectedRes1.add(138.61);

		List<Double> revenue = new ArrayList<>();
		revenue.add(2000.0);
		revenue.add(0.0);
		revenue.add(1500.0);
		revenue.add(2200.0);
		
		List<Double> additionalIncome = new ArrayList<>();
		additionalIncome.add(0.0);
		additionalIncome.add(2000.0);
		additionalIncome.add(500.0);
		additionalIncome.add(0.0);
		
		List<Double> costOfMaterial= new ArrayList<>();
		costOfMaterial.add(1431.41);
		costOfMaterial.add(0.0);
		costOfMaterial.add(0.0);
		costOfMaterial.add(1459.98);
		
		List<Double> costOfStaff= new ArrayList<>();
		costOfStaff.add(0.0);
		costOfStaff.add(1431.41);
		costOfStaff.add(0.0);
		costOfStaff.add(0.0);
		
		List<Double> additionalCost= new ArrayList<>();
		additionalCost.add(0.0);
		additionalCost.add(0.0);
		additionalCost.add(1431.0);
		additionalCost.add(0.0);
		
		List<Double> depreciation= new ArrayList<>();
		depreciation.add(280.0);
		depreciation.add(280.0);
		depreciation.add(280.0);
		depreciation.add(400.0);
		
		List<Double> investments= new ArrayList<>();
		investments.add(280.0);
		investments.add(300.0);
		investments.add(300.0);
		investments.add(500.0);
		
		List<Double> divestments= new ArrayList<>();
		divestments.add(0.0);
		divestments.add(20.0);
		divestments.add(20.0);
		divestments.add(0.0);
		
		
		//Act
		List<Double> actualRes1 = new ArrayList<>(); 
		actualRes1 = accountingService.calculateFreeCashFlow(revenue, additionalIncome, costOfMaterial, costOfStaff, additionalCost, depreciation, 
							0.14, 0.15, 0.055, investments, divestments);
		
		
		//Assert
		for (int i = 0; i < actualRes1.size();  i++) {
			Assert.assertEquals(expectedRes1.get(i), actualRes1.get(i),0.1);
		}

	}
	
	@Test
	public void calculateFlowToEquity() {
		//Arrange
		AccountingFigureCalculationsService accountingService = new AccountingFigureCalculationsService();
		double expectedRes = 220.0;
		
		double freeCashFlow = 202.52;
		double liabilities = 1400.00;
		double previousLiabilities = 1300.00;
		double interestOnLiabilities = 0.08;  
		double effectiveTaxRate =0.26325;
		
		//Act
		double actualRes = accountingService.calculateFlowToEquity(freeCashFlow, liabilities, previousLiabilities, interestOnLiabilities, effectiveTaxRate);
		
		//Assert
		assertEquals(expectedRes, actualRes, 0.01);
	}
	
	@Test
	public void calculateMultipleFlowToEquity1() {
		//Arrange
		AccountingFigureCalculationsService accountingService = new AccountingFigureCalculationsService();
		
		Double[] freeCashFlow = new Double[]{3960.0,4158.0,4365.0,4584.0,4813.0,5054.0,4587.0,5035.0,4035.0};
		Double[] liabilities = new Double[]{1625.0,1771.0,1931.0,2104.0,2294.0,2500.0,1850.0,2300.0,2468.0,2468.0};
		Double interestOnLiabilities = 0.08;
		Double effectiveTaxRate = 0.30625;
		
		//Act 
		Double[] fte = new Double[freeCashFlow.length];
		
		for (int i = 0; i < freeCashFlow.length; i++) {
			fte[i] = accountingService.calculateFlowToEquity(freeCashFlow[i], liabilities[i+1], liabilities[i], interestOnLiabilities, effectiveTaxRate);
			System.out.println("cashflows.add(" + fte[i] + ");");
		}
	}
	
	@Test
	public void calculateMultipleFlowToEquity2() {
		//Arrange
		AccountingFigureCalculationsService accountingService = new AccountingFigureCalculationsService();
		
		Double[] freeCashFlow = new Double[]{176.76,520.13,404.87,203.78};
		Double[] liabilities = new Double[]{1260.0,1300.0,1000.0,1400.0,1400.0};
		Double interestOnLiabilities = 0.08;
		Double effectiveTaxRate = 0.30625;
		
		//Act 
		Double[] fte = new Double[freeCashFlow.length];
		
		for (int i = 0; i < freeCashFlow.length; i++) {
			fte[i] = accountingService.calculateFlowToEquity(freeCashFlow[i], liabilities[i+1], liabilities[i], interestOnLiabilities, effectiveTaxRate);
			System.out.println("cashflows.add(" + fte[i] + ");");
		}
	}
	
	@Test
	public void calculateEffectiveTaxRate() {
		//Arrange
		AccountingFigureCalculationsService accountingService = new AccountingFigureCalculationsService();
		double expectedRes = 0.26325;
		
		double businessTaxRate = 0.14;
		double corporateTaxRate = 0.15;
		double solidaryTaxRate = 0.055;
		
		//Act
		double actualRes = accountingService.calculateEffectiveTaxRate(businessTaxRate, corporateTaxRate, solidaryTaxRate);
		
		//Assert
		assertEquals(expectedRes, actualRes, 0.0001);
	}
}
