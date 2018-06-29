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
		request.setPeriods(5);
		request.setBusinessTaxRate(50.0);
		request.setCorporateTaxRate(50.0);
		request.setSolidaryTaxRate(50.0);
		request.setCostOfEquity(50.0);
	
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
		
		MultiPeriodAccountingFigure interestOnLiabilities = new MultiPeriodAccountingFigure();
		interestOnLiabilities.setIsHistoric(true);
		interestOnLiabilities.setTimeSeries(interestOnLiabilitiesTimeSeries);
		
		request.setFreeCashFlows(freeCashFlows);
		request.setInterestOnLiabilities(interestOnLiabilities);
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
		request.setBusinessTaxRate(-1.0);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_businessTaxRateGreaterThanMaxValue_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setBusinessTaxRate(100.01);
		
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
		request.setCorporateTaxRate(-1.0);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_corporateTaxRateGreaterThanMaxValue_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setCorporateTaxRate(100.01);
		
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
		request.setSolidaryTaxRate(-1.0);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_solidaryTaxRateGreaterThanMaxValue_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setSolidaryTaxRate(100.01);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_costOfEquityNull_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setCostOfEquity(null);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_costOfEquityLessThanMinValue_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setCostOfEquity(-1.0);
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertTrue(violations.size() > 0);
	}
	
	@Test
	public void validation_costOfEquityGreaterThanMaxValue_violationsExist() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = this.validRequest;
		request.setCostOfEquity(1000.01);
		
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
	
}
