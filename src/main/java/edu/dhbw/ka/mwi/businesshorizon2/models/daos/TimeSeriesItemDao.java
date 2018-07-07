package edu.dhbw.ka.mwi.businesshorizon2.models.daos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "TimeSeriesItem")
@Table(name = "TimeSeriesItem")
public class TimeSeriesItemDao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TimeSeriesItemId")
	private Long timeSeriesItemId;
	
	@Column(name="ItemAmount")
	private Double itemAmount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MultiPeriodAccountingFigureId")
	private MultiPeriodAccountingFigureDao accountingFigure;
	
	@OneToOne(mappedBy = "timeSeriesItem")
	private TimeSeriesItemDateDao timeSeriesItemDate;
	
	public TimeSeriesItemDao() {}
	
	public TimeSeriesItemDao(Double itemAmount, TimeSeriesItemDateDao timeSeriesItemDate) {
		this.itemAmount = itemAmount;
		this.timeSeriesItemDate = timeSeriesItemDate;
	}
	
	public Long getTimeSeriesItemId() { return timeSeriesItemId; }
	
	public Double getItemAmount() { return itemAmount; }
	public void setItemAmount(Double itemAmount) { this.itemAmount = itemAmount; }
	
	public MultiPeriodAccountingFigureDao getAccountingFigure() { return accountingFigure; }
	public void setAccountingFigure(MultiPeriodAccountingFigureDao accountingFigure) { this.accountingFigure = accountingFigure; }
	
	public TimeSeriesItemDateDao getTimeSeriesItemDate() { return timeSeriesItemDate; }
	public void setTimeSeriesItemDate(TimeSeriesItemDateDao timeSeriesItemDate) { this.timeSeriesItemDate = timeSeriesItemDate; }
}
