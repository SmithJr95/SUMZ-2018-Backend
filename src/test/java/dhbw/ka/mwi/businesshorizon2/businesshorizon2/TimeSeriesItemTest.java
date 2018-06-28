package dhbw.ka.mwi.businesshorizon2.businesshorizon2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.TimeSeriesItem;

public class TimeSeriesItemTest {
	
	@Test(expected = UnsupportedOperationException.class)
	public void datesEqual_bothNoYearOrQuarter() {
		//Arrange
		TimeSeriesItem t1 = new TimeSeriesItem();
		TimeSeriesItem t2 = new TimeSeriesItem();
		
		//Act
		t1.datesEqual(t2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void datesEqual_OneIsNull() {
		//Arrange
		TimeSeriesItem t1 = new TimeSeriesItem();
		
		//Act
		t1.datesEqual(null);
	}
	
	@Test
	public void datesEqual_BothSameYear() {
		//Arrange
		TimeSeriesItem t1 = new TimeSeriesItem();
		t1.setYear(2010);
		TimeSeriesItem t2 = new TimeSeriesItem();
		t2.setYear(2010);
		
		//Act
		boolean datesEqual = t1.datesEqual(t2);
		
		//Assert
		assertTrue(datesEqual);
	}
	
	@Test
	public void datesEqual_BothSameYearAndQuarter() {
		//Arrange
		TimeSeriesItem t1 = new TimeSeriesItem();
		t1.setYear(2010);
		t1.setQuarter(2);
		TimeSeriesItem t2 = new TimeSeriesItem();
		t2.setYear(2010);
		t2.setQuarter(2);
		
		//Act
		boolean datesEqual = t1.datesEqual(t2);
		
		//Assert
		assertTrue(datesEqual);
	}
	
	@Test
	public void datesEqual_SameObject() {
		//Arrange
		TimeSeriesItem t1 = new TimeSeriesItem();
		t1.setYear(2010);
		
		//Act
		boolean datesEqual1 = t1.datesEqual(t1);
		
		//Assert
		assertTrue(datesEqual1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void datesEqual_DifferentDateFormats() {
		//Arrange
		TimeSeriesItem t1 = new TimeSeriesItem();
		t1.setYear(2010);
		TimeSeriesItem t2 = new TimeSeriesItem();
		t2.setYear(2010);
		t2.setQuarter(3);
		
		//Act
		t1.datesEqual(t2);
	}
}
