package edu.dhbw.ka.mwi.businesshorizon2.validators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigure;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.TimeSeriesDateFormats;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.TimeSeriesItem;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioPostRequestDto;

public class IsContinuousTimeSeriesValidator implements ConstraintValidator<IsContinuousTimeSeries, ScenarioPostRequestDto>{
	
	@Override
	public boolean isValid(ScenarioPostRequestDto arg0, ConstraintValidatorContext arg1) {
		for(MultiPeriodAccountingFigure accountingFigure : arg0.getAllMultiPeriodAccountingFigures()) {
			if(accountingFigure != null && accountingFigure.getTimeSeries() != null) {				
				if (!this.isTimeSeriesContinuous(Arrays.asList(accountingFigure.getTimeSeries()))) {
					return false;
				}
			}
		}	
		
		return true;
	}
	
	private boolean isTimeSeriesContinuous(List<TimeSeriesItem> timeSeriesItems) {
		if (timeSeriesItems.size() <= 1)
			return true;
		
		EnumSet<TimeSeriesDateFormats> dateFormatSet = EnumSet.noneOf(TimeSeriesDateFormats.class);
		
		if (timeSeriesItems.get(0).getYear() != null)
			dateFormatSet.add(TimeSeriesDateFormats.Year);
		if (timeSeriesItems.get(0).getQuarter() != null)
			dateFormatSet.add(TimeSeriesDateFormats.Quarter);
		
		if (dateFormatSet.equals(EnumSet.of(TimeSeriesDateFormats.Year))){
			timeSeriesItems.sort(new Comparator<TimeSeriesItem>() {
				@Override
				public int compare(TimeSeriesItem lhs, TimeSeriesItem rhs) {
					if (lhs.getYear().equals(rhs.getYear()))
						return 0;
					else 
						return lhs.getYear() < rhs.getYear() ? -1 : 1;
				}
			});
		}
		else if (dateFormatSet.equals(EnumSet.of(TimeSeriesDateFormats.Year, TimeSeriesDateFormats.Quarter))) {
			timeSeriesItems.sort(new Comparator<TimeSeriesItem>() {
				@Override
				public int compare(TimeSeriesItem lhs, TimeSeriesItem rhs) {
					if(lhs.getYear() < rhs.getYear())
						return -1;
					else if (lhs.getYear() > rhs.getYear())
						return 1;
					else {
						if(lhs.getQuarter().equals(rhs.getQuarter()))
							return 0;
						else 
							return lhs.getQuarter() < rhs.getQuarter() ? -1 : 1;
					}
				}
			});
		}
		else {
			throw new UnsupportedOperationException();
		}
		
		if(dateFormatSet.equals(EnumSet.of(TimeSeriesDateFormats.Year))) {
			for (int i = 0; i < timeSeriesItems.size() - 1; i++) {
				if(!(timeSeriesItems.get(i+1).getYear().equals(timeSeriesItems.get(i).getYear() + 1))) {
					return false;
				}
			}
		}
		if(dateFormatSet.equals(EnumSet.of(TimeSeriesDateFormats.Year, TimeSeriesDateFormats.Quarter))){
			Integer currentYear;
			Integer expectedNextYear;
			Integer currentQuarter;
			Integer expectedNextQuarter;
			
			for (int i = 0; i < timeSeriesItems.size() - 1; i++) {
				currentYear = timeSeriesItems.get(i).getYear();
				currentQuarter = timeSeriesItems.get(i).getQuarter();
				
				if(currentQuarter.equals(4)) {
					expectedNextYear = currentYear + 1;
					expectedNextQuarter = 1;
				}
				else {
					expectedNextYear = currentYear;
					expectedNextQuarter = currentQuarter + 1;
				}
				
				if(!(timeSeriesItems.get(i+1).getQuarter().equals(expectedNextQuarter)) || !(timeSeriesItems.get(i+1).getYear().equals(expectedNextYear))) {
					return false;
				}
			}
		}
		
		return true;
	}

}
