package dhbw.ka.mwi.businesshorizon2.businesshorizon2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Assert;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services.CashflowCalculationService;

public class CashflowCalculationTest {

	
	
	
	
	@Test
	public void test(){
		/**
		 * @param proceeds = Einzahlungen
		 * @param payments = Auszahlungen 
		 * @param depreciation = Abschreibung
		 * @param businessTaxRate = Gewerbesteuersatz
		 * @param corporateTax = Körperschaftssteuersatz
		 * @param solidaryTaxRate = Solidaritätszuschlag
		 * @param interest = gezahlte Zinsen (absolut)
		 * @param investments = getätigte Investitionen
		 * @param divestments = Einzahlungen aus Desinvestitionen
		 */
		CashflowCalculationService cashflowCalculation = new CashflowCalculationService(2000.0, 1431.41, 280.0, 0.14, 0.15, 0.055, 280.0, 0.0);
		
		
		// Test Cashflow
		assertEquals(568.59, cashflowCalculation.getCf(), 0.1);
		
		// Test EBIT calc.
		assertEquals(288.59, cashflowCalculation.calculateEBIT(568.59, 280), 0.1);
		System.out.println(cashflowCalculation.calculateEBIT(568.59, 280));
		
		
		// Test operating Cashflow
		assertEquals(482.52, cashflowCalculation.getOperatingCF(), 0.1);
		//Test free Cashflow
		assertEquals(202.52, cashflowCalculation.getFreeCF(), 0.1);

		
	}
	
	
	
}
