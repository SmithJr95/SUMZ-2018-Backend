package dhbw.ka.mwi.businesshorizon2.businesshorizon2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.TimeSeriesItemDate;

public class TimeSeriesItemDateTest {
	
	@Test(expected = UnsupportedOperationException.class)
	public void dateFormatsEqual_otherIsNull_throwsUnsupportedOperationException() {
		//Arrange
		TimeSeriesItemDate date = new TimeSeriesItemDate();		
		
		//Act
		date.dateFormatsEqual(null);
	}
	
	@Test
	public void dateFormatsEqual_differentFormats_returnsFalse() {
		//Arrange
		TimeSeriesItemDate date1 = new TimeSeriesItemDate();	
		TimeSeriesItemDate date2 = new TimeSeriesItemDate(2000);
		TimeSeriesItemDate date3 = new TimeSeriesItemDate(2000, 1);		
		
		//Act
		boolean dateFormatsEqual1 = date1.dateFormatsEqual(date2);
		boolean dateFormatsEqual2 = date1.dateFormatsEqual(date3);
		boolean dateFormatsEqual3 = date2.dateFormatsEqual(date1);
		boolean dateFormatsEqual4 = date2.dateFormatsEqual(date3);
		boolean dateFormatsEqual5 = date3.dateFormatsEqual(date1);
		boolean dateFormatsEqual6 = date3.dateFormatsEqual(date2);
		
		//Assert
		assertFalse(dateFormatsEqual1);
		assertFalse(dateFormatsEqual2);
		assertFalse(dateFormatsEqual3);
		assertFalse(dateFormatsEqual4);
		assertFalse(dateFormatsEqual5);
		assertFalse(dateFormatsEqual6);
	}
	
