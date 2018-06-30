package edu.dhbw.ka.mwi.businesshorizon2.comparators;
import java.util.Comparator;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.TimeSeriesItem;

public class TimeSeriesItemByDateComparator implements Comparator<TimeSeriesItem> {

	@Override
	public int compare(TimeSeriesItem o1, TimeSeriesItem o2) {
		if(o1 == o2) {
			return 0;
		}
		
		if(o1 == null || o2 == null || o1.getDate()  == null || o2.getDate() == null) {
			throw new UnsupportedOperationException();
		}
		
		return o1.getDate().compareTo(o2.getDate());
	}

}
