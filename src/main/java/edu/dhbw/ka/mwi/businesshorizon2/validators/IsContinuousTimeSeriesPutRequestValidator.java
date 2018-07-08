package edu.dhbw.ka.mwi.businesshorizon2.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.MultiPeriodAccountingFigureRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioPutRequestDto;

public class IsContinuousTimeSeriesPutRequestValidator implements ConstraintValidator<IsContinuousTimeSeriesPutRequest, ScenarioPutRequestDto>{
	@Override
	public boolean isValid(ScenarioPutRequestDto arg0, ConstraintValidatorContext arg1) {
		for(MultiPeriodAccountingFigureRequestDto accountingFigure : arg0.getAllMultiPeriodAccountingFigures()) {
			if(accountingFigure != null && accountingFigure.getTimeSeries() != null && !accountingFigure.isTimeSeriesContinuous()) {				
				return false;
			}
		}	
		
		return true;
	}
}
