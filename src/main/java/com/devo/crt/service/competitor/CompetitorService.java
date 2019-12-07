package com.devo.crt.service.competitor;

import java.util.List;

import com.devo.crt.service.ranking.model.CompetitorBM;

/**
 *	TODO: 
 * 
 */


public interface CompetitorService {
	public List<CompetitorBM> getCompetitor(String competitorName);
}
