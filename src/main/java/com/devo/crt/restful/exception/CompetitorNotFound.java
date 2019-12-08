package com.devo.crt.restful.exception;
/**
 * TODO: RIZA - Description is here!
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
@SuppressWarnings("serial")
public class CompetitorNotFound extends RuntimeException {

	public CompetitorNotFound(String name) {
		super(name + " not found");
	}
	
}
