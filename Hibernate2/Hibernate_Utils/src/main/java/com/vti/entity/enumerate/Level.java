package com.vti.entity.enumerate;

public enum Level {
	EASY("Easy"), MEDIUM("Medium"),HARD("Hard"),VERYHARD("VeryHard");
	
	private String value;
	private Level(String value){
		this.value= value;
	}
	public String getValue() {
		return value;
		
	}
	
	public static Level of(String value) {
		for (Level name : Level.values()) {
			if (name.getValue().equals(value)) {
				return name;
			}
		}
		return null;
	}
}
