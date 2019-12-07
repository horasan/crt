package com.devo.crt.restful.exception;

@SuppressWarnings("serial")
public class CompetitorNotFound extends RuntimeException {

	public CompetitorNotFound(String name) {
		super(name + " not found");
	}
	
}
