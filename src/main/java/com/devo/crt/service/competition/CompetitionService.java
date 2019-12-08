package com.devo.crt.service.competition;

import java.util.List;

import com.devo.crt.service.ranking.model.CompetitionResultBM;
import com.devo.crt.service.ranking.model.CompetitionResultFileBM;
import com.devo.crt.service.ranking.model.DefaultServiceResponseBM;

/**
 * Competition service operations.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */

public interface CompetitionService {
	public DefaultServiceResponseBM saveCompetitionResultFile(CompetitionResultFileBM resultFile);
	
	public CompetitionResultFileBM getAllRankings();

	public List<CompetitionResultBM> getCompetitorByRanking(Integer ranking);

	public List<CompetitionResultBM> getCompetitorByAccumulatedPoints(Integer accumulatedPoints);
}
