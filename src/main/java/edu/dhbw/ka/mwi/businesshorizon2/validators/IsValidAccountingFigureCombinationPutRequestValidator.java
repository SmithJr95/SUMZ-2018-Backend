package edu.dhbw.ka.mwi.businesshorizon2.validators;

import java.util.EnumSet;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigureNames;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.MultiPeriodAccountingFigureRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioPostRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioPutRequestDto;

public class IsValidAccountingFigureCombinationPutRequestValidator implements ConstraintValidator<IsValidAccountingFigureCombinationPutRequest, ScenarioPutRequestDto> {
	@Override
	public boolean isValid(ScenarioPutRequestDto arg0, ConstraintValidatorContext arg1) {
		
		EnumSet<MultiPeriodAccountingFigureNames> validCombination1 = EnumSet.of(
				MultiPeriodAccountingFigureNames.Liabilities,
				MultiPeriodAccountingFigureNames.FreeCashFlows);
		
		EnumSet<MultiPeriodAccountingFigureNames> validCombination2 = EnumSet.of(
				MultiPeriodAccountingFigureNames.Liabilities,
				MultiPeriodAccountingFigureNames.AdditionalCosts,
				MultiPeriodAccountingFigureNames.AdditionalIncome,
				MultiPeriodAccountingFigureNames.CostOfMaterial,
				MultiPeriodAccountingFigureNames.CostOfStaff,
				MultiPeriodAccountingFigureNames.Depreciation,
				MultiPeriodAccountingFigureNames.Divestments,
				MultiPeriodAccountingFigureNames.Investments,
				MultiPeriodAccountingFigureNames.Revenue);
		
		List<MultiPeriodAccountingFigureRequestDto> multiPeriodAccountingFigures = arg0.getAllMultiPeriodAccountingFigures();
		multiPeriodAccountingFigures.removeIf(x -> x == null);
		
		for(MultiPeriodAccountingFigureRequestDto dto : multiPeriodAccountingFigures) {
			System.out.println(dto.getFigureName().name());
		}
		
		EnumSet<MultiPeriodAccountingFigureNames> actualCombination = EnumSet.noneOf(MultiPeriodAccountingFigureNames.class);
		for (MultiPeriodAccountingFigureRequestDto figure : multiPeriodAccountingFigures) {
			actualCombination.add(figure.getFigureName());
		}
		
		if(actualCombination.equals(validCombination1) || actualCombination.equals(validCombination2)) {
			return true;
		}
		
		
		return false;
	}
}
