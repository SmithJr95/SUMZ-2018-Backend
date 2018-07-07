package edu.dhbw.ka.mwi.businesshorizon2.models.daos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "TimeSeriesItemDate")
@Table(name = "TimeSeriesItemDate")
public class TimeSeriesItemDateDao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TimeSeriesItemDateId")
	private Long timeSeriesItemDateId;
	
	@Column(name="ItemYear")
	private Integer itemYear;
	
	@Column(name="ItemQuarter")
	private Integer itemQuarter;
	
	@OneToOne
	@JoinColumn(name = "TimeSeriesItemId")
	private TimeSeriesItemDao timeSeriesItem;
	
	public TimeSeriesItemDateDao() {}
	
	public TimeSeriesItemDateDao(Integer itemYear) {
		this.itemYear = itemYear;
	} 
	
	public TimeSeriesItemDateDao(Integer itemYear, Integer itemQuarter) {
		this.itemYear = itemYear;
		this.itemQuarter = itemQuarter;
	}
	
	public Long getTimeSeriesItemDateId() { return timeSeriesItemDateId; }
	
	public Integer getItemYear() { return itemYear; }
	public void setItemYear(Integer itemYear) { this.itemYear = itemYear; }
	
	public Integer getItemQuarter() { return itemQuarter; }
	public void setItemQuarter(Integer itemQuarter) { this.itemQuarter = itemQuarter; }
	
	public TimeSeriesItemDao getTimeSeriesItem() { return timeSeriesItem; }
	public void setTimeSeriesItem(TimeSeriesItemDao timeSeriesItem) { this.timeSeriesItem = timeSeriesItem; }
}
