package dhbw.ka.mwi.businesshorizon2.businesshorizon2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.dhbw.ka.mwi.businesshorizon2.comparators.TimeSeriesItemByDateComparator;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemDateDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemDto;

public class TimeSeriesItemByDateComparatorTest {
	
	@Test(expected = UnsupportedOperationException.class)
	public void compare_otherIsNull_throwsUnsupportedOperationException() {
		//Arrange
		TimeSeriesItemDto date = new TimeSeriesItemDto();		
		TimeSeriesItemByDateComparator comparator = new TimeSeriesItemByDateComparator();
		
		//Act
		comparator.compare(date, null);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void compare_otherDateNull_throwsUnsupportedOperationException() {
		//Arrange
		TimeSeriesItemDto date1 = new TimeSeriesItemDto(new TimeSeriesItemDateDto(2000), 50.0);
		TimeSeriesItemDto date2 = new TimeSeriesItemDto();
		TimeSeriesItemByDateComparator comparator = new TimeSeriesItemByDateComparator();
		
		//Act
		comparator.compare(date1, date2);
	}
	
	@Test
	public void compare_otherDateIsSame_returnsZero() {
		//Arrange	
		TimeSeriesItemDateDto date1 = new TimeSeriesItemDateDto(2001);
		TimeSeriesItemDateDto date2 = new TimeSeriesItemDateDto(2000, 1);	
		TimeSeriesItemDateDto date3 = new TimeSeriesItemDateDto(2001);
		TimeSeriesItemDateDto date4 = new TimeSeriesItemDateDto(2000, 1);	
		
		TimeSeriesItemDto tsi1 = new TimeSeriesItemDto(date1, 50.0);
		TimeSeriesItemDto tsi2 = new TimeSeriesItemDto(date2, 50.0);
		TimeSeriesItemDto tsi3 = new TimeSeriesItemDto(date3, 50.0);
		TimeSeriesItemDto tsi4 = new TimeSeriesItemDto(date4, 50.0);
		
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
		TimeSeriesItemDateDto date1 = new TimeSeriesItemDateDto(2001);
		TimeSeriesItemDateDto date2 = new TimeSeriesItemDateDto();
		
		TimeSeriesItemDto tsi1 = new TimeSeriesItemDto(date1, 50.0);
		TimeSeriesItemDto tsi2 = new TimeSeriesItemDto(date2, 50.0);
		
		TimeSeriesItemByDateComparator comparator = new TimeSeriesItemByDateComparator();
		
		//Act
		comparator.compare(tsi1, tsi2);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void compare_thisDateIsInvalid_throwsUnsupportedOperationException() {
		//Arrange	
		TimeSeriesItemDateDto date1 = new TimeSeriesItemDateDto(2001);
		TimeSeriesItemDateDto date2 = new TimeSeriesItemDateDto();
		
		TimeSeriesItemDto tsi1 = new TimeSeriesItemDto(date1, 50.0);
		TimeSeriesItemDto tsi2 = new TimeSeriesItemDto(date2, 50.0);

		TimeSeriesItemByDateComparator comparator = new TimeSeriesItemByDateComparator();
		
		//Act
		comparator.compare(tsi2, tsi1);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void compare_bothDatesInvalid_throwsUnsupportedOperationException() {
		//Arrange
		TimeSeriesItemDateDto date1 = new TimeSeriesItemDateDto();
		TimeSeriesItemDateDto date2 = new TimeSeriesItemDateDto();
		
		TimeSeriesItemDto tsi1 = new TimeSeriesItemDto(date1, 50.0);
		TimeSeriesItemDto tsi2 = new TimeSeriesItemDto(date2, 50.0);

		TimeSeriesItemByDateComparator comparator = new TimeSeriesItemByDateComparator();
		
		//Act
		comparator.compare(tsi1, tsi2);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void compare_differentValidDatesFormats_throwsUnsupportedOperationException() {
		//Arrange
		TimeSeriesItemDateDto date1 = new TimeSeriesItemDateDto(2000);
		TimeSeriesItemDateDto date2 = new TimeSeriesItemDateDto(2000, 1);
		
		TimeSeriesItemDto tsi1 = new TimeSeriesItemDto(date1, 50.0);
		TimeSeriesItemDto tsi2 = new TimeSeriesItemDto(date2, 50.0);

		TimeSeriesItemByDateComparator comparator = new TimeSeriesItemByDateComparator();
		
		//Act
		comparator.compare(tsi1, tsi2);
	}
	
	@Test
	public void compare_otherDateIsBefore_returnsMinusOne() {
		//Arrange	
		TimeSeriesItemDateDto date1 = new TimeSeriesItemDateDto(2000);
		TimeSeriesItemDateDto date2 = new TimeSeriesItemDateDto(2000, 4);	
		TimeSeriesItemDateDto date3 = new TimeSeriesItemDateDto(2001);
		TimeSeriesItemDateDto date4 = new TimeSeriesItemDateDto(2001, 1);	
		
		TimeSeriesItemDto tsi1 = new TimeSeriesItemDto(date1, 50.0);
		TimeSeriesItemDto tsi2 = new TimeSeriesItemDto(date2, 50.0);
		TimeSeriesItemDto tsi3 = new TimeSeriesItemDto(date3, 50.0);
		TimeSeriesItemDto tsi4 = new TimeSeriesItemDto(date4, 50.0);

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
		TimeSeriesItemDateDto date1 = new TimeSeriesItemDateDto(2000);
		TimeSeriesItemDateDto date2 = new TimeSeriesItemDateDto(2000, 4);	
		TimeSeriesItemDateDto date3 = new TimeSeriesItemDateDto(2001);
		TimeSeriesItemDateDto date4 = new TimeSeriesItemDateDto(2001, 1);	
		
		TimeSeriesItemDto tsi1 = new TimeSeriesItemDto(date1, 50.0);
		TimeSeriesItemDto tsi2 = new TimeSeriesItemDto(date2, 50.0);
		TimeSeriesItemDto tsi3 = new TimeSeriesItemDto(date3, 50.0);
		TimeSeriesItemDto tsi4 = new TimeSeriesItemDto(date4, 50.0);

		TimeSeriesItemByDateComparator comparator = new TimeSeriesItemByDateComparator();
		
		//Act
		int res1 = comparator.compare(tsi3, tsi1);
		int res2 = comparator.compare(tsi4, tsi2);
		
		//Assert
		assertEquals(1, res1);
		assertEquals(1, res2);
	}
	
}
