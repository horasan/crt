package com.devo.crt.restful.competition.v1;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devo.crt.common.util.FileContentFormatter;
import com.devo.crt.restful.competition.CompetitionApi;
import com.devo.crt.service.competition.CompetitionService;
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
@CrossOrigin
public class CompetitionApiImpl implements CompetitionApi {

	// TODO: exception handling, return codes
	
	@Autowired
	private CompetitionService competitionService;  
	
	@Autowired
	private FileContentFormatter fileContentFormatter;
	
	@Override
	public ResponseEntity<WSCompetitionResultFile> getAllRankings() {

		CompetitionResultFileBM allRankings = competitionService.getAllRankings();
		
		WSCompetitionResultFile result = new WSCompetitionResultFile(allRankings);
		
		return new ResponseEntity<WSCompetitionResultFile>(result, HttpStatus.OK);

	}

	
	@Override
	public ResponseEntity<WSDefaultApiResponse> saveCompetitionResultFile(WSCompetitionResultFile resultFile) {
		DefaultServiceResponseBM serviceResponse = competitionService.saveCompetitionResultFile(resultFile.toBM());
		//
		return new ResponseEntity<WSDefaultApiResponse>(new WSDefaultApiResponse(serviceResponse), HttpStatus.OK);
	}


	@Override
	public ResponseEntity<List<WSCompetitionResult>> getCompetitorByRanking(Integer ranking) {
		List<CompetitionResultBM> competitorByRanking = competitionService.getCompetitorByRanking(ranking);
		List<WSCompetitionResult> result = competitorByRanking.stream().map(WSCompetitionResult::new).collect(Collectors.toList()); 
		return new ResponseEntity<List<WSCompetitionResult>>(result, HttpStatus.OK);
	}


	@Override
	public ResponseEntity<List<WSCompetitionResult>> getCompetitorByAccumulatedPoints(Integer accumulatedPoints) {
		List<CompetitionResultBM> competitorByRanking = competitionService.getCompetitorByAccumulatedPoints(accumulatedPoints);
		List<WSCompetitionResult> result = competitorByRanking.stream().map(WSCompetitionResult::new).collect(Collectors.toList()); 
		return new ResponseEntity<List<WSCompetitionResult>>(result, HttpStatus.OK);
	}


	@Override
	public ResponseEntity<WSDefaultApiResponse> saveCompetitionResultFile(WSCompetitionResultFileRaw resultFile) {
		CompetitionResultFileBM convertedResultFile = fileContentFormatter.convertFromInputFile(resultFile.getRawFileContent());
		DefaultServiceResponseBM serviceResponse = competitionService.saveCompetitionResultFile(convertedResultFile);
		return new ResponseEntity<WSDefaultApiResponse>(new WSDefaultApiResponse(serviceResponse), HttpStatus.OK);		
	}
}
