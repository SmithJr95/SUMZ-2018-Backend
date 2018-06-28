package edu.dhbw.ka.mwi.businesshorizon2.validators;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigure;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigureNames;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.TimeSeriesItem;
import edu.dhbw.ka.mwi.businesshorizon2.models.comparators.TimeSeriesItemDateComparator;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioPostRequestDto;

public class IsValidTimeSeriesRangesValidator implements ConstraintValidator<IsValidTimeSeriesRanges, ScenarioPostRequestDto> {

	@Override
	public boolean isValid(ScenarioPostRequestDto arg0, ConstraintValidatorContext arg1) {
		
		List<MultiPeriodAccountingFigure> historicMultiPeriodAccountingFigures = arg0.getAllMultiPeriodAccountingFigures();
		historicMultiPeriodAccountingFigures.removeIf(x -> x == null || x.getTimeSeries() == null || x.getIsHistoric().equals(false));
		
		List<MultiPeriodAccountingFigure> futureMultiPeriodAccountingFigures = arg0.getAllMultiPeriodAccountingFigures();
		futureMultiPeriodAccountingFigures.removeIf(x -> x == null || x.getTimeSeries() == null || x.getIsHistoric().equals(true));
		
		if (historicMultiPeriodAccountingFigures.isEmpty() && futureMultiPeriodAccountingFigures.isEmpty()) {
			return true;
		}
		
		int periods = arg0.getPeriods();
		
		for(int i = 0; i < historicMultiPeriodAccountingFigures.size() - 1; i++) {
			TimeSeriesItem max1 = Collections.max(Arrays.asList(historicMultiPeriodAccountingFigures.get(i).getTimeSeries()), new TimeSeriesItemDateComparator());
			TimeSeriesItem max2 = Collections.max(Arrays.asList(historicMultiPeriodAccountingFigures.get(i + 1).getTimeSeries()), new TimeSeriesItemDateComparator());
			
			if (!max1.datesEqual(max2)) {
				return false;
			}
		}
		
		for(int i = 0; i < futureMultiPeriodAccountingFigures.size() - 1; i++) {
			if(futureMultiPeriodAccountingFigures.get(i).getFigureName() == MultiPeriodAccountingFigureNames.Liabilities) {
				continue;
			}
			
			TimeSeriesItem min1 = Collections.min(Arrays.asList(futureMultiPeriodAccountingFigures.get(i).getTimeSeries()), new TimeSeriesItemDateComparator());
			TimeSeriesItem min2 = Collections.min(Arrays.asList(futureMultiPeriodAccountingFigures.get(i + 1).getTimeSeries()), new TimeSeriesItemDateComparator());
		
			if(!min1.datesEqual(min2)) {
				return false;
			}
		}
		
		
		
				
		return true;
	}

}
