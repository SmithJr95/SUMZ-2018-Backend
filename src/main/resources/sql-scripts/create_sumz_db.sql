CREATE DATABASE sumzdb

USE sumzdb

CREATE TABLE AppRole (
  AppRoleId BIGINT IDENTITY(1,1) NOT NULL,
  RoleDescription NVARCHAR(255),
  RoleName NVARCHAR(255),
  
  CONSTRAINT PK_AppRole PRIMARY KEY (AppRoleId)
);


CREATE TABLE AppUser (
  AppUserId BIGINT IDENTITY(1,1) NOT NULL,
  AppUserPassword NVARCHAR(255) NOT NULL,
  Email NVARCHAR(255) NOT NULL,
  IsActive BIT NOT NULL, 
  
  CONSTRAINT PK_AppUser PRIMARY KEY (AppUserId)
);

CREATE TABLE UserRole (
  AppUserId BIGINT NOT NULL,
  AppRoleId BIGINT NOT NULL,
  
  CONSTRAINT PK_UserRole PRIMARY KEY (AppUserId, AppRoleId),
  
  CONSTRAINT FK_UserRole_AppUser FOREIGN KEY (AppUserId) REFERENCES AppUser(AppUserId),
  CONSTRAINT FK_UserRole_AppRole FOREIGN KEY (AppRoleId) REFERENCES AppRole(AppRoleId)
);

CREATE TABLE UserActivationToken (
  UserActivationTokenId BIGINT IDENTITY(1,1) NOT NULL,
  AppUserId BIGINT NOT NULL,
  ExpirationDate DATETIME NOT NULL, 
  TokenKey NVARCHAR(255) NOT NULL,
  
  CONSTRAINT PK_UserActivationToken PRIMARY KEY (UserActivationTokenId),
  CONSTRAINT FK_UserActivationTokenUser_AppUser FOREIGN KEY (AppUserId) REFERENCES AppUser(AppUserId)
);

CREATE TABLE UserPasswordResetToken (
  UserPasswordResetTokenId BIGINT IDENTITY(1,1) NOT NULL,
  AppUserId BIGINT NOT NULL,
  ExpirationDate DATETIME NOT NULL, 
  TokenKey NVARCHAR(255) NOT NULL,
  
  CONSTRAINT PK_UserPasswordResetToken PRIMARY KEY (UserPasswordResetTokenId),
  CONSTRAINT FK_UserPasswordResetTokenUser_AppUser FOREIGN KEY (AppUserId) REFERENCES AppUser(AppUserId)
);

CREATE TABLE FteCompanyValuationResult (
	FteCompanyValuationResultId BIGINT IDENTITY(1,1) NOT NULL,
	CompanyValue FLOAT NOT NULL,

	CONSTRAINT PK_FteCompanyValuationResult PRIMARY KEY (FteCompanyValuationResultId)
);

CREATE TABLE FcfCompanyValuationResult(
	FcfCompanyValuationResultId BIGINT IDENTITY(1,1) NOT NULL,
	CompanyValue FLOAT NOT NULL,
	MarketValueTotalAssets FLOAT NOT NULL,
	TotalLiabilities FLOAT NOT NULL,

	CONSTRAINT PK_FcfCompanyValuationResult PRIMARY KEY (FcfCompanyValuationResultId)
);

CREATE TABLE ApvCompanyValuationResult(
	ApvCompanyValuationResultId BIGINT IDENTITY(1,1) NOT NULL,
	CompanyValue FLOAT NOT NULL,
	MarketValueTotalAssets FLOAT NOT NULL,
	TotalLiabilities FLOAT NOT NULL,
	MarketValueEquity FLOAT NOT NULL,
	TaxShield FLOAT NOT NULL,

	CONSTRAINT PK_ApvCompanyValuationResult PRIMARY KEY (ApvCompanyValuationResultId)
);

