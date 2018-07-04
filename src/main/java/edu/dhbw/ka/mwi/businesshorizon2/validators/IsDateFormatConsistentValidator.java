package edu.dhbw.ka.mwi.businesshorizon2.validators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.MultiPeriodAccountingFigureRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioPostRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemDateDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemDto;

@Component
public class IsDateFormatConsistentValidator implements ConstraintValidator<IsDateFormatConsistent, ScenarioPostRequestDto>{
	
	public enum DateFormats{
		Invalid,
		Year,
		YearQuarter
	}
	
	@Override
	public boolean isValid(ScenarioPostRequestDto arg0, ConstraintValidatorContext arg1) {
		
		List<TimeSeriesItemDateDto> timeSeriesItemDates = new ArrayList<TimeSeriesItemDateDto>();
		
		for (MultiPeriodAccountingFigureRequestDto figure : arg0.getAllMultiPeriodAccountingFigures()) {
			if(figure != null && figure.getTimeSeries() != null) {
				for (TimeSeriesItemDto item : figure.getTimeSeries()) {
					if(item != null && item.getDate() != null) {
						timeSeriesItemDates.add(item.getDate());
					}
				}
			}
		}
		
		for (int i = 0; i < timeSeriesItemDates.size() - 1; i++) {
			if(!timeSeriesItemDates.get(i).dateFormatsEqual(timeSeriesItemDates.get(i+1))) {
				return false;
			}
		}
		
		return true;
	}
}
