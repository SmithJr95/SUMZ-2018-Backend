package edu.dhbw.ka.mwi.businesshorizon2.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigure;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioPostRequestDto;

public class IsContinuousTimeSeriesValidator implements ConstraintValidator<IsContinuousTimeSeries, ScenarioPostRequestDto>{
	
	@Override
	public boolean isValid(ScenarioPostRequestDto arg0, ConstraintValidatorContext arg1) {
		for(MultiPeriodAccountingFigure accountingFigure : arg0.getAllMultiPeriodAccountingFigures()) {
			if(accountingFigure != null && accountingFigure.getTimeSeries() != null && !accountingFigure.isTimeSeriesContinuous()) {				
				return false;
			}
		}	
		
		return true;
	}
}
