package com.devo.crt.restful.exception;

@SuppressWarnings("serial")
public class ObjectNotFound extends RuntimeException {

	public ObjectNotFound(Long id) {
		super(id.toString() + " not found");
	}
}
