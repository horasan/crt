package com.devo.crt.service.competitor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devo.crt.repository.competitor.CompetitorRepository;
import com.devo.crt.service.ranking.model.CompetitorBM;


@Service
public class CompetitorServiceImpl implements CompetitorService {

	@Autowired
	private CompetitorRepository competitorRepository;
	
	public List<CompetitorBM> getCompetitor(String competitorName) {

		return competitorRepository.findByName(competitorName);

	}
}
