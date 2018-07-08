package edu.dhbw.ka.mwi.businesshorizon2.validators;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.MultiPeriodAccountingFigureRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioPutRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemDateRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemRequestDto;

public class IsDateFormatConsistentPutRequestValidator implements ConstraintValidator<IsDateFormatConsistentPutRequest, ScenarioPutRequestDto>{
	public enum DateFormats{
		Invalid,
		Year,
		YearQuarter
	}
	
	@Override
	public boolean isValid(ScenarioPutRequestDto arg0, ConstraintValidatorContext arg1) {
		
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
