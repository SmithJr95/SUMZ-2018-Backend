package edu.dhbw.ka.mwi.businesshorizon2.validators;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigureNames;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.MultiPeriodAccountingFigureRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemDateDto;

@Component
public class IsValidTimeSeriesRangesValidator implements ConstraintValidator<IsValidTimeSeriesRanges, ScenarioRequestDto> {

	@Override
	public boolean isValid(ScenarioRequestDto arg0, ConstraintValidatorContext arg1) {
		
		List<MultiPeriodAccountingFigureRequestDto> historicMultiPeriodAccountingFigures = arg0.getAllMultiPeriodAccountingFigures();
		historicMultiPeriodAccountingFigures.removeIf(x -> x == null || x.getTimeSeries() == null || x.getIsHistoric() == null || x.getIsHistoric().equals(false));
		
		List<MultiPeriodAccountingFigureRequestDto> futureMultiPeriodAccountingFigures = arg0.getAllMultiPeriodAccountingFigures();
		futureMultiPeriodAccountingFigures.removeIf(x -> x == null || x.getTimeSeries() == null || x.getIsHistoric() == null || x.getIsHistoric().equals(true));
		
		if (historicMultiPeriodAccountingFigures.isEmpty() && futureMultiPeriodAccountingFigures.isEmpty()) {
			return true;
		}
		
		TimeSeriesItemDateDto basisDate = null;
		
		for(int i = 0; i < historicMultiPeriodAccountingFigures.size(); i++) {
			
			if(historicMultiPeriodAccountingFigures.get(i).getTimeSeries().size() < 2) {
				return false;
			}
			
			TimeSeriesItemDateDto maxDate = historicMultiPeriodAccountingFigures.get(i).getMaxDate();
			if(maxDate == null) {
				return false;
			}
			
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
		
		if(arg0.getPeriods() == null) {
			return false;
		}
		
		int periods = arg0.getPeriods().intValue();
		
		for(int i = 0; i < futureMultiPeriodAccountingFigures.size(); i++) {
			
			if(periods != futureMultiPeriodAccountingFigures.get(i).getTimeSeries().size()) {
				return false;
			}
			
			TimeSeriesItemDateDto minDate;
			
			if(futureMultiPeriodAccountingFigures.get(i).getFigureName() == MultiPeriodAccountingFigureNames.Liabilities) {
				
				minDate = futureMultiPeriodAccountingFigures.get(i).getMinDate(); 
				if(minDate == null) {
					return false;
				}
				
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
			if(minDate == null) {
				return false;
			}
			
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
