package com.devo.crt.restful.competition.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devo.crt.common.util.FileContentFormatter;
import com.devo.crt.restful.competition.CompetitionApi;
import com.devo.crt.service.competition.CompetitionService;
import com.devo.crt.service.ranking.model.CompetitionResultFileBM;
import com.devo.crt.service.ranking.model.DefaultServiceResponseBM;

/**
 * Competition related exposed Restful API implementations.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */

@RestController
@RequestMapping("/competitionapi/v1")
@CrossOrigin
public class CompetitionApiImpl implements CompetitionApi {

	@Autowired
	private CompetitionService competitionService;

	@Autowired
	private FileContentFormatter fileContentFormatter;

	@Override
	public ResponseEntity<WSDefaultApiResponse> saveCompetitionResultFile(WSCompetitionResultFileRaw resultFile) {

		CompetitionResultFileBM convertedResultFile = fileContentFormatter
				.convertFromInputFile(resultFile.getRawFileContent());
		DefaultServiceResponseBM serviceResponse = competitionService.saveCompetitionResultFile(convertedResultFile);
		return new ResponseEntity<WSDefaultApiResponse>(new WSDefaultApiResponse(serviceResponse), HttpStatus.OK);
	}
}
