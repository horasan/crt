package com.devo.crt.restful.competition.v1;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.devo.crt.service.ranking.model.CompetitionResultFileBM;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents API response for competition results for a competition.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */

@Getter
@Setter
@NoArgsConstructor
public class WSCompetitionResultFile {

	private List<WSCompetitionResult> competitionResults;
	
	public CompetitionResultFileBM toBM() {

		CompetitionResultFileBM competitionResultFileBM = new CompetitionResultFileBM();

		if (!Objects.isNull(competitionResults)) {
			competitionResultFileBM.setCompetitionResults(
					competitionResults.stream().map(item -> item.toBM()).collect(Collectors.toList()));
		}

		return competitionResultFileBM;
	}
	
	public WSCompetitionResultFile(CompetitionResultFileBM resultFile) {
		if (Objects.isNull(resultFile)) {
			return;
		}
		
		competitionResults = resultFile.getCompetitionResults().stream().map(WSCompetitionResult::new).collect(Collectors.toList());
	}
	
	
}