CREATE TABLE MultiPeriodAccountingFigure(
	MultiPeriodAccountingFigureId BIGINT IDENTITY(1,1) NOT NULL,
	FigureName NVARCHAR(50) NOT NULL,
	IsHistoric BIT NOT NULL,

	CONSTRAINT PK_MultiPeriodAccountingFigure PRIMARY KEY (MultiPeriodAccountingFigureId),
	CONSTRAINT CHK_MultiPeriodAccountingFigure_FigureName CHECK (LEN(FigureName) > 0),
);

CREATE TABLE Scenario(
	ScenarioId BIGINT IDENTITY(1,1) NOT NULL,
	ScenarioName NVARCHAR(150) NOT NULL,
	ScenarioDescription NVARCHAR(150) NOT NULL,
	ForecastPeriods INT NOT NULL,
	BusinessTaxRate FLOAT NOT NULL,
	CorporateTaxRate FLOAT NOT NULL,
	SolidaryTaxRate FLOAT NOT NULL,
	EquityInterestRate FLOAT NOT NULL,
	InterestOnLiabilitiesRate FLOAT NOT NULL,
	
	DepreciationId BIGINT,
	AdditionalIncomeId BIGINT,
	AdditionalCostsId BIGINT,
	InvestmentsId BIGINT,
	DivestmentsId BIGINT,
	RevenueId BIGINT,
	CostOfMaterialId BIGINT,
	CostOfStaffId BIGINT,
	LiabilitiesId BIGINT,
	FreeCashFlowsId BIGINT,
	
	FteCompanyValuationResultId BIGINT NOT NULL,
	FcfCompanyValuationResultId BIGINT NOT NULL,
	ApvCompanyValuationResultId BIGINT NOT NULL,
	
	AppUserId BIGINT NOT NULL,

	CONSTRAINT PK_Scenario PRIMARY KEY (ScenarioId),
	
	CONSTRAINT FK_Scenario_FteCompanyValuationResultId FOREIGN KEY (FteCompanyValuationResultId) REFERENCES FteCompanyValuationResult(FteCompanyValuationResultId),
	CONSTRAINT FK_Scenario_FcfCompanyValuationResultId FOREIGN KEY (FcfCompanyValuationResultId) REFERENCES FcfCompanyValuationResult(FcfCompanyValuationResultId),
	CONSTRAINT FK_Scenario_ApvCompanyValuationResultId FOREIGN KEY (ApvCompanyValuationResultId) REFERENCES ApvCompanyValuationResult(ApvCompanyValuationResultId),
	
	CONSTRAINT FK_Scenario_DepreciationId FOREIGN KEY (DepreciationId) REFERENCES MultiPeriodAccountingFigure(MultiPeriodAccountingFigureId),
	CONSTRAINT FK_Scenario_AdditionalIncomeId FOREIGN KEY (AdditionalIncomeId) REFERENCES MultiPeriodAccountingFigure(MultiPeriodAccountingFigureId),
	CONSTRAINT FK_Scenario_AdditionalCostsId FOREIGN KEY (AdditionalCostsId) REFERENCES MultiPeriodAccountingFigure(MultiPeriodAccountingFigureId),
	CONSTRAINT FK_Scenario_InvestmentsId FOREIGN KEY (InvestmentsId) REFERENCES MultiPeriodAccountingFigure(MultiPeriodAccountingFigureId),
	CONSTRAINT FK_Scenario_DivestmentsId FOREIGN KEY (DivestmentsId) REFERENCES MultiPeriodAccountingFigure(MultiPeriodAccountingFigureId),
	CONSTRAINT FK_Scenario_RevenueId FOREIGN KEY (RevenueId) REFERENCES MultiPeriodAccountingFigure(MultiPeriodAccountingFigureId),
	CONSTRAINT FK_Scenario_CostOfMaterialId FOREIGN KEY (CostOfMaterialId) REFERENCES MultiPeriodAccountingFigure(MultiPeriodAccountingFigureId),
	CONSTRAINT FK_Scenario_CostOfStaffId FOREIGN KEY (CostOfStaffId) REFERENCES MultiPeriodAccountingFigure(MultiPeriodAccountingFigureId),
	CONSTRAINT FK_Scenario_LiabilitiesId FOREIGN KEY (LiabilitiesId) REFERENCES MultiPeriodAccountingFigure(MultiPeriodAccountingFigureId),
	CONSTRAINT FK_Scenario_FreeCashFlowsId FOREIGN KEY (FreeCashFlowsId) REFERENCES MultiPeriodAccountingFigure(MultiPeriodAccountingFigureId),
	CONSTRAINT FK_Scenario_AppUser FOREIGN KEY (AppUserId) REFERENCES AppUser(AppUserId),
	
	CONSTRAINT CHK_Scenario_ScenarioName CHECK (LEN(ScenarioName) > 0),
	CONSTRAINT CHK_Scenario_ScenarioDescription CHECK (LEN(ScenarioDescription) > 0),
	CONSTRAINT CHK_Scenario_BusinessTaxRate CHECK ((BusinessTaxRate >= 0.0) AND (BusinessTaxRate <= 1.0)),
	CONSTRAINT CHK_Scenario_ForecastPeriods CHECK (ForecastPeriods > 0 AND ForecastPeriods < 11),
	CONSTRAINT CHK_Scenario_EquityInterestRate CHECK (EquityInterestRate >= -0.1 AND EquityInterestRate <= 1.0),
	CONSTRAINT CHK_Scenario_CorporateTaxRate CHECK (CorporateTaxRate >= 0 AND CorporateTaxRate <= 1.0),
	CONSTRAINT CHK_Scenario_SolidaryTaxRate CHECK (SolidaryTaxRate >=0 AND SolidaryTaxRate <= 1.0),
	CONSTRAINT CHECK_Scenario_InterestOnLiabilitiesRate CHECK (InterestOnLiabilitiesRate >= 0 AND InterestOnLiabilitiesRate <= 1.0)
);

