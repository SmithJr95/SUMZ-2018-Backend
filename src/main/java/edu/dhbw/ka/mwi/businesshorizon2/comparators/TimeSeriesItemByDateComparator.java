package edu.dhbw.ka.mwi.businesshorizon2.comparators;
import java.util.Comparator;

import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemDto;

public class TimeSeriesItemByDateComparator implements Comparator<TimeSeriesItemDto> {

	@Override
	public int compare(TimeSeriesItemDto o1, TimeSeriesItemDto o2) {
		if(o1 == o2) {
			return 0;
		}
		
		if(o1 == null || o2 == null || o1.getDate()  == null || o2.getDate() == null) {
			throw new UnsupportedOperationException();
		}
		
		return o1.getDate().compareTo(o2.getDate());
	}

}
