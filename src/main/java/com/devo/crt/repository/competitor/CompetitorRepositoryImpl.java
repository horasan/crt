package com.devo.crt.repository.competitor;

import java.util.Collections;
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
				.sorted((c1, c2) -> c1.compareTo(c2))
				.sorted(Collections.reverseOrder())
				.collect(Collectors.toList());
		
		return competitorList;
		
	}

	
	
}
