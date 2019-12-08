package com.devo.crt.repository.competitor;

import java.util.List;

import com.devo.crt.service.ranking.model.CompetitionResultBM;
/**
 * Competitor repository operations.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
public interface CompetitorRepository {
	
	public List<CompetitionResultBM> findByName(String name);
	
}
