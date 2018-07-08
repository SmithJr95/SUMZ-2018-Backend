package edu.dhbw.ka.mwi.businesshorizon2.validators;

import javax.validation.Payload;

public @interface IsDateFormatConsistentPutRequest {
	public final String acceptedDateFormat1 = "(year + quarter)";
	public final String acceptedDateFormat2 = "(year)";
	
	String message() default "The date format of all time series items for all accounting figures must be one of {" + acceptedDateFormat1 + ", " + acceptedDateFormat2 + "}";
	 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
}
