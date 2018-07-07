package dhbw.ka.mwi.businesshorizon2.businesshorizon2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.MultiPeriodAccountingFigureRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemDateRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemRequestDto;

public class MultiPeriodAccountingFigureTest {
	
	@Test
	public void getMinDate_TimeSeriesIsNull_ReturnsNull(){
		//Arrange
		MultiPeriodAccountingFigureRequestDto figure = new MultiPeriodAccountingFigureRequestDto();
		figure.setIsHistoric(true);
		
		//Act
		TimeSeriesItemDateRequestDto minDate = figure.getMinDate();
		
		//Assert
		assertNull(minDate);
	}
	
	@Test
	public void getMaxDate_TimeSeriesIsNull_ReturnsNull(){
		//Arrange
		MultiPeriodAccountingFigureRequestDto figure = new MultiPeriodAccountingFigureRequestDto();
		figure.setIsHistoric(true);
		
		//Act
		TimeSeriesItemDateRequestDto maxDate = figure.getMaxDate();
		
		//Assert
		assertNull(maxDate);
	}
	
	@Test
	public void getMinDate_TimeSeriesIsEmpty_ReturnsNull(){
		//Arrange
		MultiPeriodAccountingFigureRequestDto figure = new MultiPeriodAccountingFigureRequestDto();
		figure.setIsHistoric(true);
		figure.setTimeSeries(new ArrayList<TimeSeriesItemRequestDto>());
		
		//Act
		TimeSeriesItemDateRequestDto minDate = figure.getMinDate();
		
		//Assert
		assertNull(minDate);
	}
	
	@Test
	public void getMaxDate_TimeSeriesIsEmpty_ReturnsNull(){
		//Arrange
		MultiPeriodAccountingFigureRequestDto figure = new MultiPeriodAccountingFigureRequestDto();
		figure.setIsHistoric(true);
		figure.setTimeSeries(new ArrayList<TimeSeriesItemRequestDto>());
		
		//Act
		TimeSeriesItemDateRequestDto maxDate = figure.getMaxDate();
		
		//Assert
		assertNull(maxDate);
	}
	
	@Test
	public void getMinDate_TimeSeriesIsNotEmpty_ReturnsCorrectDate(){
		//Arrange
		List<TimeSeriesItemRequestDto> timeSeries1 = new ArrayList<TimeSeriesItemRequestDto>();
		timeSeries1.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2005), 60.0));
		timeSeries1.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000), 50.0));
		timeSeries1.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2002), 70.0));
		
		MultiPeriodAccountingFigureRequestDto figure1 = new MultiPeriodAccountingFigureRequestDto();
		figure1.setIsHistoric(true);
		figure1.setTimeSeries(timeSeries1);
		
		List<TimeSeriesItemRequestDto> timeSeries2 = new ArrayList<TimeSeriesItemRequestDto>();
		timeSeries2.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 1), 60.0));
		timeSeries2.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(1999, 2), 50.0));
		timeSeries2.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 4), 70.0));
		
		MultiPeriodAccountingFigureRequestDto figure2 = new MultiPeriodAccountingFigureRequestDto();
		figure2.setIsHistoric(true);
		figure2.setTimeSeries(timeSeries2);
		
		TimeSeriesItemDateRequestDto expectedMinDate1 = new TimeSeriesItemDateRequestDto(2000);
		TimeSeriesItemDateRequestDto expectedMinDate2 = new TimeSeriesItemDateRequestDto(1999, 2);
		
		//Act
		TimeSeriesItemDateRequestDto actualMinDate1 = figure1.getMinDate();
		TimeSeriesItemDateRequestDto actualMinDate2 = figure2.getMinDate();
		
		//Assert
		assertEquals(expectedMinDate1, actualMinDate1);	
		assertEquals(expectedMinDate2, actualMinDate2);	
	}
	
	@Test
	public void getMaxDate_TimeSeriesIsNotEmpty_ReturnsCorrectDate(){
		//Arrange
		List<TimeSeriesItemRequestDto> timeSeries1 = new ArrayList<TimeSeriesItemRequestDto>();
		timeSeries1.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000), 50.0));
		timeSeries1.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2005), 60.0));
		timeSeries1.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2002), 70.0));
		
		MultiPeriodAccountingFigureRequestDto figure1 = new MultiPeriodAccountingFigureRequestDto();
		figure1.setIsHistoric(true);
		figure1.setTimeSeries(timeSeries1);
		
		List<TimeSeriesItemRequestDto> timeSeries2 = new ArrayList<TimeSeriesItemRequestDto>();
		timeSeries2.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 1), 60.0));
		timeSeries2.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 4), 50.0));
		timeSeries2.add(new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 2), 70.0));
		
		MultiPeriodAccountingFigureRequestDto figure2 = new MultiPeriodAccountingFigureRequestDto();
		figure2.setIsHistoric(true);
		figure2.setTimeSeries(timeSeries2);
		
		TimeSeriesItemDateRequestDto expectedMaxDate1 = new TimeSeriesItemDateRequestDto(2005);
		TimeSeriesItemDateRequestDto expectedMaxDate2 = new TimeSeriesItemDateRequestDto(2000, 4);
		
		//Act
		TimeSeriesItemDateRequestDto actualMaxDate1 = figure1.getMaxDate();
		TimeSeriesItemDateRequestDto actualMaxDate2 = figure2.getMaxDate();
		
		//Assert
		assertEquals(expectedMaxDate1, actualMaxDate1);	
		assertEquals(expectedMaxDate2, actualMaxDate2);	
	}
	
	@Test
	public void getTimeSeriesAmountsSortedAscByDate_dateFormatYear_returnsSortedAmounts(){
		//Arrange
		MultiPeriodAccountingFigureRequestDto figure = new MultiPeriodAccountingFigureRequestDto();
		
		List<TimeSeriesItemRequestDto> items = new ArrayList<TimeSeriesItemRequestDto>();
		
		TimeSeriesItemRequestDto tsi1 = new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 3), 70.0);
		TimeSeriesItemRequestDto tsi2 = new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 1), 50.0);
		TimeSeriesItemRequestDto tsi3 = new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 2), 60.0);
		TimeSeriesItemRequestDto tsi4 = new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000, 4), 80.0);
		
		items.add(tsi1);
		items.add(tsi2);
		items.add(tsi3);
		items.add(tsi4);
		
		figure.setTimeSeries(items);
		
		//Act
		List<Double> amounts = figure.getTimeSeriesAmountsSortedAscByDate();
		
		//Assert
		assertEquals(tsi2.getAmount(), amounts.get(0));
		assertEquals(tsi3.getAmount(), amounts.get(1));
		assertEquals(tsi1.getAmount(), amounts.get(2));
		assertEquals(tsi4.getAmount(), amounts.get(3));
	}
}
