package dhbw.ka.mwi.businesshorizon2.businesshorizon2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Assert;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services.CashFlowCalculationService;

public class CashFlowCalculationTest {

	
	
	
	
	@Test
	public void test(){
		/**
		 * @param revenue
		 * @param additionalIncome
		 * @param costOfMaterial
		 * @param costOfStaff
		 * @param additionalCosts
		 * @param depreciation
		 * @param businessTaxRate
		 * @param corporateTaxRate
		 * @param solidaryTaxRate
		 * @param investments
		 * @param divestments
		 * @return
		 */
		CashFlowCalculationService cashflowCalculation = new CashFlowCalculationService();
		// 2000.0, 1431.41, 280.0, 0.14, 0.15, 0.055, 280.0, 0.0
		
		// Test Cashflow
		assertEquals(202.52, cashflowCalculation.calculateFreeCashFlow(2000.0, 0, 1431.41, 0, 0, 280.0, 0.14, 0.15, 0.055, 280.0, 0.0), 0.1);
		
		assertEquals(202.52, cashflowCalculation.calculateFreeCashFlow(0, 2000, 0, 1431.41, 0, 280, 0.14, 0.15, 0.055, 300, 20), 0.1);
		
		assertEquals(202.52, cashflowCalculation.calculateFreeCashFlow(1500, 500, 0, 0, 1431.41, 280, 0.14, 0.15, 0.055, 300, 20), 0.1);
		
		assertEquals(138.61, cashflowCalculation.calculateFreeCashFlow(2200, 0, 1459.98, 0, 0, 400, 0.14, 0.15, 0.055, 500, 0), 0.1);
		

	}
	
	
	
}
