package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

public class PredictionResponseTimeSeriesDto {
	private String id;
	private Double[][] values;
	
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	
	public Double[][] getValues() { return values; }
	public void setValues(Double[][] values) { this.values = values; }
	
	@Override
	public String toString() {
		
		String newLine = System.getProperty("line.separator");
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Id: ");
		sb.append(this.id != null ? this.id : "");
		sb.append(",\t");
		
		if(this.values != null) {
			for (int i = 0; i < this.values.length; i++) {
				sb.append(newLine);
				sb.append("\t");
				sb.append("[");
				if(this.values[i] != null) {
					for (int j = 0; j < this.values[i].length; j++) {
						if (this.values[i][j] != null) {
							sb.append(this.values[i][j]);
							sb.append(", ");
						}
					}
				}
				sb.append("]");
				sb.append("\t");
			}
		}
		
		return sb.toString();
	}
}
