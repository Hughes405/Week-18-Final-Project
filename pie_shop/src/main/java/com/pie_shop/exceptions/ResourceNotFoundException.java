package com.pie_shop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private String resourceName;
	private String fieldName;
	private Object findValue;

	public ResourceNotFoundException(String resourceName, String fieldName, Object findValue) {
		super(String.format("%s not found with %s : '%s'", resourceName, fieldName, findValue));
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
