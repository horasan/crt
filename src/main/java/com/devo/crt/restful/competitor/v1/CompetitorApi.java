package com.devo.crt.restful.competitor.v1;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.devo.crt.restful.competition.v1.WSCompetitor;

public interface CompetitorApi {
	@GetMapping("/competitor/name/{name}")
	public ResponseEntity<List<WSCompetitor>> getCompetitor(@PathVariable ("name") String competitorName);
}
