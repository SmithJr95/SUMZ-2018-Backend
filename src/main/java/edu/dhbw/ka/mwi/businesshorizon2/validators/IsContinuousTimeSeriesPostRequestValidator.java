package edu.dhbw.ka.mwi.businesshorizon2.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.MultiPeriodAccountingFigureRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioPostRequestDto;

@Component
public class IsContinuousTimeSeriesPostRequestValidator implements ConstraintValidator<IsContinuousTimeSeriesPostRequest, ScenarioPostRequestDto>{
	
	@Override
	public boolean isValid(ScenarioPostRequestDto arg0, ConstraintValidatorContext arg1) {
		for(MultiPeriodAccountingFigureRequestDto accountingFigure : arg0.getAllMultiPeriodAccountingFigures()) {
			if(accountingFigure != null && accountingFigure.getTimeSeries() != null && !accountingFigure.isTimeSeriesContinuous()) {				
				return false;
			}
		}	
		
		return true;
	}
}
