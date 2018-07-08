package edu.dhbw.ka.mwi.businesshorizon2.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { IsValidTimeSeriesRangesPostRequestValidator.class })
public @interface IsValidTimeSeriesRangesPostRequest {
	String message() default "The time series are not correctly aligned or do not have the required length as dictated by the value of 'periods'.";
	 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
}
