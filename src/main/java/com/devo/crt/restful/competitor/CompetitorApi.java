package com.devo.crt.restful.competitor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.devo.crt.restful.competition.v1.WSCompetitionResult;
import com.devo.crt.restful.competition.v1.WSCompetitor;

public interface CompetitorApi {
	@GetMapping("/competitor/name/{name}")
	public ResponseEntity<List<WSCompetitionResult>> getCompetitor(@PathVariable ("name") String competitorName);
}
