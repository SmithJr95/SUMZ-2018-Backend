package dhbw.ka.mwi.businesshorizon2.businesshorizon2.validation;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

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

	@Test
	public void isOk() throws Exception {
		//Arrange
		ScenarioPostRequestDto request = new ScenarioPostRequestDto();
		request.setScenarioName("xyz");
		request.setScenarioDescription("xyz");
		request.setPeriods(3);
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
		
		//Act
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		//Assert
		assertEquals(0, violations.size());
	}
}
