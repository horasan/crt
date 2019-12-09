package com.devo.crt.repository.competition;

import com.devo.crt.service.ranking.model.CompetitionResultFileBM;

/**
 * Competition repository related operations.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
public interface CompetitionResultRepository {

	public void saveCompetitionResultFile(CompetitionResultFileBM resultFile);

	public CompetitionResultFileBM getCompetitionResultFile();

}
