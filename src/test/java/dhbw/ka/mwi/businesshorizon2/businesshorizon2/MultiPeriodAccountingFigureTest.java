package dhbw.ka.mwi.businesshorizon2.businesshorizon2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigure;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.TimeSeriesItem;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.TimeSeriesItemDate;

public class MultiPeriodAccountingFigureTest {
	
	@Test
	public void getMinDate_TimeSeriesIsNull_ReturnsNull(){
		//Arrange
		MultiPeriodAccountingFigure figure = new MultiPeriodAccountingFigure();
		figure.setIsHistoric(true);
		
		//Act
		TimeSeriesItemDate minDate = figure.getMinDate();
		
		//Assert
		assertNull(minDate);
	}
	
	@Test
	public void getMaxDate_TimeSeriesIsNull_ReturnsNull(){
		//Arrange
		MultiPeriodAccountingFigure figure = new MultiPeriodAccountingFigure();
		figure.setIsHistoric(true);
		
		//Act
		TimeSeriesItemDate maxDate = figure.getMaxDate();
		
		//Assert
		assertNull(maxDate);
	}
	
	@Test
	public void getMinDate_TimeSeriesIsEmpty_ReturnsNull(){
		//Arrange
		MultiPeriodAccountingFigure figure = new MultiPeriodAccountingFigure();
		figure.setIsHistoric(true);
		figure.setTimeSeries(new ArrayList<TimeSeriesItem>());
		
		//Act
		TimeSeriesItemDate minDate = figure.getMinDate();
		
		//Assert
		assertNull(minDate);
	}
	
	@Test
	public void getMaxDate_TimeSeriesIsEmpty_ReturnsNull(){
		//Arrange
		MultiPeriodAccountingFigure figure = new MultiPeriodAccountingFigure();
		figure.setIsHistoric(true);
		figure.setTimeSeries(new ArrayList<TimeSeriesItem>());
		
		//Act
		TimeSeriesItemDate maxDate = figure.getMaxDate();
		
		//Assert
		assertNull(maxDate);
	}
	
	@Test
	public void getMinDate_TimeSeriesIsNotEmpty_ReturnsCorrectDate(){
		//Arrange
		List<TimeSeriesItem> timeSeries1 = new ArrayList<TimeSeriesItem>();
		timeSeries1.add(new TimeSeriesItem(new TimeSeriesItemDate(2005), 60.0));
		timeSeries1.add(new TimeSeriesItem(new TimeSeriesItemDate(2000), 50.0));
		timeSeries1.add(new TimeSeriesItem(new TimeSeriesItemDate(2002), 70.0));
		
		MultiPeriodAccountingFigure figure1 = new MultiPeriodAccountingFigure();
		figure1.setIsHistoric(true);
		figure1.setTimeSeries(timeSeries1);
		
		List<TimeSeriesItem> timeSeries2 = new ArrayList<TimeSeriesItem>();
		timeSeries2.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 1), 60.0));
		timeSeries2.add(new TimeSeriesItem(new TimeSeriesItemDate(1999, 2), 50.0));
		timeSeries2.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 4), 70.0));
		
		MultiPeriodAccountingFigure figure2 = new MultiPeriodAccountingFigure();
		figure2.setIsHistoric(true);
		figure2.setTimeSeries(timeSeries2);
		
		TimeSeriesItemDate expectedMinDate1 = new TimeSeriesItemDate(2000);
		TimeSeriesItemDate expectedMinDate2 = new TimeSeriesItemDate(1999, 2);
		
		//Act
		TimeSeriesItemDate actualMinDate1 = figure1.getMinDate();
		TimeSeriesItemDate actualMinDate2 = figure2.getMinDate();
		
		//Assert
		assertEquals(expectedMinDate1, actualMinDate1);	
		assertEquals(expectedMinDate2, actualMinDate2);	
	}
	
	@Test
	public void getMaxDate_TimeSeriesIsNotEmpty_ReturnsCorrectDate(){
		//Arrange
		List<TimeSeriesItem> timeSeries1 = new ArrayList<TimeSeriesItem>();
		timeSeries1.add(new TimeSeriesItem(new TimeSeriesItemDate(2000), 50.0));
		timeSeries1.add(new TimeSeriesItem(new TimeSeriesItemDate(2005), 60.0));
		timeSeries1.add(new TimeSeriesItem(new TimeSeriesItemDate(2002), 70.0));
		
		MultiPeriodAccountingFigure figure1 = new MultiPeriodAccountingFigure();
		figure1.setIsHistoric(true);
		figure1.setTimeSeries(timeSeries1);
		
		List<TimeSeriesItem> timeSeries2 = new ArrayList<TimeSeriesItem>();
		timeSeries2.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 1), 60.0));
		timeSeries2.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 4), 50.0));
		timeSeries2.add(new TimeSeriesItem(new TimeSeriesItemDate(2000, 2), 70.0));
		
		MultiPeriodAccountingFigure figure2 = new MultiPeriodAccountingFigure();
		figure2.setIsHistoric(true);
		figure2.setTimeSeries(timeSeries2);
		
		TimeSeriesItemDate expectedMaxDate1 = new TimeSeriesItemDate(2005);
		TimeSeriesItemDate expectedMaxDate2 = new TimeSeriesItemDate(2000, 4);
		
		//Act
		TimeSeriesItemDate actualMaxDate1 = figure1.getMaxDate();
		TimeSeriesItemDate actualMaxDate2 = figure2.getMaxDate();
		
		//Assert
		assertEquals(expectedMaxDate1, actualMaxDate1);	
		assertEquals(expectedMaxDate2, actualMaxDate2);	
	}

}
