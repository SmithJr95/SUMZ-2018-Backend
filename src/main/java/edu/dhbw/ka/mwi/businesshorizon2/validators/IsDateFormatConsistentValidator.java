package edu.dhbw.ka.mwi.businesshorizon2.validators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.TimeSeriesItem;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioPostRequestDto;

public class IsDateFormatConsistentValidator implements ConstraintValidator<IsDateFormatConsistent, ScenarioPostRequestDto>{
	
	public enum DateFormats{
		Invalid,
		Year,
		YearQuarter
	}
	
	@Override
	public boolean isValid(ScenarioPostRequestDto arg0, ConstraintValidatorContext arg1) {
		
		ArrayList<TimeSeriesItem> timeSeriesItems = new ArrayList<TimeSeriesItem>();
		
		if (arg0.getAdditionalIncome() != null && arg0.getAdditionalIncome().getTimeSeries() != null)
			timeSeriesItems.addAll(Arrays.asList(arg0.getAdditionalIncome().getTimeSeries()));
		if (arg0.getAdditionalCosts() != null && arg0.getAdditionalCosts().getTimeSeries() != null)
			timeSeriesItems.addAll(Arrays.asList(arg0.getAdditionalCosts().getTimeSeries()));
		if (arg0.getInvestments() != null && arg0.getInvestments().getTimeSeries() != null)
			timeSeriesItems.addAll(Arrays.asList(arg0.getInvestments().getTimeSeries()));
		if (arg0.getDivestments() != null && arg0.getDivestments().getTimeSeries() != null)
			timeSeriesItems.addAll(Arrays.asList(arg0.getDivestments().getTimeSeries()));
		if (arg0.getRevenue() != null && arg0.getRevenue().getTimeSeries() != null)
			timeSeriesItems.addAll(Arrays.asList(arg0.getRevenue().getTimeSeries()));
		if (arg0.getCostOfMaterial() != null && arg0.getCostOfMaterial().getTimeSeries() != null)
			timeSeriesItems.addAll(Arrays.asList(arg0.getCostOfMaterial().getTimeSeries()));
		if (arg0.getCostOfStaff() != null && arg0.getCostOfStaff().getTimeSeries() != null)
			timeSeriesItems.addAll(Arrays.asList(arg0.getCostOfStaff().getTimeSeries()));
		if (arg0.getLiabilities() != null && arg0.getLiabilities().getTimeSeries() != null)
			timeSeriesItems.addAll(Arrays.asList(arg0.getLiabilities().getTimeSeries()));
		if (arg0.getFreeCashFlows() != null && arg0.getFreeCashFlows().getTimeSeries() != null)
			timeSeriesItems.addAll(Arrays.asList(arg0.getFreeCashFlows().getTimeSeries()));
		if(arg0.getInterestOnLiabilities() != null && arg0.getInterestOnLiabilities().getTimeSeries() != null)
			timeSeriesItems.addAll(Arrays.asList(arg0.getInterestOnLiabilities().getTimeSeries()));
		if(arg0.getDepreciation() != null && arg0.getDepreciation().getTimeSeries() != null)
			timeSeriesItems.addAll(Arrays.asList(arg0.getDepreciation().getTimeSeries()));		
		
		DateFormats currentFormat = null;
		
		for (int i = 0; i < timeSeriesItems.size(); i++) {
			if (i == 0) {
				currentFormat = getDateFormat(timeSeriesItems.get(i));
				if (currentFormat == DateFormats.Invalid)
					return false;
			}
			else {
				if (!checkDateFormatConsistent(timeSeriesItems.get(i), currentFormat))
					return false;
			}
		}
		
		return true;
	}
	
	private DateFormats getDateFormat(TimeSeriesItem item) {
		if (item.getYear() != null && item.getQuarter() != null)
			return DateFormats.YearQuarter;
		else if (item.getYear() != null && item.getQuarter() == null)
			return DateFormats.Year;
		else 
			return DateFormats.Invalid;
	}
	
	private boolean checkDateFormatConsistent(TimeSeriesItem item, DateFormats expectedFormat) {
		if (expectedFormat == DateFormats.YearQuarter) 
			return (item.getYear() != null && item.getQuarter() != null);
		else if (expectedFormat == DateFormats.Year)
			return (item.getYear() != null && item.getQuarter() == null);
		else 
			return false;
	}
}
