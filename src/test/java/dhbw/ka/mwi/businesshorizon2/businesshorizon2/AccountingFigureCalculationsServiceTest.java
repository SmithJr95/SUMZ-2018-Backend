package dhbw.ka.mwi.businesshorizon2.businesshorizon2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services.AccountingFigureCalculationsService;

public class AccountingFigureCalculationsServiceTest {
	
	@Test
	public void calculateFreeCashFlow(){
		//Arrange
		AccountingFigureCalculationsService accountingService = new AccountingFigureCalculationsService();
		double expectedRes1 = 202.52;
		double expectedRes2 = 202.52;
		double expectedRes3 = 202.52;
		double expectedRes4 = 138.61;
		
		//Act
		double actualRes1 = accountingService.calculateFreeCashFlow(2000.0, 0, 1431.41, 0, 0, 280.0, 0.14, 0.15, 0.055, 280.0, 0.0);
		double actualRes2 = accountingService.calculateFreeCashFlow(0, 2000, 0, 1431.41, 0, 280, 0.14, 0.15, 0.055, 300, 20);
		double actualRes3 = accountingService.calculateFreeCashFlow(1500, 500, 0, 0, 1431.41, 280, 0.14, 0.15, 0.055, 300, 20);
		double actualRes4 = accountingService.calculateFreeCashFlow(2200, 0, 1459.98, 0, 0, 400, 0.14, 0.15, 0.055, 500, 0);
		
		//Assert
		assertEquals(expectedRes1, actualRes1, 0.1);
		assertEquals(expectedRes2, actualRes2, 0.1);
		assertEquals(expectedRes3, actualRes3, 0.1);
		assertEquals(expectedRes4, actualRes4, 0.1);
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
		
		Double[] freeCashFlow = new Double[]{138.61,202.31,174.41,202.51};
		Double[] liabilities = new Double[]{1260.0,1320.0,1330.0,1400.0,1400.0};
		Double interestOnLiabilities = 0.08;
		Double effectiveTaxRate = 0.26325;
		
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
