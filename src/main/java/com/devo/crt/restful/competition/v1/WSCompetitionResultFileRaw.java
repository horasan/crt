package com.devo.crt.restful.competition.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
/**
 * Represents raw competition result file.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
@Getter
@Setter
@ApiModel(
		description="Represents raw competition result file."
		)
public class WSCompetitionResultFileRaw {
	
	@ApiModelProperty(
			notes="Name of the uploaded file",
		    example = "result.txt")
	private String fileName;
	
	@ApiModelProperty(notes="Expected file format: {competitorId: string} {name: string} {accumulatedPoints: integer} \r\n",
			example="Competitor4 name4 101\r\n"
					+ "Competitor3 name3 104\r\n"
					+ "Competitor2 name2 102\r\n"
					+ "Competitor1 name1 101"
			)
	private String rawFileContent;
}
