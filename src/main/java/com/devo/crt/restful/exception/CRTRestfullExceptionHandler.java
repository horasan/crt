package com.devo.crt.restful.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * Exception handler for RestFul APIs and related responses.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
@RestControllerAdvice
public class CRTRestfullExceptionHandler {

	@ExceptionHandler(CompetitionResultFileNotFound.class)
	public ResponseEntity<CRTErrorResponse> handleCompetitionResultFileNotFound(Exception ex, WebRequest request) {

		CRTErrorResponse errorResponse = new CRTErrorResponse();
		errorResponse.setTimeStamp(LocalDateTime.now());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setCode("competition.result.file.not.found");
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(CompetitorNotFound.class)
	public ResponseEntity<CRTErrorResponse> handleCompetitorNotFound(Exception ex, WebRequest request) {

		CRTErrorResponse errorResponse = new CRTErrorResponse();
		errorResponse.setTimeStamp(LocalDateTime.now());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setCode("competitor.not.found");
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(CompetitionResultFileIsEmpty.class)
	public ResponseEntity<CRTErrorResponse> handleCompetitionResultFileIsEmpty(Exception ex, WebRequest request) {

		CRTErrorResponse errorResponse = new CRTErrorResponse();
		errorResponse.setTimeStamp(LocalDateTime.now());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setCode("competition.result.file.is.empty");
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(CompetitionResultFilePatternIsNotCorrect.class)
	public ResponseEntity<CRTErrorResponse> handleCompetitionResultFilePatternIsNotCorrect(Exception ex,
			WebRequest request) {

		CRTErrorResponse errorResponse = new CRTErrorResponse();
		errorResponse.setTimeStamp(LocalDateTime.now());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setCode("competition.result.file.pattern.is.not.correct");
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<CRTErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {

		CRTErrorResponse errorResponse = new CRTErrorResponse();
		errorResponse.setTimeStamp(LocalDateTime.now());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setCode("unknown.error");
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
