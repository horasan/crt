package com.devo.crt.service.competitor;

import java.util.List;

import com.devo.crt.service.ranking.model.CompetitionResultBM;

/**
 * TODO: RIZA - Description is here!
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */

public interface CompetitorService {
	public List<CompetitionResultBM> getCompetitor(String competitorName);
}
