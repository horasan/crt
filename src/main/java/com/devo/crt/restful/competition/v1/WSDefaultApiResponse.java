package com.devo.crt.restful.competition.v1;

import com.devo.crt.service.ranking.model.DefaultServiceResponseBM;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WSDefaultApiResponse {
	private String message;
	
	public WSDefaultApiResponse(DefaultServiceResponseBM serviceResponse) {
		message = serviceResponse.getMessage();
	}
}
