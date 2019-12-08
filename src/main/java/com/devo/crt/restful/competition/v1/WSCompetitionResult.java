package com.devo.crt.restful.competition.v1;

import java.util.Objects;

import com.devo.crt.service.ranking.model.CompetitionResultBM;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * TODO: RIZA - Description is here!
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WSCompetitionResult {
	private WSCompetitor wsCompetitor;
	private Integer accumulatedPoints;
	private Integer ranking;
	
	public CompetitionResultBM toBM() {
		CompetitionResultBM competitionResultBM = new CompetitionResultBM();
		competitionResultBM.setAccumulatedPoints(accumulatedPoints);
		competitionResultBM.setCompetitorBM(wsCompetitor.toBM());
		competitionResultBM.setRanking(ranking);
		return competitionResultBM;
	}
	
	public WSCompetitionResult(CompetitionResultBM competitionResult) {
		if (Objects.isNull(competitionResult)) {
			return;
		}
		
		wsCompetitor = new WSCompetitor(competitionResult.getCompetitorBM());
		accumulatedPoints = competitionResult.getAccumulatedPoints();
		ranking = competitionResult.getRanking();
	}
}
