package edu.dhbw.ka.mwi.businesshorizon2.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioPostRequestDto;

public class IsValidAccountingFigureCombinationValidator implements ConstraintValidator<IsValidAccountingFigureCombination, ScenarioPostRequestDto> {

	@Override
	public boolean isValid(ScenarioPostRequestDto arg0, ConstraintValidatorContext arg1) {
		
		boolean additionalIncomeIsNull = arg0.getAdditionalIncome() == null;
		boolean additionalCostsIsNull = arg0.getAdditionalCosts() == null;;
		boolean investmentsIsNull = arg0.getInvestments() == null;
		boolean divestmentsIsNull = arg0.getDivestments() == null;
		boolean revenueIsNull = arg0.getRevenue() == null;
		boolean costOfMaterialisNull = arg0.getCostOfMaterial() == null;
		boolean costOfStaffIsNull = arg0.getCostOfStaff() == null;
		boolean liabilitiesIsNull = arg0.getLiabilities() == null;
		boolean freeCashFlowsIsNull = arg0.getFreeCashFlows() == null;
		boolean interestOnLiabilitiesIsNull = arg0.getInterestOnLiabilities() == null;
		boolean depreciationIsNull = arg0.getDepreciation() == null;
		
		if (!liabilitiesIsNull 
				&& !freeCashFlowsIsNull 
				&& !interestOnLiabilitiesIsNull
				&& depreciationIsNull
				&& additionalIncomeIsNull
				&& additionalCostsIsNull
				&& investmentsIsNull
				&& divestmentsIsNull
				&& revenueIsNull
				&& costOfMaterialisNull
				&& costOfStaffIsNull)
			return true;
		
		if (!liabilitiesIsNull 
				&& freeCashFlowsIsNull 
				&& !interestOnLiabilitiesIsNull
				&& !depreciationIsNull
				&& !additionalIncomeIsNull
				&& !additionalCostsIsNull
				&& !investmentsIsNull
				&& !divestmentsIsNull
				&& !revenueIsNull
				&& !costOfMaterialisNull
				&& !costOfStaffIsNull)
			return true;
		
		return false;
	}
	
}