CREATE TABLE CompanyValueDistributionPoint(
	CompanyValueDistributionPointId BIGINT IDENTITY(1,1) NOT NULL,
	ScenarioId BIGINT NOT NULL,
	XValue FLOAT NOT NULL,
	YValue FLOAT NOT NULL,

	CONSTRAINT PK_CompanyValueDistribution PRIMARY KEY (CompanyValueDistributionPointId),
	CONSTRAINT FK_CompanyValueDistribution_ScenarioId FOREIGN KEY (ScenarioId) REFERENCES Scenario(ScenarioId)
);

CREATE TABLE TimeSeriesItemDate(
	TimeSeriesItemDateId BIGINT IDENTITY(1,1) NOT NULL,
	ItemYear INT NOT NULL,
	ItemQuarter INT,
	
	CONSTRAINT PK_TimeSeriesItemDate PRIMARY KEY (TimeSeriesItemDateId),
	CONSTRAINT CHK_TimeSeriesItemDate_ItemYear CHECK (ItemYear > 1900 AND ItemYear < 2100),
	CONSTRAINT CHK_TimeSeriesItemDate_ItemQuarter CHECK (ItemQuarter IN (1,2,3,4)),
);

CREATE TABLE TimeSeriesItem(
	TimeSeriesItemId BIGINT IDENTITY(1,1) NOT NULL,
	MultiPeriodAccountingFigureId BIGINT NOT NULL,
	TimeSeriesItemDateId BIGINT NOT NULL,
	
	ItemAmount FLOAT NOT NULL,

	CONSTRAINT PK_TimeSeriesItem PRIMARY KEY (TimeSeriesItemId),
	CONSTRAINT FK_TimeSeriesItem_MultiPeriodAccountingFigureId FOREIGN KEY (MultiPeriodAccountingFigureId) REFERENCES MultiPeriodAccountingFigure(MultiPeriodAccountingFigureId),
	CONSTRAINT FK_TimeSeriesItem_TimeSeriesItemDateId FOREIGN KEY (TimeSeriesItemDateId) REFERENCES TimeSeriesItemDate(TimeSeriesItemDateId)
);


