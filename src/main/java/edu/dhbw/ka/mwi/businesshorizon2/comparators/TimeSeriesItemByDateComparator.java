package edu.dhbw.ka.mwi.businesshorizon2.comparators;
import java.util.Comparator;

import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemRequestDto;

public class TimeSeriesItemByDateComparator implements Comparator<TimeSeriesItemRequestDto> {

	@Override
	public int compare(TimeSeriesItemRequestDto o1, TimeSeriesItemRequestDto o2) {
		if(o1 == o2) {
			return 0;
		}
		
		if(o1 == null || o2 == null || o1.getDate()  == null || o2.getDate() == null) {
			throw new UnsupportedOperationException();
		}
		
		return o1.getDate().compareTo(o2.getDate());
	}

}
