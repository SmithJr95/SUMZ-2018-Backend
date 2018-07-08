package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

public class PredictionResponseTimeSeriesDto {
	private String id;
	private Double[][] preds;
	
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	
	public Double[][] getPreds() { return preds; }
	public void setPreds(Double[][] preds) { this.preds = preds; }
	
	@Override
	public String toString() {
		
		String newLine = System.getProperty("line.separator");
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Id: ");
		sb.append(this.id != null ? this.id : "");
		sb.append(",\t");
		
		if(this.preds != null) {
			for (int i = 0; i < this.preds.length; i++) {
				sb.append(newLine);
				sb.append("\t");
				sb.append("[");
				if(this.preds[i] != null) {
					for (int j = 0; j < this.preds[i].length; j++) {
						if (this.preds[i][j] != null) {
							sb.append(this.preds[i][j]);
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
