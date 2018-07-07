package edu.dhbw.ka.mwi.businesshorizon2.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.IScenarioService;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IAppUserRepository;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IApvCompanyValuationResultRepository;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.ICompanyValueDistributionPointRepository;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IFcfCompanyValuationResultRepository;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IFteCompanyValuationResultRepository;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IMultiPeriodAccountingFigureRepository;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IScenarioGraphRepository;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IScenarioRepository;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.ITimeSeriesItemDateRepository;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.ITimeSeriesItemRepository;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigureNames;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.ApvCompanyValuationResultDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.CompanyValueDistributionPointDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.FcfCompanyValuationResultDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.FteCompanyValuationResultDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.MultiPeriodAccountingFigureDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.ScenarioDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.TimeSeriesItemDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.TimeSeriesItemDateDao;

@RestController
@RequestMapping("/scenariostest")
public class ScenarioTestController {

	@Autowired
	private IScenarioGraphRepository scenarioGraphRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public void get() {
		
		ScenarioDao dao = new ScenarioDao();
		
		dao.setEquityInterestRate(0.5);
		dao.setInterestOnLiabilitiesRate(0.5);
		dao.setForecastPeriods(3);
		dao.setBusinessTaxRate(0.5);
		dao.setCorporateTaxRate(0.5);
		dao.setScenarioDescription("descirption...");
		dao.setScenarioName("name...");
		dao.setSolidaryTaxRate(0.5);
		
		ApvCompanyValuationResultDao apvRes = new ApvCompanyValuationResultDao(100.0, 100.0, 100.0, 100.0, 100.0);
		FteCompanyValuationResultDao fteRes = new FteCompanyValuationResultDao(100.0);
		FcfCompanyValuationResultDao fcfRes = new FcfCompanyValuationResultDao(100.0, 100.0, 100.0);
		dao.setApvCompanyValuationResultDao(apvRes);
		dao.setFteCompanyValuationResultDao(fteRes);
		dao.setFcfCompanyValuationResultDao(fcfRes);
		
		List<CompanyValueDistributionPointDao> points = new ArrayList<>();
		points.add(new CompanyValueDistributionPointDao(100.0, 100.0));
		points.add(new CompanyValueDistributionPointDao(200.0, 200.0));
		points.add(new CompanyValueDistributionPointDao(100.0, 300.0));
		dao.setCompanyValueDistributionPoints(points);
		
		List<TimeSeriesItemDao> items1 = new ArrayList<>();
		items1.add(new TimeSeriesItemDao(100.0, new TimeSeriesItemDateDao(2000)));
		items1.add(new TimeSeriesItemDao(100.0, new TimeSeriesItemDateDao(2001)));
		
		List<TimeSeriesItemDao> items2 = new ArrayList<>();
		items2.add(new TimeSeriesItemDao(200.0, new TimeSeriesItemDateDao(2000, 1)));
		items2.add(new TimeSeriesItemDao(200.0, new TimeSeriesItemDateDao(2000, 2)));
		
		List<MultiPeriodAccountingFigureDao> multis = new ArrayList<>();
		multis.add(new MultiPeriodAccountingFigureDao(MultiPeriodAccountingFigureNames.CostOfMaterial.name(), true, items1));
		multis.add(new MultiPeriodAccountingFigureDao(MultiPeriodAccountingFigureNames.FreeCashFlows.name(), false, items2));
		
		dao.setMultiPeriodAccountingFigures(multis);
		
		scenarioGraphRepository.createOrUpdate(dao, new Long(2));
	}
}
