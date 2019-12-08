package com.devo.crt.repository.competitor;

import java.util.List;

import com.devo.crt.service.ranking.model.CompetitionResultBM;
/**
 * TODO: RIZA - Description is here!
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
public interface CompetitorRepository {
	
	public List<CompetitionResultBM> findByName(String name);
	
}
