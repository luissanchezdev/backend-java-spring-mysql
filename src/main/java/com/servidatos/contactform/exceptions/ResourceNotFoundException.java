package com.servidatos.contactform.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String resourceName;
	private String fieldName; 
	private Long fieldValue;
	private String message;
	
	public ResourceNotFoundException(String message) {
		super(message);
		
		this.message = message;
	}
	
	
	
	

}
