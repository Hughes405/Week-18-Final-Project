package com.pie_shop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ConstraintViolationException extends RuntimeException {
	private String resourceName;
	private String fieldName;
	private Object findValue;

	public ConstraintViolationException(String resourceName, String fieldName, Object findValue) {
		super(String.format("%s not a valid input for %s : '%s'", resourceName, fieldName, findValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.findValue = findValue;

	}

	public String getResourceName() {
		return resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Object getFindValue() {
		return findValue;
	}

}
