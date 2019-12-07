package com.devo.crt.repository.competition;

import java.util.List;

import com.devo.crt.service.ranking.model.CompetitionResultBM;
import com.devo.crt.service.ranking.model.CompetitionResultFileBM;

public interface CompetitionResultRepository {
	
	public void saveCompetitionResultFile(CompetitionResultFileBM resultFile);
	
	public CompetitionResultFileBM getCompetitionResultFile();

	public List<CompetitionResultBM> getCompetitorByRanking(Integer ranking);

	public List<CompetitionResultBM> getCompetitorByAccumulatedPoints(Integer accumulatedPoints);
	
}
