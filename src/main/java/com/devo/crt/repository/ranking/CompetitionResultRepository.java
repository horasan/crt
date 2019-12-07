package com.devo.crt.repository.ranking;

import com.devo.crt.service.ranking.model.CompetitionResultBM;
import com.devo.crt.service.ranking.model.CompetitionResultFileBM;

public interface CompetitionResultRepository {
	
	public void saveCompetitionResultFile(CompetitionResultFileBM resultFile);
	
	public CompetitionResultFileBM getCompetitionResultFile();

	public CompetitionResultBM getCompetitorByRanking(Integer ranking);
}
