package com.vti.config_exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vti.config.MessageProperty;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	@Autowired
	private MessageProperty messageProperty;
	
	// default exception
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<?> handleAll(Exception exception) {
		ApiErrorResponse error = new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
				"Đã có lỗi từ sever,Liên lạc Admin:nguyenducmanh@gmail.com",exception.getMessage());
		return new ResponseEntity<>(error,error.getStatus());
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException exception){
		ApiErrorResponse error = new ApiErrorResponse(HttpStatus.NOT_FOUND,
				"Không tìm thấy tài nguyên bạn yêu cầu,check parameters",exception.getMessage());
		return new ResponseEntity<>(error,error.getStatus());
	}
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(
			MissingServletRequestParameterException exception, HttpHeaders headers, HttpStatus status,
			WebRequest request) {

		ApiErrorResponse error = new ApiErrorResponse(HttpStatus.BAD_REQUEST,
				"Lỗi không mapping parameters, hãy kiểm tra lại", exception.getMessage());

		return new ResponseEntity<>(error, error.getStatus());
	}

	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ApiErrorResponse error = new ApiErrorResponse(HttpStatus.BAD_REQUEST,
				"Lỗi không mapping parameters, hãy kiểm tra lại", exception.getMessage());

		return new ResponseEntity<>(error, error.getStatus());
	}
}