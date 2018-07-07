package dhbw.ka.mwi.businesshorizon2.businesshorizon2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.dhbw.ka.mwi.businesshorizon2.comparators.TimeSeriesItemByDateComparator;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemDateRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemRequestDto;

public class TimeSeriesItemByDateComparatorTest {
	
	@Test(expected = UnsupportedOperationException.class)
	public void compare_otherIsNull_throwsUnsupportedOperationException() {
		//Arrange
		TimeSeriesItemRequestDto date = new TimeSeriesItemRequestDto();		
		TimeSeriesItemByDateComparator comparator = new TimeSeriesItemByDateComparator();
		
		//Act
		comparator.compare(date, null);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void compare_otherDateNull_throwsUnsupportedOperationException() {
		//Arrange
		TimeSeriesItemRequestDto date1 = new TimeSeriesItemRequestDto(new TimeSeriesItemDateRequestDto(2000), 50.0);
		TimeSeriesItemRequestDto date2 = new TimeSeriesItemRequestDto();
		TimeSeriesItemByDateComparator comparator = new TimeSeriesItemByDateComparator();
		
		//Act
		comparator.compare(date1, date2);
	}
	
	@Test
	public void compare_otherDateIsSame_returnsZero() {
		//Arrange	
		TimeSeriesItemDateRequestDto date1 = new TimeSeriesItemDateRequestDto(2001);
		TimeSeriesItemDateRequestDto date2 = new TimeSeriesItemDateRequestDto(2000, 1);	
		TimeSeriesItemDateRequestDto date3 = new TimeSeriesItemDateRequestDto(2001);
		TimeSeriesItemDateRequestDto date4 = new TimeSeriesItemDateRequestDto(2000, 1);	
		
		TimeSeriesItemRequestDto tsi1 = new TimeSeriesItemRequestDto(date1, 50.0);
		TimeSeriesItemRequestDto tsi2 = new TimeSeriesItemRequestDto(date2, 50.0);
		TimeSeriesItemRequestDto tsi3 = new TimeSeriesItemRequestDto(date3, 50.0);
		TimeSeriesItemRequestDto tsi4 = new TimeSeriesItemRequestDto(date4, 50.0);
		
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
		TimeSeriesItemDateRequestDto date1 = new TimeSeriesItemDateRequestDto(2001);
		TimeSeriesItemDateRequestDto date2 = new TimeSeriesItemDateRequestDto();
		
		TimeSeriesItemRequestDto tsi1 = new TimeSeriesItemRequestDto(date1, 50.0);
		TimeSeriesItemRequestDto tsi2 = new TimeSeriesItemRequestDto(date2, 50.0);
		
		TimeSeriesItemByDateComparator comparator = new TimeSeriesItemByDateComparator();
		
		//Act
		comparator.compare(tsi1, tsi2);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void compare_thisDateIsInvalid_throwsUnsupportedOperationException() {
		//Arrange	
		TimeSeriesItemDateRequestDto date1 = new TimeSeriesItemDateRequestDto(2001);
		TimeSeriesItemDateRequestDto date2 = new TimeSeriesItemDateRequestDto();
		
		TimeSeriesItemRequestDto tsi1 = new TimeSeriesItemRequestDto(date1, 50.0);
		TimeSeriesItemRequestDto tsi2 = new TimeSeriesItemRequestDto(date2, 50.0);

		TimeSeriesItemByDateComparator comparator = new TimeSeriesItemByDateComparator();
		
		//Act
		comparator.compare(tsi2, tsi1);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void compare_bothDatesInvalid_throwsUnsupportedOperationException() {
		//Arrange
		TimeSeriesItemDateRequestDto date1 = new TimeSeriesItemDateRequestDto();
		TimeSeriesItemDateRequestDto date2 = new TimeSeriesItemDateRequestDto();
		
		TimeSeriesItemRequestDto tsi1 = new TimeSeriesItemRequestDto(date1, 50.0);
		TimeSeriesItemRequestDto tsi2 = new TimeSeriesItemRequestDto(date2, 50.0);

		TimeSeriesItemByDateComparator comparator = new TimeSeriesItemByDateComparator();
		
		//Act
		comparator.compare(tsi1, tsi2);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void compare_differentValidDatesFormats_throwsUnsupportedOperationException() {
		//Arrange
		TimeSeriesItemDateRequestDto date1 = new TimeSeriesItemDateRequestDto(2000);
		TimeSeriesItemDateRequestDto date2 = new TimeSeriesItemDateRequestDto(2000, 1);
		
		TimeSeriesItemRequestDto tsi1 = new TimeSeriesItemRequestDto(date1, 50.0);
		TimeSeriesItemRequestDto tsi2 = new TimeSeriesItemRequestDto(date2, 50.0);

		TimeSeriesItemByDateComparator comparator = new TimeSeriesItemByDateComparator();
		
		//Act
		comparator.compare(tsi1, tsi2);
	}
	
	@Test
	public void compare_otherDateIsBefore_returnsMinusOne() {
		//Arrange	
		TimeSeriesItemDateRequestDto date1 = new TimeSeriesItemDateRequestDto(2000);
		TimeSeriesItemDateRequestDto date2 = new TimeSeriesItemDateRequestDto(2000, 4);	
		TimeSeriesItemDateRequestDto date3 = new TimeSeriesItemDateRequestDto(2001);
		TimeSeriesItemDateRequestDto date4 = new TimeSeriesItemDateRequestDto(2001, 1);	
		
		TimeSeriesItemRequestDto tsi1 = new TimeSeriesItemRequestDto(date1, 50.0);
		TimeSeriesItemRequestDto tsi2 = new TimeSeriesItemRequestDto(date2, 50.0);
		TimeSeriesItemRequestDto tsi3 = new TimeSeriesItemRequestDto(date3, 50.0);
		TimeSeriesItemRequestDto tsi4 = new TimeSeriesItemRequestDto(date4, 50.0);

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
		TimeSeriesItemDateRequestDto date1 = new TimeSeriesItemDateRequestDto(2000);
		TimeSeriesItemDateRequestDto date2 = new TimeSeriesItemDateRequestDto(2000, 4);	
		TimeSeriesItemDateRequestDto date3 = new TimeSeriesItemDateRequestDto(2001);
		TimeSeriesItemDateRequestDto date4 = new TimeSeriesItemDateRequestDto(2001, 1);	
		
		TimeSeriesItemRequestDto tsi1 = new TimeSeriesItemRequestDto(date1, 50.0);
		TimeSeriesItemRequestDto tsi2 = new TimeSeriesItemRequestDto(date2, 50.0);
		TimeSeriesItemRequestDto tsi3 = new TimeSeriesItemRequestDto(date3, 50.0);
		TimeSeriesItemRequestDto tsi4 = new TimeSeriesItemRequestDto(date4, 50.0);

		TimeSeriesItemByDateComparator comparator = new TimeSeriesItemByDateComparator();
		
		//Act
		int res1 = comparator.compare(tsi3, tsi1);
		int res2 = comparator.compare(tsi4, tsi2);
		
		//Assert
		assertEquals(1, res1);
		assertEquals(1, res2);
	}
	
}
