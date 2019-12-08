package com.devo.crt.service.competitor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devo.crt.repository.competitor.CompetitorRepository;
import com.devo.crt.service.ranking.model.CompetitionResultBM;

/**
 * Competitor service operation implementations.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
@Service
public class CompetitorServiceImpl implements CompetitorService {

	@Autowired
	private CompetitorRepository competitorRepository;
	
	public List<CompetitionResultBM> getCompetitor(String competitorName) {

		return competitorRepository.findByName(competitorName);

	}
}
