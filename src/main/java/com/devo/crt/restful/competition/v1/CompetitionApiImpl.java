package com.devo.crt.restful.competition.v1;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devo.crt.restful.competitor.CompetitionApi;
import com.devo.crt.service.ranking.RankingService;
import com.devo.crt.service.ranking.model.CompetitionResultBM;
import com.devo.crt.service.ranking.model.CompetitionResultFileBM;
import com.devo.crt.service.ranking.model.DefaultServiceResponseBM;

/**
 * Restful apis for ranking features.
 * 
 * @author horasanriza
 * @since Dec 12, 2019
 * 
 */

@RestController
@RequestMapping("/competitionapi/v1")
public class CompetitionApiImpl implements CompetitionApi {

	// TODO: exception handling, return codes
	
	@Autowired
	private RankingService rankingService;  
	
	@Override
	public ResponseEntity<WSCompetitionResultFile> getAllRankings() {

		CompetitionResultFileBM allRankings = rankingService.getAllRankings();
		
		WSCompetitionResultFile result = new WSCompetitionResultFile(allRankings);
		
		return new ResponseEntity<WSCompetitionResultFile>(result, HttpStatus.OK);

	}

	
	@Override
	public ResponseEntity<WSDefaultApiResponse> saveCompetitionResultFile(WSCompetitionResultFile resultFile) {
		DefaultServiceResponseBM serviceResponse = rankingService.saveCompetitionResultFile(resultFile.toBM());
		//return new ResponseEntity<WSDefaultApiResponse>(new WSDefaultApiResponse(serviceResponse), HttpStatus.OK);
		return new ResponseEntity<WSDefaultApiResponse>(new WSDefaultApiResponse(serviceResponse), HttpStatus.OK);
	}


	@Override
	public ResponseEntity<List<WSCompetitionResult>> getCompetitorByRanking(Integer ranking) {
		List<CompetitionResultBM> competitorByRanking = rankingService.getCompetitorByRanking(ranking);
		List<WSCompetitionResult> result = competitorByRanking.stream().map(WSCompetitionResult::new).collect(Collectors.toList()); 
		return new ResponseEntity<List<WSCompetitionResult>>(result, HttpStatus.OK);
	}


	@Override
	public ResponseEntity<List<WSCompetitionResult>> getCompetitorByAccumulatedPoints(Integer accumulatedPoints) {
		List<CompetitionResultBM> competitorByRanking = rankingService.getCompetitorByAccumulatedPoints(accumulatedPoints);
		List<WSCompetitionResult> result = competitorByRanking.stream().map(WSCompetitionResult::new).collect(Collectors.toList()); 
		return new ResponseEntity<List<WSCompetitionResult>>(result, HttpStatus.OK);
	}


}
