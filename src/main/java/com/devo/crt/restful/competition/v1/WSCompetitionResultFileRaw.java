package com.devo.crt.restful.competition.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(
		description=""
		)
public class WSCompetitionResultFileRaw {
	
	@ApiModelProperty(notes="Name of the uploaded file")
	private String fileName;
	
	@ApiModelProperty(notes="Expected file format: {competitorId: string} {name: string} {accumulatedPoints: integer} \r\n"
			+ "Example: \r\n"
			+ "Competitor1 Name 5500\r\n"
			+ "Competitor2 Name 6500\r\n"
			+ "Competitor3 Name 3300\r\n"
			+ "Competitor4 Name 7200")
	private String rawFileContent;
}
