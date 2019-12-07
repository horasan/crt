package com.devo.crt.restful.competitor.v1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.junit.platform.commons.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devo.crt.restful.competition.v1.WSCompetitionResult;
import com.devo.crt.restful.competitor.CompetitorApi;
import com.devo.crt.restful.exception.CompetitorNotFound;
import com.devo.crt.service.competitor.CompetitorService;
import com.devo.crt.service.ranking.model.CompetitionResultBM;

@RestController
@RequestMapping("/competitorapi/v1")
@CrossOrigin
public class CompetitorApiImpl implements CompetitorApi {
	
	@Autowired
	private CompetitorService competitorService; 
	
	@Override
	public ResponseEntity<List<WSCompetitionResult>> getCompetitor(String competitorName) {

		List<CompetitionResultBM> competitor = competitorService.getCompetitor(competitorName);
		
		List<WSCompetitionResult> result = competitor.stream().map(WSCompetitionResult::new).collect(Collectors.toList()); 
		if (result.isEmpty()) {
			//return new ResponseEntity<List<WSCompetitionResult>>(result, HttpStatus.NOT_FOUND);
			throw new CompetitorNotFound(competitorName);
		}
		
		return new ResponseEntity<List<WSCompetitionResult>>(result, HttpStatus.OK);
	}

}
