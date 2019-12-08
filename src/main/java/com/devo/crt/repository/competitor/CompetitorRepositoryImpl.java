package com.devo.crt.repository.competitor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devo.crt.repository.competition.CompetitionResultRepository;
import com.devo.crt.service.ranking.model.CompetitionResultBM;
import com.devo.crt.service.ranking.model.CompetitionResultFileBM;
/**
 * Competitor repository implementations.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
@Repository
public class CompetitorRepositoryImpl implements CompetitorRepository {

	@Autowired
	private CompetitionResultRepository competitionResultRepository;
	
	@Override
	public List<CompetitionResultBM> findByName(String name) {

		CompetitionResultFileBM competitionResultFile = competitionResultRepository.getCompetitionResultFile();
		
		List<CompetitionResultBM> competitorList = competitionResultFile.getCompetitionResults().stream()
				.filter(comp -> comp.getCompetitorBM().getName().equals(name))
				//.map(CompetitionResultBM::getCompetitorBM)
				.collect(Collectors.toList());
		
		return competitorList;
		
	}

	
	
}
