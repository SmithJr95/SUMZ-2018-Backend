package edu.dhbw.ka.mwi.businesshorizon2.models.common;

public enum Quarters {
	FIRST(1),
	SECOND(2),
	THIRD(3),
	FOURTH(4);
	
	private final int value;
	
	Quarters(int value){
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}
