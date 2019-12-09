package com.devo.crt.restful.competitor.v1;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devo.crt.restful.competition.v1.WSCompetitionResult;
import com.devo.crt.restful.competition.v1.WSDefaultApiResponse;
import com.devo.crt.restful.competitor.CompetitorApi;
import com.devo.crt.restful.exception.CompetitorNotFound;
import com.devo.crt.service.competitor.CompetitorService;
import com.devo.crt.service.ranking.model.CompetitionResultBM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Competitor related RestFul APIs implementations.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
@RestController
@RequestMapping("/competitorapi/v1")
@CrossOrigin
@Api(value = "Competitor Api", description = "Competitor related RestFul APIs implementations")
public class CompetitorApiImpl implements CompetitorApi {

	@Autowired
	private CompetitorService competitorService;

	@ApiOperation(value = "Returns a list of competitors based on given name as input.", response = WSCompetitionResult.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Competition Result File Not Found"),
			@ApiResponse(code = 404, message = "{competitorName} not found")
	})
	@Override
	public ResponseEntity<List<WSCompetitionResult>> getCompetitor(String competitorName) {

		List<CompetitionResultBM> competitor = competitorService.getCompetitor(competitorName);

		if (CollectionUtils.isEmpty(competitor)) {
			throw new CompetitorNotFound(competitorName);
		}

		List<WSCompetitionResult> result = competitor.stream().map(WSCompetitionResult::new)
				.collect(Collectors.toList());
		return new ResponseEntity<List<WSCompetitionResult>>(result, HttpStatus.OK);
	}

}
