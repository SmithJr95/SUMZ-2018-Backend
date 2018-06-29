package edu.dhbw.ka.mwi.businesshorizon2.validators;

import java.util.EnumSet;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigure;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigureNames;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioPostRequestDto;

public class IsValidAccountingFigureCombinationValidator implements ConstraintValidator<IsValidAccountingFigureCombination, ScenarioPostRequestDto> {

	@Override
	public boolean isValid(ScenarioPostRequestDto arg0, ConstraintValidatorContext arg1) {
		
		EnumSet<MultiPeriodAccountingFigureNames> validCombination1 = EnumSet.of(
				MultiPeriodAccountingFigureNames.Liabilities,
				MultiPeriodAccountingFigureNames.FreeCashFlows,
				MultiPeriodAccountingFigureNames.InterestOnLiabilities);
		
		EnumSet<MultiPeriodAccountingFigureNames> validCombination2 = EnumSet.of(
				MultiPeriodAccountingFigureNames.Liabilities,
				MultiPeriodAccountingFigureNames.InterestOnLiabilities,
				MultiPeriodAccountingFigureNames.AdditionalCosts,
				MultiPeriodAccountingFigureNames.AdditionalIncome,
				MultiPeriodAccountingFigureNames.CostOfMaterial,
				MultiPeriodAccountingFigureNames.CostOfStaff,
				MultiPeriodAccountingFigureNames.Depreciation,
				MultiPeriodAccountingFigureNames.Divestments,
				MultiPeriodAccountingFigureNames.Investments,
				MultiPeriodAccountingFigureNames.Revenue);
		
		List<MultiPeriodAccountingFigure> multiPeriodAccountingFigures = arg0.getAllMultiPeriodAccountingFigures();
		multiPeriodAccountingFigures.removeIf(x -> x == null);
		
		EnumSet<MultiPeriodAccountingFigureNames> actualCombination = EnumSet.noneOf(MultiPeriodAccountingFigureNames.class);
		for (MultiPeriodAccountingFigure figure : multiPeriodAccountingFigures) {
			actualCombination.add(figure.getFigureName());
		}
		
		if(actualCombination.equals(validCombination1) || actualCombination.equals(validCombination2)) {
			return true;
		}
		
		
		return false;
	}
	
}