	@Test
	public void dateFormatsEqual_equalFormats_returnsTrue() {
		//Arrange
		TimeSeriesItemDate date1 = new TimeSeriesItemDate();	
		TimeSeriesItemDate date2 = new TimeSeriesItemDate(2001);
		TimeSeriesItemDate date3 = new TimeSeriesItemDate(2000, 1);	
		TimeSeriesItemDate date4 = new TimeSeriesItemDate();	
		TimeSeriesItemDate date5 = new TimeSeriesItemDate(1950);
		TimeSeriesItemDate date6 = new TimeSeriesItemDate(1981, 3);	
		
		//Act
		boolean dateFormatsEqual1 = date1.dateFormatsEqual(date4);
		boolean dateFormatsEqual2 = date4.dateFormatsEqual(date1);
		boolean dateFormatsEqual3 = date1.dateFormatsEqual(date1);
		boolean dateFormatsEqual4 = date2.dateFormatsEqual(date5);
		boolean dateFormatsEqual5 = date5.dateFormatsEqual(date2);
		boolean dateFormatsEqual6 = date2.dateFormatsEqual(date2);
		boolean dateFormatsEqual7 = date3.dateFormatsEqual(date6);
		boolean dateFormatsEqual8 = date6.dateFormatsEqual(date3);
		boolean dateFormatsEqual9 = date3.dateFormatsEqual(date3);
		
		//Assert
		assertTrue(dateFormatsEqual1);
		assertTrue(dateFormatsEqual2);
		assertTrue(dateFormatsEqual3);
		assertTrue(dateFormatsEqual4);
		assertTrue(dateFormatsEqual5);
		assertTrue(dateFormatsEqual6);
		assertTrue(dateFormatsEqual7);
		assertTrue(dateFormatsEqual8);
		assertTrue(dateFormatsEqual9);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void compareTo_otherIsNull_throwsUnsupportedOperationException() {
		//Arrange
		TimeSeriesItemDate date = new TimeSeriesItemDate();		
		
		//Act
		date.compareTo(null);
	}
	
	@Test
	public void compareTo_otherDateIsSame_returnsZero() {
		//Arrange	
		TimeSeriesItemDate date1 = new TimeSeriesItemDate(2001);
		TimeSeriesItemDate date2 = new TimeSeriesItemDate(2000, 1);	
		TimeSeriesItemDate date3 = new TimeSeriesItemDate(2001);
		TimeSeriesItemDate date4 = new TimeSeriesItemDate(2000, 1);	
		
		//Act
		int res1 = date1.compareTo(date3);
		int res2 = date3.compareTo(date1);
		int res3 = date1.compareTo(date1);
		int res4 = date2.compareTo(date4);
		int res5 = date4.compareTo(date2);
		int res6 = date2.compareTo(date2);
		
		//Assert
		assertEquals(0, res1);
		assertEquals(0, res2);
		assertEquals(0, res3);
		assertEquals(0, res4);
		assertEquals(0, res5);
		assertEquals(0, res6);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void compareTo_otherDateIsInvalid_throwsUnsupportedOperationException() {
		//Arrange	
		TimeSeriesItemDate date1 = new TimeSeriesItemDate(2001);
		TimeSeriesItemDate date2 = new TimeSeriesItemDate();
		
		//Act
		date1.compareTo(date2);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void compareTo_thisDateIsInvalid_throwsUnsupportedOperationException() {
		//Arrange	
		TimeSeriesItemDate date1 = new TimeSeriesItemDate(2001);
		TimeSeriesItemDate date2 = new TimeSeriesItemDate();
		
		//Act
		date2.compareTo(date1);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void compareTo_bothDatesInvalid_throwsUnsupportedOperationException() {
		//Arrange	
		TimeSeriesItemDate date1 = new TimeSeriesItemDate();
		TimeSeriesItemDate date2 = new TimeSeriesItemDate();
		
		//Act
		date1.compareTo(date2);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void compareTo_differentValidDatesFormats_throwsUnsupportedOperationException() {
		//Arrange	
		TimeSeriesItemDate date1 = new TimeSeriesItemDate(2000);
		TimeSeriesItemDate date2 = new TimeSeriesItemDate(2000, 1);
		
		//Act
		date1.compareTo(date2);
	}
	
	@Test
	public void compareTo_otherDateIsBefore_returnsMinusOne() {
		//Arrange	
		TimeSeriesItemDate date1 = new TimeSeriesItemDate(2000);
		TimeSeriesItemDate date2 = new TimeSeriesItemDate(2000, 4);	
		TimeSeriesItemDate date3 = new TimeSeriesItemDate(2001);
		TimeSeriesItemDate date4 = new TimeSeriesItemDate(2001, 1);	
		
		//Act
		int res1 = date1.compareTo(date3);
		int res2 = date2.compareTo(date4);
		
		//Assert
		assertEquals(-1, res1);
		assertEquals(-1, res2);
	}
	
	@Test
	public void compareTo_otherDateIsAfter_returnsMinusOne() {
		//Arrange	
		TimeSeriesItemDate date1 = new TimeSeriesItemDate(2000);
		TimeSeriesItemDate date2 = new TimeSeriesItemDate(2000, 4);	
		TimeSeriesItemDate date3 = new TimeSeriesItemDate(2001);
		TimeSeriesItemDate date4 = new TimeSeriesItemDate(2001, 1);	
		
		//Act
		int res1 = date3.compareTo(date1);
		int res2 = date4.compareTo(date2);
		
		//Assert
		assertEquals(1, res1);
		assertEquals(1, res2);
	}
	
	@Test
	public void equals_otherIsNull_returnsFalse() {
		//Arrange	
		TimeSeriesItemDate date1 = new TimeSeriesItemDate(2000);
		
		//Act
		boolean res = date1.equals(null);
		
		//Assert
		assertFalse(res);
	}
	
	@Test
	public void equals_otherIsObject_returnsFalse() {
		//Arrange	
		TimeSeriesItemDate date1 = new TimeSeriesItemDate(2000);
		Object o = new Object();
		
		//Act
		boolean res = date1.equals(o);
		
		//Assert
		assertFalse(res);
	}
	
	@Test
	public void equals_sameObject_returnsTrue() {
		//Arrange	
		TimeSeriesItemDate date1 = new TimeSeriesItemDate(2000);
		
		//Act
		boolean res = date1.equals(date1);
		
		//Assert
		assertTrue(res);
	}
	
	@Test
	public void equals_differentDateFormats_returnsFalse() {
		//Arrange
		TimeSeriesItemDate date1 = new TimeSeriesItemDate();	
		TimeSeriesItemDate date2 = new TimeSeriesItemDate(2000);
		TimeSeriesItemDate date3 = new TimeSeriesItemDate(2000, 1);		
		
		//Act
		boolean equal1 = date1.equals(date2);
		boolean equal2 = date1.equals(date3);
		boolean equal3 = date2.equals(date1);
		boolean equal4 = date2.equals(date3);
		boolean equal5 = date3.equals(date1);
		boolean equal6 = date3.equals(date2);
		
		//Assert
		assertFalse(equal1);
		assertFalse(equal2);
		assertFalse(equal3);
		assertFalse(equal4);
		assertFalse(equal5);
		assertFalse(equal6);
	}
	
	@Test
	public void equals_sameDateFormatDifferentDate_returnsFalse() {
		//Arrange
		TimeSeriesItemDate date1 = new TimeSeriesItemDate();	
		TimeSeriesItemDate date2 = new TimeSeriesItemDate();	
		date2.setQuarter(1);
		
		TimeSeriesItemDate date3 = new TimeSeriesItemDate(2000);
		TimeSeriesItemDate date4 = new TimeSeriesItemDate(2001);
		
		TimeSeriesItemDate date5 = new TimeSeriesItemDate(2000, 1);		
		TimeSeriesItemDate date6 = new TimeSeriesItemDate(2000, 2);		
		
		//Act
		boolean equal1 = date1.equals(date2);
		boolean equal2 = date2.equals(date1);
		boolean equal3 = date3.equals(date4);
		boolean equal4 = date4.equals(date3);
		boolean equal5 = date5.equals(date6);
		boolean equal6 = date6.equals(date5);
		
		//Assert
		assertFalse(equal1);
		assertFalse(equal2);
		assertFalse(equal3);
		assertFalse(equal4);
		assertFalse(equal5);
		assertFalse(equal6);
	}
	
	@Test
	public void equals_sameDateFormatSameDate_returnsTrue() {
		//Arrange
		TimeSeriesItemDate date1 = new TimeSeriesItemDate();	
		TimeSeriesItemDate date2 = new TimeSeriesItemDate();	
		
		TimeSeriesItemDate date3 = new TimeSeriesItemDate();	
		date3.setQuarter(1);
		TimeSeriesItemDate date4 = new TimeSeriesItemDate();	
		date4.setQuarter(1);
		
		TimeSeriesItemDate date5 = new TimeSeriesItemDate(2000);
		TimeSeriesItemDate date6 = new TimeSeriesItemDate(2000);
		
		TimeSeriesItemDate date7 = new TimeSeriesItemDate(2000, 2);		
		TimeSeriesItemDate date8 = new TimeSeriesItemDate(2000, 2);		
		
		//Act
		boolean equal1 = date1.equals(date2);
		boolean equal2 = date2.equals(date1);
		boolean equal3 = date3.equals(date4);
		boolean equal4 = date4.equals(date3);
		boolean equal5 = date5.equals(date6);
		boolean equal6 = date6.equals(date5);
		boolean equal7 = date7.equals(date8);
		boolean equal8 = date8.equals(date7);
		
		//Assert
		assertTrue(equal1);
		assertTrue(equal2);
		assertTrue(equal3);
		assertTrue(equal4);
		assertTrue(equal5);
		assertTrue(equal6);
		assertTrue(equal7);
		assertTrue(equal8);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void getNextDate_InvalidDatesFormat_throwsUnsupportedOperationException() {
		//Arrange	
		TimeSeriesItemDate date1 = new TimeSeriesItemDate();
		
		//Act
		date1.getNextDate();
	}
		
	@Test(expected = UnsupportedOperationException.class)
	public void getPrevDate_InvalidDatesFormat_throwsUnsupportedOperationException() {
		//Arrange	
		TimeSeriesItemDate date1 = new TimeSeriesItemDate();
		
		//Act
		date1.getPrevDate();
	}
	
	@Test
	public void getNextDate_dateFormatYear_returnsCorrectNextDate() {
		//Arrange	
		TimeSeriesItemDate date1 = new TimeSeriesItemDate(2000);
		TimeSeriesItemDate expectedNextDate = new TimeSeriesItemDate(2001);
		
		//Act
		 TimeSeriesItemDate actualNextDate = date1.getNextDate();
		
		//Assert
		 assertEquals(expectedNextDate, actualNextDate);
	}
	
	@Test
	public void getPrevDate_dateFormatYear_returnsCorrectPrevDate() {
		//Arrange	
		TimeSeriesItemDate date1 = new TimeSeriesItemDate(2000);
		TimeSeriesItemDate expectedPrevDate = new TimeSeriesItemDate(1999);
		
		//Act
		 TimeSeriesItemDate actualPrevDate = date1.getPrevDate();
		
		//Assert
		 assertEquals(expectedPrevDate, actualPrevDate);
	}
	
	@Test
	public void getNextDate_dateFormatYearQuarter_returnsCorrectNextDate() {
		//Arrange	
		TimeSeriesItemDate date1 = new TimeSeriesItemDate(2000, 4);
		TimeSeriesItemDate expectedNextDate1 = new TimeSeriesItemDate(2001, 1);
		TimeSeriesItemDate expectedNextDate2 = new TimeSeriesItemDate(2001, 2);
		
		//Act
		 TimeSeriesItemDate actualNextDate1 = date1.getNextDate();
		 TimeSeriesItemDate actualNextDate2 = actualNextDate1.getNextDate();
		
		//Assert
		 assertEquals(expectedNextDate1, actualNextDate1);
		 assertEquals(expectedNextDate2, actualNextDate2);
	}
	
	@Test
	public void getPrevDate_dateFormatYearQuarter_returnsCorrectPrevDate() {
		//Arrange	
		TimeSeriesItemDate date1 = new TimeSeriesItemDate(2000, 1);
		TimeSeriesItemDate expectedPrevDate1 = new TimeSeriesItemDate(1999, 4);
		TimeSeriesItemDate expectedPrevDate2 = new TimeSeriesItemDate(1999, 3);
		
		//Act
		 TimeSeriesItemDate actualPrevDate1 = date1.getPrevDate();
		 TimeSeriesItemDate actualPrevDate2 = actualPrevDate1.getPrevDate();
		 
		//Assert
		 assertEquals(expectedPrevDate1, actualPrevDate1);
		 assertEquals(expectedPrevDate2, actualPrevDate2);
	}
}