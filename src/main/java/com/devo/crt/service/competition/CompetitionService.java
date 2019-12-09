package com.devo.crt.service.competition;

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
}
