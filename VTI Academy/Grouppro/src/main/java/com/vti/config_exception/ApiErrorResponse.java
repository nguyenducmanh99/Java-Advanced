package com.vti.config_exception;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;


public class ApiErrorResponse {
	private HttpStatus status;

	private String message;

	private String detailMessager;

	public ApiErrorResponse(HttpStatus status, String message, String detailMessager) {
		this.status = status;
		this.message = message;
		this.detailMessager = detailMessager;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetailMessager() {
		return detailMessager;
	}

	public void setDetailMessager(String detailMessager) {
		this.detailMessager = detailMessager;
	}
	
	

}
