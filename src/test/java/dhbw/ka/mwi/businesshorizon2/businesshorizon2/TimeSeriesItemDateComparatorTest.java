package dhbw.ka.mwi.businesshorizon2.businesshorizon2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.TimeSeriesItem;
import edu.dhbw.ka.mwi.businesshorizon2.models.comparators.TimeSeriesItemDateComparator;

public class TimeSeriesItemDateComparatorTest {
	
	@Test(expected = UnsupportedOperationException.class)
	public void compare_DateFormatNone() {
		//Arrange
		TimeSeriesItemDateComparator comparator = new TimeSeriesItemDateComparator();
		
		TimeSeriesItem t1 = new TimeSeriesItem();
		TimeSeriesItem t2 = new TimeSeriesItem();
		
		//Act
		comparator.compare(t1, t2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void compare_DateFormatsDifferent_YearNone() {
		//Arrange
		TimeSeriesItemDateComparator comparator = new TimeSeriesItemDateComparator();
		
		TimeSeriesItem t1 = new TimeSeriesItem();
		t1.setYear(2000);
		TimeSeriesItem t2 = new TimeSeriesItem();
		
		//Act
		comparator.compare(t1, t2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void compare_DateFormatsDifferent_YearQuarter() {
		//Arrange
		TimeSeriesItemDateComparator comparator = new TimeSeriesItemDateComparator();
		
		TimeSeriesItem t1 = new TimeSeriesItem();
		t1.setYear(2000);
		TimeSeriesItem t2 = new TimeSeriesItem();
		t2.setYear(2000);
		t2.setQuarter(4);
		
		//Act
		comparator.compare(t1, t2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void compare_DateFormatsDifferent_QuarterNone() {
		//Arrange
		TimeSeriesItemDateComparator comparator = new TimeSeriesItemDateComparator();
		
		TimeSeriesItem t1 = new TimeSeriesItem();
		TimeSeriesItem t2 = new TimeSeriesItem();
		t2.setQuarter(4);
		
		//Act
		comparator.compare(t1, t2);
	}
	
	@Test
	public void compare_DateFormatYear() {
		//Arrange
		TimeSeriesItemDateComparator comparator = new TimeSeriesItemDateComparator();
		
		TimeSeriesItem t1 = new TimeSeriesItem();
		t1.setYear(2000);
		TimeSeriesItem t2 = new TimeSeriesItem();
		t2.setYear(2000);
		
		TimeSeriesItem t3 = new TimeSeriesItem();
		t3.setYear(2000);
		TimeSeriesItem t4 = new TimeSeriesItem();
		t4.setYear(2001);
		
		TimeSeriesItem t5 = new TimeSeriesItem();
		t5.setYear(2001);
		TimeSeriesItem t6 = new TimeSeriesItem();
		t6.setYear(2000);
		
		int expectedRes1 = 0;
		int expectedRes2 = -1;
		int expectedRes3 = 1;
		
		//Act
		int actualRes1 = comparator.compare(t1, t2);
		int actualRes2 = comparator.compare(t3, t4);
		int actualRes3 = comparator.compare(t5, t6);
		
		//Assert	
		assertEquals(actualRes1, expectedRes1);
		assertEquals(actualRes2, expectedRes2);
		assertEquals(actualRes3, expectedRes3);
	}
	
	@Test
	public void compare_DateFormatYearQuarter() {
		//Arrange
		TimeSeriesItemDateComparator comparator = new TimeSeriesItemDateComparator();
		
		TimeSeriesItem t1 = new TimeSeriesItem();
		t1.setYear(2000);
		t1.setQuarter(2);
		TimeSeriesItem t2 = new TimeSeriesItem();
		t2.setYear(2000);
		t2.setQuarter(2);
		
		TimeSeriesItem t3 = new TimeSeriesItem();
		t3.setYear(2000);
		t3.setQuarter(2);
		TimeSeriesItem t4 = new TimeSeriesItem();
		t4.setYear(2001);
		t4.setQuarter(2);
		
		TimeSeriesItem t5 = new TimeSeriesItem();
		t5.setYear(2001);
		t5.setQuarter(2);
		TimeSeriesItem t6 = new TimeSeriesItem();
		t6.setYear(2000);
		t6.setQuarter(2);
		
		TimeSeriesItem t7 = new TimeSeriesItem();
		t7.setYear(2000);
		t7.setQuarter(1);
		TimeSeriesItem t8 = new TimeSeriesItem();
		t8.setYear(2001);
		t8.setQuarter(2);
		
		TimeSeriesItem t9 = new TimeSeriesItem();
		t9.setYear(2001);
		t9.setQuarter(1);
		TimeSeriesItem t10 = new TimeSeriesItem();
		t10.setYear(2000);
		t10.setQuarter(2);
		
		int expectedRes1 = 0;
		int expectedRes2 = -1;
		int expectedRes3 = 1;
		int expectedRes4 = -1;
		int expectedRes5 = 1;
		
		//Act
		int actualRes1 = comparator.compare(t1, t2);
		int actualRes2 = comparator.compare(t3, t4);
		int actualRes3 = comparator.compare(t5, t6);
		int actualRes4 = comparator.compare(t7, t8);
		int actualRes5 = comparator.compare(t9, t10);
		
		//Assert	
		assertEquals(actualRes1, expectedRes1);
		assertEquals(actualRes2, expectedRes2);
		assertEquals(actualRes3, expectedRes3);
		assertEquals(actualRes4, expectedRes4);
		assertEquals(actualRes5, expectedRes5);
	}
	
	@Test
	public void compare_getMaxItem() {
		//Arrange
		TimeSeriesItemDateComparator comparator = new TimeSeriesItemDateComparator();
		
		TimeSeriesItem t1 = new TimeSeriesItem();
		t1.setYear(2000);
		t1.setQuarter(2);
		TimeSeriesItem t2 = new TimeSeriesItem();
		t2.setYear(2000);
		t2.setQuarter(3);
		TimeSeriesItem t3 = new TimeSeriesItem();
		t3.setYear(2000);
		t3.setQuarter(1);
		
		List<TimeSeriesItem> items = new ArrayList<TimeSeriesItem>();
		items.add(t1);
		items.add(t2);
		items.add(t3);
		TimeSeriesItem expectedRes = t2;
		
		//Act
		TimeSeriesItem actualRes = Collections.max(items, comparator);
		
		//Assert	
		assertTrue(actualRes == expectedRes);
	}
	
	@Test
	public void compare_getMinItem() {
		//Arrange
		TimeSeriesItemDateComparator comparator = new TimeSeriesItemDateComparator();
		
		TimeSeriesItem t1 = new TimeSeriesItem();
		t1.setYear(2000);
		t1.setQuarter(2);
		TimeSeriesItem t2 = new TimeSeriesItem();
		t2.setYear(2000);
		t2.setQuarter(3);
		TimeSeriesItem t3 = new TimeSeriesItem();
		t3.setYear(2000);
		t3.setQuarter(1);
		
		List<TimeSeriesItem> items = new ArrayList<TimeSeriesItem>();
		items.add(t1);
		items.add(t2);
		items.add(t3);
		TimeSeriesItem expectedRes = t2;
		
		//Act
		TimeSeriesItem actualRes = Collections.max(items, comparator);
		
		//Assert	
		assertTrue(actualRes == expectedRes);
	}
	

}
