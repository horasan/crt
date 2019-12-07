package com.devo.crt.service.competitor;

import java.util.List;

import com.devo.crt.service.ranking.model.CompetitionResultBM;
import com.devo.crt.service.ranking.model.CompetitorBM;

/**
 *	TODO: 
 * 
 */


public interface CompetitorService {
	public List<CompetitionResultBM> getCompetitor(String competitorName);
}
