package com.devo.crt.restful.exception;

/**
 * Custom exception for empty competition result file.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */

@SuppressWarnings("serial")
public class CompetitionResultFileIsEmpty extends RuntimeException {

	public CompetitionResultFileIsEmpty() {
		super("Competition Result File Is Empty");
	}

}
