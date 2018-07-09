package dhbw.ka.mwi.businesshorizon2.businesshorizon2.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.dhbw.ka.mwi.businesshorizon2.App;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.MultiPeriodAccountingFigureRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioPostRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemDateRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class ScenarioPostRequestDtoTest {
	
	@Autowired
    private Validator validator;
	
	private ScenarioPostRequestDto validRequest;
	
	@Before
	public void setup() {
		ScenarioPostRequestDto request = new ScenarioPostRequestDto();
		request.setScenarioName("xyz");
		request.setScenarioDescription("xyz");
		request.setPeriods(2);
		request.setBusinessTaxRate(0.5);
		request.setCorporateTaxRate(0.5);
		request.setSolidaryTaxRate(0.5);
		request.setEquityInterestRate(0.5);
		request.setInterestOnLiabilitiesRate(0.3);
	
		List<TimeSeriesItemRequestDto> freeCashFlowsTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 4), 50.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2001, 1), 60.0));
		
		List<TimeSeriesItemRequestDto> liabilitiesTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 4), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2001, 1), 60.0));

		List<TimeSeriesItemRequestDto> interestOnLiabilitiesTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		interestOnLiabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 4), 50.0));
		interestOnLiabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2001, 1), 60.0));
		
		MultiPeriodAccountingFigureRequestDto freeCashFlows = new MultiPeriodAccountingFigureRequestDto();
		freeCashFlows.setIsHistoric(true);
		freeCashFlows.setTimeSeries(freeCashFlowsTimeSeries);
		
		MultiPeriodAccountingFigureRequestDto liabilities = new MultiPeriodAccountingFigureRequestDto();
		liabilities.setIsHistoric(true);
		liabilities.setTimeSeries(liabilitiesTimeSeries);
		
		request.setFreeCashFlows(freeCashFlows);
		request.setLiabilities(liabilities);
		
		this.validRequest = request;
	}
	
	@Test
	public void validation_allValid_noViolations() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertEquals(0, violations.size());
	}
	
	@Test
	public void validation_scenarioNameNull_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setScenarioName(null);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_scenarioNameLengthLessThanMinLength_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setScenarioName("");
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_scenarioNameLengthGreaterThanMaxLength_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setScenarioName("sssssssssssssssssssss");
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_scenarioDescriptionNull_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setScenarioDescription(null);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_scenarioDescriptionLengthBelowMinLength_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setScenarioDescription("");
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_scenarioDescriptionLengthAboveMaxLength_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setScenarioDescription("fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_periodsNull_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setPeriods(null);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_periodsLessThanMinValue_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setPeriods(1);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_interestOnLiabilitiesRateNull_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setInterestOnLiabilitiesRate(null);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_interestOnLiabilitiesBelowMinValue_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setInterestOnLiabilitiesRate(-0.01);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_interestOnLiabilitiesAboveMaxValue_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setInterestOnLiabilitiesRate(1.01);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_businessTaxRateNull_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setBusinessTaxRate(null);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_businessTaxRateLessThanMinValue_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setBusinessTaxRate(-0.1);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_businessTaxRateGreaterThanMaxValue_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setBusinessTaxRate(1.01);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_corporateTaxRateNull_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setCorporateTaxRate(null);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_corporateTaxRateLessThanMinValue_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setCorporateTaxRate(-0.1);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_corporateTaxRateGreaterThanMaxValue_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setCorporateTaxRate(1.01);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_solidaryTaxRateNull_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setSolidaryTaxRate(null);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_solidaryTaxRateLessThanMinValue_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setSolidaryTaxRate(-0.1);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_solidaryTaxRateGreaterThanMaxValue_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setSolidaryTaxRate(1.01);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_equityInterestRateNull_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setEquityInterestRate(null);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_equityInterestRateLessThanMinValue_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setEquityInterestRate(-0.11);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_equityInterestRateGreaterThanMaxValue_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setEquityInterestRate(1.01);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_isHistoricNull_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.getLiabilities().setIsHistoric(null);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_timeSeriesNull_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.getLiabilities().setTimeSeries(null);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_timeSeriesDateNull_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.getLiabilities().getTimeSeries().get(0).setDate(null);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_timeSeriesDateYearNull_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.getLiabilities().getTimeSeries().get(0).getDate().setYear(null);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_timeSeriesDateYearLessThanMinValue_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.getLiabilities().getTimeSeries().get(0).getDate().setYear(1899);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_timeSeriesDateYearGreaterThanMaxValue_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.getLiabilities().getTimeSeries().get(0).getDate().setYear(2101);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_timeSeriesDateQuarterOutisdeRange_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.getLiabilities().getTimeSeries().get(0).getDate().setQuarter(0);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_timeSeriesAmountNull_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.getLiabilities().getTimeSeries().get(0).setAmount(null);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_timeSeriesYearQuarterNotContinuous_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		
		List<TimeSeriesItemRequestDto> liabilitiesTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 4), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 2), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2001, 1), 60.0));
		
		request.getLiabilities().setTimeSeries(liabilitiesTimeSeries);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_timeSeriesYearNotContinuous_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		
		List<TimeSeriesItemRequestDto> freeCashFlowsTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000), 50.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2001), 60.0));
		
		List<TimeSeriesItemRequestDto> liabilitiesTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(1999), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2001), 60.0));
		
		request.getFreeCashFlows().setTimeSeries(freeCashFlowsTimeSeries);
		request.getLiabilities().setTimeSeries(liabilitiesTimeSeries);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_timeSeriesDateFormatNotConsistent_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
	
		List<TimeSeriesItemRequestDto> liabilitiesTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2001), 60.0));
		
		request.getLiabilities().setTimeSeries(liabilitiesTimeSeries);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_invalidAccountingFigureCombination_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		
		List<TimeSeriesItemRequestDto> costOfStaffTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		costOfStaffTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 4), 50.0));
		costOfStaffTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2001, 1), 60.0));
		
		MultiPeriodAccountingFigureRequestDto costOfStaff = new MultiPeriodAccountingFigureRequestDto();
		costOfStaff.setIsHistoric(true);
		costOfStaff.setTimeSeries(costOfStaffTimeSeries);
		
		request.setCostOfStaff(costOfStaff);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_historicSeriesTooShort_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		
		List<TimeSeriesItemRequestDto> freeCashFlowsTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2001, 1), 60.0));
		
		request.getFreeCashFlows().setTimeSeries(freeCashFlowsTimeSeries);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_historicSeriesNotAlignedTooLate_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		
		List<TimeSeriesItemRequestDto> freeCashFlowsTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2001, 1), 60.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2001, 2), 60.0));
		
		request.getFreeCashFlows().setTimeSeries(freeCashFlowsTimeSeries);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_historicSeriesNotAlignedTooEarly_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		
		List<TimeSeriesItemRequestDto> freeCashFlowsTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 4), 60.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 3), 60.0));
		
		request.getFreeCashFlows().setTimeSeries(freeCashFlowsTimeSeries);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_futureSeriesTooShort_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		
		List<TimeSeriesItemRequestDto> freeCashFlowsTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 4), 50.0));
		
		List<TimeSeriesItemRequestDto> liabilitiesTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 3), 50.0));
		
		MultiPeriodAccountingFigureRequestDto freeCashFlows = new MultiPeriodAccountingFigureRequestDto();
		freeCashFlows.setIsHistoric(false);
		freeCashFlows.setTimeSeries(freeCashFlowsTimeSeries);
		
		MultiPeriodAccountingFigureRequestDto liabilities = new MultiPeriodAccountingFigureRequestDto();
		liabilities.setIsHistoric(false);
		liabilities.setTimeSeries(liabilitiesTimeSeries);
		
		request.setFreeCashFlows(freeCashFlows);
		request.setLiabilities(liabilities);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_futureSeriesNotAlignedTooEarly_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		
		List<TimeSeriesItemRequestDto> freeCashFlowsTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2001, 1), 60.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2001, 2), 60.0));
		
		List<TimeSeriesItemRequestDto> liabilitiesTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 3), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 4), 50.0));
		
		MultiPeriodAccountingFigureRequestDto freeCashFlows = new MultiPeriodAccountingFigureRequestDto();
		freeCashFlows.setIsHistoric(false);
		freeCashFlows.setTimeSeries(freeCashFlowsTimeSeries);
		
		MultiPeriodAccountingFigureRequestDto liabilities = new MultiPeriodAccountingFigureRequestDto();
		liabilities.setIsHistoric(false);
		liabilities.setTimeSeries(liabilitiesTimeSeries);
		
		request.setFreeCashFlows(freeCashFlows);
		request.setLiabilities(liabilities);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);

		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_futureSeriesTooLong_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		
		List<TimeSeriesItemRequestDto> freeCashFlowsTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 4), 50.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2001, 1), 60.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2001, 2), 60.0));
		
		List<TimeSeriesItemRequestDto> liabilitiesTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 3), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 4), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2001, 1), 60.0));
		
		MultiPeriodAccountingFigureRequestDto freeCashFlows = new MultiPeriodAccountingFigureRequestDto();
		freeCashFlows.setIsHistoric(false);
		freeCashFlows.setTimeSeries(freeCashFlowsTimeSeries);
		
		MultiPeriodAccountingFigureRequestDto liabilities = new MultiPeriodAccountingFigureRequestDto();
		liabilities.setIsHistoric(false);
		liabilities.setTimeSeries(liabilitiesTimeSeries);
		
		request.setFreeCashFlows(freeCashFlows);
		request.setLiabilities(liabilities);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);

		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_futureSeriesNotAlignedTooLate_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		
		List<TimeSeriesItemRequestDto> freeCashFlowsTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2001, 1), 60.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2001, 2), 60.0));
		
		List<TimeSeriesItemRequestDto> liabilitiesTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2001, 1), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2001, 2), 50.0));
		
		MultiPeriodAccountingFigureRequestDto freeCashFlows = new MultiPeriodAccountingFigureRequestDto();
		freeCashFlows.setIsHistoric(false);
		freeCashFlows.setTimeSeries(freeCashFlowsTimeSeries);
		
		MultiPeriodAccountingFigureRequestDto liabilities = new MultiPeriodAccountingFigureRequestDto();
		liabilities.setIsHistoric(false);
		liabilities.setTimeSeries(liabilitiesTimeSeries);
		
		request.setFreeCashFlows(freeCashFlows);
		request.setLiabilities(liabilities);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);

		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_futureAndHistoricSeriesAlignedDateFormatYear_notViolationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = new ScenarioPostRequestDto();
		request.setScenarioName("xyz");
		request.setScenarioDescription("xyz");
		request.setPeriods(4);
		request.setBusinessTaxRate(0.5);
		request.setCorporateTaxRate(0.5);
		request.setSolidaryTaxRate(0.5);
		request.setEquityInterestRate(0.5);
		request.setInterestOnLiabilitiesRate(0.5);
		
		List<TimeSeriesItemRequestDto> freeCashFlowsTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000), 50.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2001), 60.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2002), 60.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2003), 60.0));
		
		List<TimeSeriesItemRequestDto> liabilitiesTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(1999), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000), 60.0));
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2001), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2002), 60.0));
		
		MultiPeriodAccountingFigureRequestDto freeCashFlows = new MultiPeriodAccountingFigureRequestDto();
		freeCashFlows.setIsHistoric(false);
		freeCashFlows.setTimeSeries(freeCashFlowsTimeSeries);
		
		MultiPeriodAccountingFigureRequestDto liabilities = new MultiPeriodAccountingFigureRequestDto();
		liabilities.setIsHistoric(false);
		liabilities.setTimeSeries(liabilitiesTimeSeries);
		
		request.setFreeCashFlows(freeCashFlows);
		request.setLiabilities(liabilities);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);

		//Assert
		assertTrue(violations.isEmpty());
	}
	
	@Test
	public void validation_futureAndHistoricSeriesAlignedDateFormatYearQuarter1_notViolationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = new ScenarioPostRequestDto();
		request.setScenarioName("xyz");
		request.setScenarioDescription("xyz");
		request.setPeriods(4);
		request.setBusinessTaxRate(0.5);
		request.setCorporateTaxRate(0.5);
		request.setSolidaryTaxRate(0.5);
		request.setEquityInterestRate(0.5);
		request.setInterestOnLiabilitiesRate(0.5);
		
		List<TimeSeriesItemRequestDto> freeCashFlowsTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(1999, 4), 50.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 1), 60.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 2), 60.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 3), 60.0));
		
		List<TimeSeriesItemRequestDto> liabilitiesTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(1999, 4), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 1), 60.0));
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 2), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 3), 60.0));
		
		MultiPeriodAccountingFigureRequestDto freeCashFlows = new MultiPeriodAccountingFigureRequestDto();
		freeCashFlows.setIsHistoric(true);
		freeCashFlows.setTimeSeries(freeCashFlowsTimeSeries);
		
		MultiPeriodAccountingFigureRequestDto liabilities = new MultiPeriodAccountingFigureRequestDto();
		liabilities.setIsHistoric(true);
		liabilities.setTimeSeries(liabilitiesTimeSeries);
		
		request.setFreeCashFlows(freeCashFlows);
		request.setLiabilities(liabilities);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);

		//Assert
		assertTrue(violations.isEmpty());
	}
	
	@Test
	public void validation_futureAndHistoricSeriesAlignedDateFormatYearQuarter2_notViolationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = new ScenarioPostRequestDto();
		request.setScenarioName("xyz");
		request.setScenarioDescription("xyz");
		request.setPeriods(2);
		request.setBusinessTaxRate(0.5);
		request.setCorporateTaxRate(0.5);
		request.setSolidaryTaxRate(0.5);
		request.setEquityInterestRate(0.5);
		request.setInterestOnLiabilitiesRate(0.5);
				
		List<TimeSeriesItemRequestDto> liabilitiesTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 1), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 2), 50.0));
		MultiPeriodAccountingFigureRequestDto liabilities = new MultiPeriodAccountingFigureRequestDto();
		liabilities.setIsHistoric(false);
		liabilities.setTimeSeries(liabilitiesTimeSeries);
		
		List<TimeSeriesItemRequestDto> depreciationTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		depreciationTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 2), 50.0));
		depreciationTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 3), 50.0));
		MultiPeriodAccountingFigureRequestDto depreciation = new MultiPeriodAccountingFigureRequestDto();
		depreciation.setIsHistoric(false);
		depreciation.setTimeSeries(depreciationTimeSeries);
		
		List<TimeSeriesItemRequestDto> additionalIncomeTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		additionalIncomeTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 2), 50.0));
		additionalIncomeTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 3), 50.0));
		MultiPeriodAccountingFigureRequestDto additionalIncome = new MultiPeriodAccountingFigureRequestDto();
		additionalIncome.setIsHistoric(false);
		additionalIncome.setTimeSeries(additionalIncomeTimeSeries);
		
		List<TimeSeriesItemRequestDto> additionalCostsTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		additionalCostsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(1999, 4), 50.0));
		additionalCostsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 1), 50.0));
		MultiPeriodAccountingFigureRequestDto additionalCosts = new MultiPeriodAccountingFigureRequestDto();
		additionalCosts.setIsHistoric(true);
		additionalCosts.setTimeSeries(additionalCostsTimeSeries);
		
		List<TimeSeriesItemRequestDto> investmentsTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		investmentsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 2), 50.0));
		investmentsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 3), 50.0));
		MultiPeriodAccountingFigureRequestDto investments = new MultiPeriodAccountingFigureRequestDto();
		investments.setIsHistoric(false);
		investments.setTimeSeries(investmentsTimeSeries);
		
		List<TimeSeriesItemRequestDto> divestmentsTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		divestmentsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 2), 50.0));
		divestmentsTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 3), 50.0));
		MultiPeriodAccountingFigureRequestDto divestments = new MultiPeriodAccountingFigureRequestDto();
		divestments.setIsHistoric(false);
		divestments.setTimeSeries(divestmentsTimeSeries);
		
		List<TimeSeriesItemRequestDto> revenueTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		revenueTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 2), 50.0));
		revenueTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 3), 50.0));
		MultiPeriodAccountingFigureRequestDto revenue = new MultiPeriodAccountingFigureRequestDto();
		revenue.setIsHistoric(false);
		revenue.setTimeSeries(revenueTimeSeries);
		
		List<TimeSeriesItemRequestDto> costOfMaterialTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		costOfMaterialTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(1999, 4), 50.0));
		costOfMaterialTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 1), 50.0));
		MultiPeriodAccountingFigureRequestDto costOfMaterial = new MultiPeriodAccountingFigureRequestDto();
		costOfMaterial.setIsHistoric(true);
		costOfMaterial.setTimeSeries(costOfMaterialTimeSeries);
		
		List<TimeSeriesItemRequestDto> costOfStaffTimeSeries = new ArrayList<TimeSeriesItemRequestDto>();
		costOfStaffTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(1999, 4), 50.0));
		costOfStaffTimeSeries.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 1), 50.0));
		MultiPeriodAccountingFigureRequestDto costOfStaff = new MultiPeriodAccountingFigureRequestDto();
		costOfStaff.setIsHistoric(true);
		costOfStaff.setTimeSeries(costOfStaffTimeSeries);
		
		request.setLiabilities(liabilities);
		request.setAdditionalCosts(additionalCosts);
		request.setAdditionalIncome(additionalIncome);
		request.setCostOfMaterial(costOfMaterial);
		request.setCostOfStaff(costOfStaff);
		request.setDepreciation(depreciation);
		request.setDivestments(divestments);
		request.setInvestments(investments);
		request.setRevenue(revenue);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		System.out.println(violations);
		
		//Assert
		assertTrue(violations.isEmpty());
	}
}
