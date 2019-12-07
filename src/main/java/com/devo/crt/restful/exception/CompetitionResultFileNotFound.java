package com.devo.crt.restful.exception;

@SuppressWarnings("serial")
public class CompetitionResultFileNotFound extends RuntimeException {

	public CompetitionResultFileNotFound( ) {
		super("Competition Result File Not Found");
	}
}
