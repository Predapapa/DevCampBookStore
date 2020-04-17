package com.sap.devcamp.stepat.bookshop.exceptioncontroller;

import java.util.Date;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sap.devcamp.stepat.bookshop.model.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler ( value = { EntityNotFoundException.class, NullPointerException.class} )
	public ResponseEntity handleNotFoundException(final HttpServletRequest request, final Exception exception)
	throws JsonProcessingException {
		HttpStatus status = HttpStatus.NOT_FOUND;
		logExceptionErrorLevel(status, exception, request);
		return getEntity(status, exception, request);
	}
	
	@ExceptionHandler ( value = { EntityNotFoundException.class } )
	public ResponseEntity handleBadRequesException(final HttpServletRequest request, final Exception exception)
	throws JsonProcessingException {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		logExceptionErrorLevel(status, exception, request);
		return getEntity(status, exception, request);
	}
	
	@ExceptionHandler ( value = { Exception.class } )
	public ResponseEntity handleInternalServerErrorException(final HttpServletRequest request, final Exception exception)
	throws JsonProcessingException {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		logExceptionErrorLevel(status, exception, request);
		return getEntity(status, exception, request);
	}

	private void logExceptionErrorLevel(HttpStatus status, Exception exception, HttpServletRequest request) {

		log.error("{}: '{}' \t Method: {} \t Path: {}", status.toString(), exception.getMessage(), request.getMethod(), request.getRequestURI());

		
	}

	private ResponseEntity getEntity(HttpStatus status, Exception exception, HttpServletRequest request) 

		throws JsonProcessingException {
		return new ResponseEntity<>(generateErrorResponse(status, exception, request), status);
	}
	

	//private String generateErrorResponse(HttpStatus status, Exception exception, HttpServletRequest request) 

			//throws JsonProcessingException {
		
		//return new ErrorResponse(new Date().toString, status.value(), status.getReasonPhrase(), exception.getClass().getName());
		//}
}
