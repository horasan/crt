package com.devo.crt.service.ranking.model;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
/**
 * Unit tests for CompetitionResultFileBM class.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class CompetitionResultFileBMTest {

	private CompetitionResultFileBM target = new CompetitionResultFileBM();
	
	@Test
	public void testToString() {
		
		CompetitionResultBM resultBM1 = new CompetitionResultBM();
		resultBM1.setAccumulatedPoints(101);
		resultBM1.setRanking(null);
		CompetitorBM competitorBM1 = new CompetitorBM();
		competitorBM1.setCompetitorId("competitorId1");
		competitorBM1.setName("name1");
		resultBM1.setCompetitorBM(competitorBM1);
		
		CompetitionResultBM resultBM2 = new CompetitionResultBM();
		resultBM2.setAccumulatedPoints(102);
		resultBM2.setRanking(null);
		CompetitorBM competitorBM2 = new CompetitorBM();
		competitorBM2.setCompetitorId("competitorId2");
		competitorBM2.setName("name2");
		resultBM2.setCompetitorBM(competitorBM2);
		
		CompetitionResultBM resultBM3 = new CompetitionResultBM();
		resultBM3.setAccumulatedPoints(103);
		resultBM3.setRanking(null);
		CompetitorBM competitorBM3 = new CompetitorBM();
		competitorBM3.setCompetitorId("competitorId3");
		competitorBM3.setName("name3");
		resultBM3.setCompetitorBM(competitorBM3);
		
		List<CompetitionResultBM> competitionResults = Arrays.asList(
				resultBM1, resultBM2, resultBM3
				);
		target.setCompetitionResults(competitionResults);
		
		String result = target.toString();
		
		String expectedResult = String.format("%s%s%s%s%s",
				"competitorId3 name3 103 1", System.getProperty("line.separator"),
				"competitorId2 name2 102 2", System.getProperty("line.separator"),
				"competitorId1 name1 101 3"
				);
		Assertions.assertThat(result).isEqualTo(expectedResult);
	}
	
}
