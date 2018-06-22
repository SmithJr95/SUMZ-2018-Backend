package dhbw.ka.mwi.businesshorizon2.businesshorizon2;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services.FTECalculationService;

public class FTECalculationTest {

	
	@Test
	public void test() {
		/**
		 * @param proceeds = Einzahlungen
		 * @param payments = Auszahlungen 
		 * @param deprication = Abschreibung
		 * @param businessTax = Gewerbesteuersatz
		 * @param corporationTax = Körperschaftssteuersatz
		 * @param solidaryTax = Solidaritätszuschlag
		 * @param investments = getätigte Investitionen
		 * @param proceedsFromDeinvestments = Einzahlungen aus Desinvestitionen
		 * @param interest = Zinsen --> paid interests
		 * @param previousForeignCapital --> foreign capital at the end of the previous period
		 * @param foreignCapital --> foreign capital at the end of the relevant period
		 */
		FTECalculationService FTECalculationTest = new FTECalculationService(2000,1431.41,280,0.14,0.15,0.055, 280, 0, 112, 400, 500);
		
		//Test Taxshield	
		assertEquals(29.48, FTECalculationTest.getTaxShield(), 0.01);
		
		//Test Total Cash Flow
		assertEquals(232, FTECalculationTest.getTotalCF(), 0.01);
		
		//Test Flow to Equity 
		assertEquals(220, FTECalculationTest.getFlowToEquity(), 0.01);
		
	}

}
