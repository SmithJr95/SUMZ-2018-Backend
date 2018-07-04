package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces;

import java.util.HashMap;
import java.util.List;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigureNames;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.MultiPeriodAccountingFigureRequestDto;

public interface ITimeSeriesPredictionService {
	public void MakePredictions(
			List<MultiPeriodAccountingFigureRequestDto> historicAccountingFigures, 
			HashMap<MultiPeriodAccountingFigureNames, HashMap<Integer, List<Double>>> stochasticAccountingFigures,
			Integer periods,
			Integer numSamples);
}
