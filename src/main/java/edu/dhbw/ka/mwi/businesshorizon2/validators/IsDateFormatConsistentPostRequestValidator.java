package edu.dhbw.ka.mwi.businesshorizon2.validators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.MultiPeriodAccountingFigureRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioPostRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemDateRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemRequestDto;

@Component
public class IsDateFormatConsistentPostRequestValidator implements ConstraintValidator<IsDateFormatConsistentPostRequest, ScenarioPostRequestDto>{
	
	public enum DateFormats{
		Invalid,
		Year,
		YearQuarter
	}
	
	@Override
	public boolean isValid(ScenarioPostRequestDto arg0, ConstraintValidatorContext arg1) {
		
		List<TimeSeriesItemDateRequestDto> timeSeriesItemDates = new ArrayList<TimeSeriesItemDateRequestDto>();
		
		for (MultiPeriodAccountingFigureRequestDto figure : arg0.getAllMultiPeriodAccountingFigures()) {
			if(figure != null && figure.getTimeSeries() != null) {
				for (TimeSeriesItemRequestDto item : figure.getTimeSeries()) {
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
