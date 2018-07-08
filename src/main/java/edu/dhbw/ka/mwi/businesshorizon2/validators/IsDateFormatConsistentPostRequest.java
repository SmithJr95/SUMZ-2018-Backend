package edu.dhbw.ka.mwi.businesshorizon2.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { IsDateFormatConsistentPostRequestValidator.class })
public @interface IsDateFormatConsistentPostRequest {
	public final String acceptedDateFormat1 = "(year + quarter)";
	public final String acceptedDateFormat2 = "(year)";
	
	String message() default "The date format of all time series items for all accounting figures must be one of {" + acceptedDateFormat1 + ", " + acceptedDateFormat2 + "}";
	 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
}
