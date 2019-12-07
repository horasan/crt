package com.devo.crt.repository.competitor;

import java.util.List;

import com.devo.crt.service.ranking.model.CompetitorBM;

public interface CompetitorRepository {
	
	public List<CompetitorBM> findByName(String name);
	
}
