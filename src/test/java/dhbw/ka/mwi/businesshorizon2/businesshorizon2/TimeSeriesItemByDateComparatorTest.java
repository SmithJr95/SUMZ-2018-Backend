package dhbw.ka.mwi.businesshorizon2.businesshorizon2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.dhbw.ka.mwi.businesshorizon2.comparators.TimeSeriesItemByDateComparator;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.TimeSeriesItem;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.TimeSeriesItemDate;

public class TimeSeriesItemByDateComparatorTest {
	
	@Test(expected = UnsupportedOperationException.class)
	public void compare_otherIsNull_throwsUnsupportedOperationException() {
		//Arrange
		TimeSeriesItem date = new TimeSeriesItem();		
		TimeSeriesItemByDateComparator comparator = new TimeSeriesItemByDateComparator();
		
		//Act
		comparator.compare(date, null);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void compare_otherDateNull_throwsUnsupportedOperationException() {
		//Arrange
		TimeSeriesItem date1 = new TimeSeriesItem(new TimeSeriesItemDate(2000), 50.0);
		TimeSeriesItem date2 = new TimeSeriesItem();
		TimeSeriesItemByDateComparator comparator = new TimeSeriesItemByDateComparator();
		
		//Act
		comparator.compare(date1, date2);
	}
	
	@Test
	public void compare_otherDateIsSame_returnsZero() {
		//Arrange	
		TimeSeriesItemDate date1 = new TimeSeriesItemDate(2001);
		TimeSeriesItemDate date2 = new TimeSeriesItemDate(2000, 1);	
		TimeSeriesItemDate date3 = new TimeSeriesItemDate(2001);
		TimeSeriesItemDate date4 = new TimeSeriesItemDate(2000, 1);	
		
		TimeSeriesItem tsi1 = new TimeSeriesItem(date1, 50.0);
		TimeSeriesItem tsi2 = new TimeSeriesItem(date2, 50.0);
		TimeSeriesItem tsi3 = new TimeSeriesItem(date3, 50.0);
		TimeSeriesItem tsi4 = new TimeSeriesItem(date4, 50.0);
		
		TimeSeriesItemByDateComparator comparator = new TimeSeriesItemByDateComparator();
		
		//Act
		List<Integer> results = new ArrayList<Integer>();
		results.add(comparator.compare(tsi1, tsi3));
		results.add(comparator.compare(tsi3, tsi1));
		results.add(comparator.compare(tsi1, tsi1));
		results.add(comparator.compare(tsi2, tsi4));
		results.add(comparator.compare(tsi4, tsi2));
		results.add(comparator.compare(tsi2, tsi2));
		
		//Assert
		for (Integer i : results) {
			assertEquals(0, i.intValue());
		}
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void compare_otherDateIsInvalid_throwsUnsupportedOperationException() {
		//Arrange	
		TimeSeriesItemDate date1 = new TimeSeriesItemDate(2001);
		TimeSeriesItemDate date2 = new TimeSeriesItemDate();
		
		TimeSeriesItem tsi1 = new TimeSeriesItem(date1, 50.0);
		TimeSeriesItem tsi2 = new TimeSeriesItem(date2, 50.0);
		
		TimeSeriesItemByDateComparator comparator = new TimeSeriesItemByDateComparator();
		
		//Act
		comparator.compare(tsi1, tsi2);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void compare_thisDateIsInvalid_throwsUnsupportedOperationException() {
		//Arrange	
		TimeSeriesItemDate date1 = new TimeSeriesItemDate(2001);
		TimeSeriesItemDate date2 = new TimeSeriesItemDate();
		
		TimeSeriesItem tsi1 = new TimeSeriesItem(date1, 50.0);
		TimeSeriesItem tsi2 = new TimeSeriesItem(date2, 50.0);

		TimeSeriesItemByDateComparator comparator = new TimeSeriesItemByDateComparator();
		
		//Act
		comparator.compare(tsi2, tsi1);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void compare_bothDatesInvalid_throwsUnsupportedOperationException() {
		//Arrange
		TimeSeriesItemDate date1 = new TimeSeriesItemDate();
		TimeSeriesItemDate date2 = new TimeSeriesItemDate();
		
		TimeSeriesItem tsi1 = new TimeSeriesItem(date1, 50.0);
		TimeSeriesItem tsi2 = new TimeSeriesItem(date2, 50.0);

		TimeSeriesItemByDateComparator comparator = new TimeSeriesItemByDateComparator();
		
		//Act
		comparator.compare(tsi1, tsi2);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void compare_differentValidDatesFormats_throwsUnsupportedOperationException() {
		//Arrange
		TimeSeriesItemDate date1 = new TimeSeriesItemDate(2000);
		TimeSeriesItemDate date2 = new TimeSeriesItemDate(2000, 1);
		
		TimeSeriesItem tsi1 = new TimeSeriesItem(date1, 50.0);
		TimeSeriesItem tsi2 = new TimeSeriesItem(date2, 50.0);

		TimeSeriesItemByDateComparator comparator = new TimeSeriesItemByDateComparator();
		
		//Act
		comparator.compare(tsi1, tsi2);
	}
	
	@Test
	public void compare_otherDateIsBefore_returnsMinusOne() {
		//Arrange	
		TimeSeriesItemDate date1 = new TimeSeriesItemDate(2000);
		TimeSeriesItemDate date2 = new TimeSeriesItemDate(2000, 4);	
		TimeSeriesItemDate date3 = new TimeSeriesItemDate(2001);
		TimeSeriesItemDate date4 = new TimeSeriesItemDate(2001, 1);	
		
		TimeSeriesItem tsi1 = new TimeSeriesItem(date1, 50.0);
		TimeSeriesItem tsi2 = new TimeSeriesItem(date2, 50.0);
		TimeSeriesItem tsi3 = new TimeSeriesItem(date3, 50.0);
		TimeSeriesItem tsi4 = new TimeSeriesItem(date4, 50.0);

		TimeSeriesItemByDateComparator comparator = new TimeSeriesItemByDateComparator();
		
		//Act
		int res1 = comparator.compare(tsi1, tsi3);
		int res2 = comparator.compare(tsi2, tsi4);
		
		//Assert
		assertEquals(-1, res1);
		assertEquals(-1, res2);
	}
	
	@Test
	public void compare_otherDateIsAfter_returnsMinusOne() {
		//Arrange	
		TimeSeriesItemDate date1 = new TimeSeriesItemDate(2000);
		TimeSeriesItemDate date2 = new TimeSeriesItemDate(2000, 4);	
		TimeSeriesItemDate date3 = new TimeSeriesItemDate(2001);
		TimeSeriesItemDate date4 = new TimeSeriesItemDate(2001, 1);	
		
		TimeSeriesItem tsi1 = new TimeSeriesItem(date1, 50.0);
		TimeSeriesItem tsi2 = new TimeSeriesItem(date2, 50.0);
		TimeSeriesItem tsi3 = new TimeSeriesItem(date3, 50.0);
		TimeSeriesItem tsi4 = new TimeSeriesItem(date4, 50.0);

		TimeSeriesItemByDateComparator comparator = new TimeSeriesItemByDateComparator();
		
		//Act
		int res1 = comparator.compare(tsi3, tsi1);
		int res2 = comparator.compare(tsi4, tsi2);
		
		//Assert
		assertEquals(1, res1);
		assertEquals(1, res2);
	}
	
}
