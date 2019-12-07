package com.devo.crt.restful.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CRTErrorResponse {
	private LocalDateTime timeStamp;
	private String message;
	private String code;
	private int status;
	
}
