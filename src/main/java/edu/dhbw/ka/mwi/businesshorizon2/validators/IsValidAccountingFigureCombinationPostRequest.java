package edu.dhbw.ka.mwi.businesshorizon2.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.Valid;

import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.MultiPeriodAccountingFigureRequestDto;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { IsValidAccountingFigureCombinationPostRequestValidator.class })
public @interface IsValidAccountingFigureCombinationPostRequest {
	public final String validCombination1 = "{additionalIncome, depreciation, additionalCosts, investments, divestments, revenue, costOfMaterial, costOfStaff, liabilities}";
	public final String validCombination2 = "{liabilities, freeCashFlows}";
	
	String message() default "The only acceptable combination of accounting figures are " + validCombination1 + " and " + validCombination2;
	 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
}