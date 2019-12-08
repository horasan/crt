package com.devo.crt.restful.competition.v1;

import com.devo.crt.service.ranking.model.DefaultServiceResponseBM;

import lombok.Getter;
import lombok.Setter;
/**
 * TODO: RIZA - Description is here!
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
@Getter
@Setter
public class WSDefaultApiResponse {
	private String message;
	
	public WSDefaultApiResponse(DefaultServiceResponseBM serviceResponse) {
		message = serviceResponse.getMessage();
	}
}
