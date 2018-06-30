package dhbw.ka.mwi.businesshorizon2.businesshorizon2;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services.FTECalculationService;

public class FTECalculationTest {

	/**
	 * @param freeCashFlow
	 * @param liabilities
	 * @param previousLiabilities
	 * @param interestOnLiabilities
	 * @param effectiveTaxRate
	 * @return
	 */
	@Test
	public void test() {
		
		
		FTECalculationService fteCalculation = new FTECalculationService();
		
		assertEquals(220, fteCalculation.calculateFlowToEquity(202.52, 500.0, 400.0, 112.0, 0.26325), 0.1);
		
		assertEquals(220, fteCalculation.calculateFlowToEquity(202.52, 500.0, 400.0, 112.0, 0.26325), 0.1);
	}

}
