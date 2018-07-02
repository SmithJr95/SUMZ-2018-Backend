package dhbw.ka.mwi.businesshorizon2.businesshorizon2.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.dhbw.ka.mwi.businesshorizon2.App;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigure;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.TimeSeriesItem;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.TimeSeriesItemDate;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioPostRequestDto;

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
	
		List<TimeSeriesItem> freeCashFlowsTimeSeries = new ArrayList<TimeSeriesItem>();
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 4), 50.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2001, 1), 60.0));
		
		List<TimeSeriesItem> liabilitiesTimeSeries = new ArrayList<TimeSeriesItem>();
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 4), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2001, 1), 60.0));

		List<TimeSeriesItem> interestOnLiabilitiesTimeSeries = new ArrayList<TimeSeriesItem>();
		interestOnLiabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 4), 50.0));
		interestOnLiabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2001, 1), 60.0));
		
		MultiPeriodAccountingFigure freeCashFlows = new MultiPeriodAccountingFigure();
		freeCashFlows.setIsHistoric(true);
		freeCashFlows.setTimeSeries(freeCashFlowsTimeSeries);
		
		MultiPeriodAccountingFigure liabilities = new MultiPeriodAccountingFigure();
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
		request.setPeriods(0);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_periodsGreaterThanMaxValue_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setPeriods(11);
		
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
		
		List<TimeSeriesItem> liabilitiesTimeSeries = new ArrayList<TimeSeriesItem>();
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 4), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 2), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2001, 1), 60.0));
		
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
		
		List<TimeSeriesItem> freeCashFlowsTimeSeries = new ArrayList<TimeSeriesItem>();
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000), 50.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2001), 60.0));
		
		List<TimeSeriesItem> liabilitiesTimeSeries = new ArrayList<TimeSeriesItem>();
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(1999), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2001), 60.0));
		
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
	
		List<TimeSeriesItem> liabilitiesTimeSeries = new ArrayList<TimeSeriesItem>();
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2001), 60.0));
		
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
		
		List<TimeSeriesItem> costOfStaffTimeSeries = new ArrayList<TimeSeriesItem>();
		costOfStaffTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 4), 50.0));
		costOfStaffTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2001, 1), 60.0));
		
		MultiPeriodAccountingFigure costOfStaff = new MultiPeriodAccountingFigure();
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
		
		List<TimeSeriesItem> freeCashFlowsTimeSeries = new ArrayList<TimeSeriesItem>();
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2001, 1), 60.0));
		
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
		
		List<TimeSeriesItem> freeCashFlowsTimeSeries = new ArrayList<TimeSeriesItem>();
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2001, 1), 60.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2001, 2), 60.0));
		
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
		
		List<TimeSeriesItem> freeCashFlowsTimeSeries = new ArrayList<TimeSeriesItem>();
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 4), 60.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 3), 60.0));
		
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
		
		List<TimeSeriesItem> freeCashFlowsTimeSeries = new ArrayList<TimeSeriesItem>();
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 4), 50.0));
		
		List<TimeSeriesItem> liabilitiesTimeSeries = new ArrayList<TimeSeriesItem>();
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 3), 50.0));
		
		MultiPeriodAccountingFigure freeCashFlows = new MultiPeriodAccountingFigure();
		freeCashFlows.setIsHistoric(false);
		freeCashFlows.setTimeSeries(freeCashFlowsTimeSeries);
		
		MultiPeriodAccountingFigure liabilities = new MultiPeriodAccountingFigure();
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
		
		List<TimeSeriesItem> freeCashFlowsTimeSeries = new ArrayList<TimeSeriesItem>();
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2001, 1), 60.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2001, 2), 60.0));
		
		List<TimeSeriesItem> liabilitiesTimeSeries = new ArrayList<TimeSeriesItem>();
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 3), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 4), 50.0));
		
		MultiPeriodAccountingFigure freeCashFlows = new MultiPeriodAccountingFigure();
		freeCashFlows.setIsHistoric(false);
		freeCashFlows.setTimeSeries(freeCashFlowsTimeSeries);
		
		MultiPeriodAccountingFigure liabilities = new MultiPeriodAccountingFigure();
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
		
		List<TimeSeriesItem> freeCashFlowsTimeSeries = new ArrayList<TimeSeriesItem>();
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 4), 50.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2001, 1), 60.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2001, 2), 60.0));
		
		List<TimeSeriesItem> liabilitiesTimeSeries = new ArrayList<TimeSeriesItem>();
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 3), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 4), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2001, 1), 60.0));
		
		MultiPeriodAccountingFigure freeCashFlows = new MultiPeriodAccountingFigure();
		freeCashFlows.setIsHistoric(false);
		freeCashFlows.setTimeSeries(freeCashFlowsTimeSeries);
		
		MultiPeriodAccountingFigure liabilities = new MultiPeriodAccountingFigure();
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
		
		List<TimeSeriesItem> freeCashFlowsTimeSeries = new ArrayList<TimeSeriesItem>();
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2001, 1), 60.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2001, 2), 60.0));
		
		List<TimeSeriesItem> liabilitiesTimeSeries = new ArrayList<TimeSeriesItem>();
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2001, 1), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2001, 2), 50.0));
		
		MultiPeriodAccountingFigure freeCashFlows = new MultiPeriodAccountingFigure();
		freeCashFlows.setIsHistoric(false);
		freeCashFlows.setTimeSeries(freeCashFlowsTimeSeries);
		
		MultiPeriodAccountingFigure liabilities = new MultiPeriodAccountingFigure();
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
		
		List<TimeSeriesItem> freeCashFlowsTimeSeries = new ArrayList<TimeSeriesItem>();
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000), 50.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2001), 60.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2002), 60.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2003), 60.0));
		
		List<TimeSeriesItem> liabilitiesTimeSeries = new ArrayList<TimeSeriesItem>();
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(1999), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000), 60.0));
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2001), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2002), 60.0));
		
		MultiPeriodAccountingFigure freeCashFlows = new MultiPeriodAccountingFigure();
		freeCashFlows.setIsHistoric(false);
		freeCashFlows.setTimeSeries(freeCashFlowsTimeSeries);
		
		MultiPeriodAccountingFigure liabilities = new MultiPeriodAccountingFigure();
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
		
		List<TimeSeriesItem> freeCashFlowsTimeSeries = new ArrayList<TimeSeriesItem>();
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(1999, 4), 50.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 1), 60.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 2), 60.0));
		freeCashFlowsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 3), 60.0));
		
		List<TimeSeriesItem> liabilitiesTimeSeries = new ArrayList<TimeSeriesItem>();
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(1999, 4), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 1), 60.0));
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 2), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 3), 60.0));
		
		MultiPeriodAccountingFigure freeCashFlows = new MultiPeriodAccountingFigure();
		freeCashFlows.setIsHistoric(true);
		freeCashFlows.setTimeSeries(freeCashFlowsTimeSeries);
		
		MultiPeriodAccountingFigure liabilities = new MultiPeriodAccountingFigure();
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
				
		List<TimeSeriesItem> liabilitiesTimeSeries = new ArrayList<TimeSeriesItem>();
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 1), 50.0));
		liabilitiesTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 2), 50.0));
		MultiPeriodAccountingFigure liabilities = new MultiPeriodAccountingFigure();
		liabilities.setIsHistoric(false);
		liabilities.setTimeSeries(liabilitiesTimeSeries);
		
		List<TimeSeriesItem> depreciationTimeSeries = new ArrayList<TimeSeriesItem>();
		depreciationTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 2), 50.0));
		depreciationTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 3), 50.0));
		MultiPeriodAccountingFigure depreciation = new MultiPeriodAccountingFigure();
		depreciation.setIsHistoric(false);
		depreciation.setTimeSeries(depreciationTimeSeries);
		
		List<TimeSeriesItem> additionalIncomeTimeSeries = new ArrayList<TimeSeriesItem>();
		additionalIncomeTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 2), 50.0));
		additionalIncomeTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 3), 50.0));
		MultiPeriodAccountingFigure additionalIncome = new MultiPeriodAccountingFigure();
		additionalIncome.setIsHistoric(false);
		additionalIncome.setTimeSeries(additionalIncomeTimeSeries);
		
		List<TimeSeriesItem> additionalCostsTimeSeries = new ArrayList<TimeSeriesItem>();
		additionalCostsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(1999, 4), 50.0));
		additionalCostsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 1), 50.0));
		MultiPeriodAccountingFigure additionalCosts = new MultiPeriodAccountingFigure();
		additionalCosts.setIsHistoric(true);
		additionalCosts.setTimeSeries(additionalCostsTimeSeries);
		
		List<TimeSeriesItem> investmentsTimeSeries = new ArrayList<TimeSeriesItem>();
		investmentsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 2), 50.0));
		investmentsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 3), 50.0));
		MultiPeriodAccountingFigure investments = new MultiPeriodAccountingFigure();
		investments.setIsHistoric(false);
		investments.setTimeSeries(investmentsTimeSeries);
		
		List<TimeSeriesItem> divestmentsTimeSeries = new ArrayList<TimeSeriesItem>();
		divestmentsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 2), 50.0));
		divestmentsTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 3), 50.0));
		MultiPeriodAccountingFigure divestments = new MultiPeriodAccountingFigure();
		divestments.setIsHistoric(false);
		divestments.setTimeSeries(divestmentsTimeSeries);
		
		List<TimeSeriesItem> revenueTimeSeries = new ArrayList<TimeSeriesItem>();
		revenueTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 2), 50.0));
		revenueTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 3), 50.0));
		MultiPeriodAccountingFigure revenue = new MultiPeriodAccountingFigure();
		revenue.setIsHistoric(false);
		revenue.setTimeSeries(revenueTimeSeries);
		
		List<TimeSeriesItem> costOfMaterialTimeSeries = new ArrayList<TimeSeriesItem>();
		costOfMaterialTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(1999, 4), 50.0));
		costOfMaterialTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 1), 50.0));
		MultiPeriodAccountingFigure costOfMaterial = new MultiPeriodAccountingFigure();
		costOfMaterial.setIsHistoric(true);
		costOfMaterial.setTimeSeries(costOfMaterialTimeSeries);
		
		List<TimeSeriesItem> costOfStaffTimeSeries = new ArrayList<TimeSeriesItem>();
		costOfStaffTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(1999, 4), 50.0));
		costOfStaffTimeSeries.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 1), 50.0));
		MultiPeriodAccountingFigure costOfStaff = new MultiPeriodAccountingFigure();
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
