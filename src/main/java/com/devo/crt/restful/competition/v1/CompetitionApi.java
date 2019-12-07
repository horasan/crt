package com.devo.crt.restful.competition.v1;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface CompetitionApi {

	@GetMapping("/competition")
	public ResponseEntity<WSCompetitionResultFile> getAllRankings();
	
	@PostMapping("/competition")
	public ResponseEntity<WSDefaultApiResponse> saveCompetitionResultFile(@RequestBody WSCompetitionResultFile resultFile);
	
	@GetMapping("/competition/ranking/{ranking}")
	public ResponseEntity<List<WSCompetitionResult>> getCompetitorByRanking(@PathVariable("ranking") Integer ranking);
	
	@GetMapping("/competition/points/{accumulatedPoints}")
	public ResponseEntity<List<WSCompetitionResult>> getCompetitorByAccumulatedPoints(@PathVariable("accumulatedPoints") Integer accumulatedPoints);
}
