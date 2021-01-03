package com.vti.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.vti.service.GroupService;

public class NameNotExistValidator implements ConstraintValidator<NameNotExist, String> {

	@Autowired
	private GroupService service;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		}
		return !service.isGroupExistsByName(value);
	}

}