package com.devo.crt.service.ranking;

import java.util.List;

import com.devo.crt.service.ranking.model.CompetitionResultBM;
import com.devo.crt.service.ranking.model.CompetitionResultFileBM;
import com.devo.crt.service.ranking.model.DefaultServiceResponseBM;

/**
 * Ranking service features.
 * 
 * @author horasanriza
 * @since Dec 12, 2019
 * 
 */

public interface RankingService {
	public DefaultServiceResponseBM saveCompetitionResultFile(CompetitionResultFileBM resultFile);
	
	public CompetitionResultFileBM getAllRankings();

	public List<CompetitionResultBM> getCompetitorByRanking(Integer ranking);

	public List<CompetitionResultBM> getCompetitorByAccumulatedPoints(Integer accumulatedPoints);
}
