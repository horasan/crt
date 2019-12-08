package com.devo.crt.restful.exception;
/**
 * Custom exception for competition result file not found. 
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
@SuppressWarnings("serial")
public class CompetitionResultFileNotFound extends RuntimeException {

	public CompetitionResultFileNotFound( ) {
		super("Competition Result File Not Found");
	}
}
