package edu.dhbw.ka.mwi.businesshorizon2.models.common;

public class AccountingFigure {
	private String id;
	private boolean historic;
	private TimeSeriesItem[] timeSeries;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isHistoric() {
		return historic;
	}

	public void setHistoric(boolean historic) {
		this.historic = historic;
	}

	public TimeSeriesItem[] getTimeSeries() {
		return timeSeries;
	}

	public void setTimeSeries(TimeSeriesItem[] timeSeries) {
		this.timeSeries = timeSeries;
	}
	
	@Override
	public String toString() {
		String result = "Id: " +  this.id+ ", " + "Historic: " + this.historic +  ", [\n";
		
		for(int i = 0; i < this.timeSeries.length - 1; i++) {
			result += this.timeSeries[i].toString() + ",\n";
		}
		
		result += this.timeSeries[this.timeSeries.length - 1].toString();

		return result + "]";
	}
}
