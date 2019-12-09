package com.devo.crt.restful.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * Represent custom error message for RestFul API responses.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
@Getter
@Setter
public class CRTErrorResponse {
	private LocalDateTime timeStamp;
	private String message;
	private String code;
	private int status;

}
