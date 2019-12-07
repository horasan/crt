package com.devo.crt.restful.competitor.v1;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devo.crt.restful.competition.v1.WSCompetitor;
import com.devo.crt.restful.competitor.CompetitorApi;
import com.devo.crt.service.competitor.CompetitorService;
import com.devo.crt.service.ranking.model.CompetitorBM;

@RestController
@RequestMapping("/competitorapi/v1")
public class CompetitorApiImpl implements CompetitorApi {
	
	@Autowired
	private CompetitorService competitorService; 
	
	@Override
	public ResponseEntity<List<WSCompetitor>> getCompetitor(String competitorName) {

		List<CompetitorBM> competitor = competitorService.getCompetitor(competitorName);
		
		List<WSCompetitor> result = competitor.stream().map(WSCompetitor::new).collect(Collectors.toList()); 
		
		
		return new ResponseEntity<List<WSCompetitor>>(result, HttpStatus.OK);
	}

}
