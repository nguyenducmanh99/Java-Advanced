package com.vti.entity.enumerate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class LevelConvert implements AttributeConverter<Level, String> {

	public String convertToDatabaseColumn(Level name) {
		if(name == null) {
			return null;
		}
		return name.getValue();
	}

	public Level convertToEntityAttribute(String value) {
		
		return Level.of(value);

	}

}
