package edu.dhbw.ka.mwi.businesshorizon2.dataaccess.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.AppUserDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.ApvCompanyValuationResultDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.CompanyValueDistributionPointDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.FcfCompanyValuationResultDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.FteCompanyValuationResultDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.MultiPeriodAccountingFigureDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.ScenarioDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.TimeSeriesItemDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.TimeSeriesItemDateDao;

@Repository
public class ScenarioGraphRepository implements IScenarioGraphRepository{
	
	@Autowired
	private IScenarioRepository scenarioRepository;
	
	@Autowired
	private IAppUserRepository appUserRepository;
	
	@Autowired
	private IMultiPeriodAccountingFigureRepository multiPeriodAccountingFigureRepository;
	
	@Autowired
	private ITimeSeriesItemRepository timeSeriesItemRepository;
	
	@Autowired
	private ITimeSeriesItemDateRepository timeSeriesItemDateRepository;
	
	@Autowired
	private IApvCompanyValuationResultRepository apvRepository;
	
	@Autowired
	private IFteCompanyValuationResultRepository fteRepository;
	
	@Autowired
	private IFcfCompanyValuationResultRepository fcfRepository;
	
	@Autowired
	private ICompanyValueDistributionPointRepository pointRepository;
	
	@Override
	public Long create(ScenarioDao scenario, Long appUserId) {
		
		ApvCompanyValuationResultDao apvResTemp = scenario.getApvCompanyValuationResultDao();
		FteCompanyValuationResultDao fteResTemp = scenario.getFteCompanyValuationResultDao();
		FcfCompanyValuationResultDao fcfResTemp = scenario.getFcfCompanyValuationResultDao();
		scenario.setApvCompanyValuationResultDao(null);
		scenario.setFteCompanyValuationResultDao(null);
		scenario.setFcfCompanyValuationResultDao(null);
		
		List<CompanyValueDistributionPointDao> companyValueDistributionPointsTemp = scenario.getCompanyValueDistributionPoints();
		scenario.setCompanyValueDistributionPoints(null);
		
		List<MultiPeriodAccountingFigureDao> multisPeriodAccountingFiguresTemp = scenario.getMultiPeriodAccountingFigures();
		scenario.setMultiPeriodAccountingFigures(null);
		
		AppUserDao appUser = appUserRepository.findById(appUserId).get();
		scenario.setAppUser(appUser);
		
		ScenarioDao daoInDb = scenarioRepository.save(scenario);
		apvResTemp.setScenario(daoInDb);
		fteResTemp.setScenario(daoInDb);
		fcfResTemp.setScenario(daoInDb);
		
		apvRepository.save(apvResTemp);
		fteRepository.save(fteResTemp);
		fcfRepository.save(fcfResTemp);
		
		if(companyValueDistributionPointsTemp != null) {
			for (CompanyValueDistributionPointDao point : companyValueDistributionPointsTemp) {
				point.setScenario(daoInDb);
				pointRepository.save(point);
			}
		}
		
		for(MultiPeriodAccountingFigureDao multiTemp : multisPeriodAccountingFiguresTemp) {
			List<TimeSeriesItemDao> tempItems = multiTemp.getTimeSeriesItems();
			multiTemp.setTimeSeriesItems(null);
			multiTemp.setScenario(daoInDb);
			MultiPeriodAccountingFigureDao multiTempInDb = multiPeriodAccountingFigureRepository.save(multiTemp);
			
			if(tempItems != null) {
				for (TimeSeriesItemDao item : tempItems) {
					TimeSeriesItemDateDao tempDate = item.getTimeSeriesItemDate();
					item.setTimeSeriesItemDate(null);
					item.setAccountingFigure(multiTempInDb);
					TimeSeriesItemDao itemInDb = timeSeriesItemRepository.save(item);
					
					tempDate.setTimeSeriesItem(itemInDb);
					timeSeriesItemDateRepository.save(tempDate);
				}
			}
		}
		
		return daoInDb.getScenarioId();
	}
}
