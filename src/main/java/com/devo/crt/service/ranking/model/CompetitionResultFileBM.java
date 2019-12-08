package com.devo.crt.service.ranking.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * TODO: RIZA - Description is here!
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
@Getter
@Setter
@NoArgsConstructor
public class CompetitionResultFileBM {
	
	private List<CompetitionResultBM> competitionResults;
	
	public CompetitionResultFileBM(String formattedString) {
		/*
		 	Competitor3 name1 103
			Competitor1 name1 104
			Competitor2 name1 105
		 */
		
		competitionResults = new ArrayList<CompetitionResultBM>();
		
		
		
		
	}

	@Override
	public String toString() {
		
		List<CompetitionResultBM> sortedResults = competitionResults.stream()
				.sorted((c1, c2) -> c1.compareTo(c2))
				.collect(Collectors.toList());
		
		Collections.reverse(sortedResults);
		
				
		
		int currentRanking = 0;
	
		int currentPoint = -1;
		
		for(CompetitionResultBM result: sortedResults) {
			
			if (result.getAccumulatedPoints() == currentPoint) {
				result.setRanking(currentRanking);
				
			}
			else {
				result.setRanking(++currentRanking);
			}
			
			currentPoint = result.getAccumulatedPoints();
			
		}
		
		String formattedResult = sortedResults.stream().map(Object::toString).collect(Collectors.joining(System.getProperty("line.separator")));
		
		return formattedResult;
	}
}
