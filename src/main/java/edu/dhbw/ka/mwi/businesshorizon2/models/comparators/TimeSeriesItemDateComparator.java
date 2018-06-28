package edu.dhbw.ka.mwi.businesshorizon2.models.comparators;

import java.util.Comparator;
import java.util.EnumSet;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.TimeSeriesDateFormats;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.TimeSeriesItem;

public class TimeSeriesItemDateComparator implements Comparator<TimeSeriesItem>{

	@Override
	public int compare(TimeSeriesItem o1, TimeSeriesItem o2) {
		if(o1 == null || o2 == null)
			throw new IllegalArgumentException();
		
		if(o1 == o2) {
			return 0;
		}
		
		EnumSet<TimeSeriesDateFormats> o1DateFormatsSet = EnumSet.noneOf(TimeSeriesDateFormats.class);
		EnumSet<TimeSeriesDateFormats> o2DateFormatsSet = EnumSet.noneOf(TimeSeriesDateFormats.class);
		
		if(o1.getYear() != null) 
			o1DateFormatsSet.add(TimeSeriesDateFormats.Year);
		if(o1.getQuarter() != null) 
			o1DateFormatsSet.add(TimeSeriesDateFormats.Quarter);
		if(o2.getYear() != null) 
			o2DateFormatsSet.add(TimeSeriesDateFormats.Year);
		if(o2.getQuarter() != null)
			o2DateFormatsSet.add(TimeSeriesDateFormats.Quarter);
			
		if(!o1DateFormatsSet.equals(o2DateFormatsSet)) {
			throw new IllegalArgumentException("Date formats do not match: " + o1DateFormatsSet + " != " + o2DateFormatsSet + ".");
		}
		
		if (o1DateFormatsSet.equals(EnumSet.of(TimeSeriesDateFormats.Year))) {
			return o1.getYear().compareTo(o2.getYear());
		}
		else if(o1DateFormatsSet.equals(EnumSet.of(TimeSeriesDateFormats.Year, TimeSeriesDateFormats.Quarter))) {
			if(o1.getYear() < o2.getYear()) 
				return -1;
			else if (o1.getYear() > o2.getYear()) 
				return 1;
			else {
				if(o1.getQuarter() < o2.getQuarter())
					return -1;
				else if (o1.getQuarter() > o2.getQuarter())
					return 1;
				else 
					return 0;
			}
		}
		else {
			throw new UnsupportedOperationException("Date format : " + o1DateFormatsSet + " is not valid.");
		}
	}

}
