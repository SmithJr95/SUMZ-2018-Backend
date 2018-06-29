package edu.dhbw.ka.mwi.businesshorizon2.validators;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigure;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigureNames;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.TimeSeriesItemDate;
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
		
		TimeSeriesItemDate basisDate = null;
		
		for(int i = 0; i < historicMultiPeriodAccountingFigures.size(); i++) {
			TimeSeriesItemDate maxDate = historicMultiPeriodAccountingFigures.get(i).getMaxDate();
			
			if(basisDate == null) {
				basisDate = maxDate;
				continue;
			}
			else {
				if (!maxDate.equals(basisDate)) {
					return false;
				}
			}			
		}
		
		int periods = arg0.getPeriods();
		
		for(int i = 0; i < futureMultiPeriodAccountingFigures.size(); i++) {
			
			if(periods != futureMultiPeriodAccountingFigures.get(i).getTimeSeries().size()) {
				return false;
			}
			
			TimeSeriesItemDate minDate;
			
			if(futureMultiPeriodAccountingFigures.get(i).getFigureName() == MultiPeriodAccountingFigureNames.Liabilities) {
				
				minDate = futureMultiPeriodAccountingFigures.get(i).getMinDate(); 
				
				if(basisDate == null) {
					basisDate = minDate;
				}
				else {
					if(!basisDate.equals(minDate)) {
						return false;
					}
				}
				
				continue;
			}
			
			minDate = futureMultiPeriodAccountingFigures.get(i).getMinDate();
			
			if(basisDate == null) {
				basisDate = minDate.getPrevDate();
				continue;
			}
			else {
				if(!basisDate.equals(minDate.getPrevDate())){
					return false;
				}
			}
		}
				
		return true;
	}

}
