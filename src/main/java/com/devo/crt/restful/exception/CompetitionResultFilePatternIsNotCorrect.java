package com.devo.crt.restful.exception;

/**
 * Custom exception for incorrect result file pattern.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */

@SuppressWarnings("serial")
public class CompetitionResultFilePatternIsNotCorrect extends RuntimeException {

	public CompetitionResultFilePatternIsNotCorrect() {
		super("Competition Result File Pattern Is Not Correct");
	}
}
