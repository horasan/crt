package com.devo.crt.restful.competition;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devo.crt.restful.competition.v1.WSCompetitionResultFileRaw;
import com.devo.crt.restful.competition.v1.WSDefaultApiResponse;

/**
 * Competition related exposed Restful APIs.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
public interface CompetitionApi {

	@PostMapping("/competition/raw")
	public ResponseEntity<WSDefaultApiResponse> saveCompetitionResultFile(
			@RequestBody WSCompetitionResultFileRaw resultFile);
}
