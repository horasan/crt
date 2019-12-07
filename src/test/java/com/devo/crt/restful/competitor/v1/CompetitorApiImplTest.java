package com.devo.crt.restful.competitor.v1;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.devo.crt.restful.competition.v1.WSCompetitionResult;
import com.devo.crt.restful.exception.CompetitorNotFound;
import com.devo.crt.service.competitor.CompetitorService;
import com.devo.crt.service.ranking.model.CompetitionResultBM;
import com.devo.crt.service.ranking.model.CompetitorBM;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class CompetitorApiImplTest {

	@InjectMocks
	private CompetitorApiImpl target;
	
	@Mock
	private CompetitorService mockCompetitorService;
	
	/**
	 *	Validate number of items in API response against service return.
	 */
	@Test
	public void testGetCompetitor_competitors_count() {
			
		List<CompetitionResultBM> competitionResultList = Arrays.asList(getCompetitionResultBM(1), getCompetitionResultBM(2));
		Mockito.when(mockCompetitorService.getCompetitor(ArgumentMatchers.anyString())).thenReturn(competitionResultList);
		ResponseEntity<List<WSCompetitionResult>> response = target.getCompetitor("competitorName");
		Assertions.assertThat(response.getBody().size()).isEqualTo(competitionResultList.size());
		
	}

	/**
	 *	TODO: Validate items in API response are correctly mapped.
	 */
	@Test
	public void testGetCompetitor_success() {
		
		CompetitionResultBM competitionResultBM = getCompetitionResultBM(1);
		
		Mockito.when(mockCompetitorService.getCompetitor(ArgumentMatchers.anyString())).thenReturn(Arrays.asList(competitionResultBM));
		ResponseEntity<List<WSCompetitionResult>> response = target.getCompetitor("competitorName");
		
		// will return 1 item
		List<WSCompetitionResult> responseList = response.getBody();
		
		// Validate business layer object and api layer object mapping
		Assertions.assertThat(responseList.get(0).getWsCompetitor().getCompetitorId()).isEqualTo(competitionResultBM.getCompetitorBM().getCompetitorId());
		Assertions.assertThat(responseList.get(0).getWsCompetitor().getName()).isEqualTo(competitionResultBM.getCompetitorBM().getName());
		Assertions.assertThat(responseList.get(0).getAccumulatedPoints()).isEqualTo(competitionResultBM.getAccumulatedPoints());
		Assertions.assertThat(responseList.get(0).getRanking()).isEqualTo(competitionResultBM.getRanking());
		
		// Validate HTTP response
		Assertions.assertThat(response.getStatusCode().value()).isEqualTo(HttpStatus.OK.value());
		
	}
	
	@Test
	public void testGetCompetitor_with_CompetitorNotFound_Exception() {
		
		Mockito.when(mockCompetitorService.getCompetitor(ArgumentMatchers.anyString())).thenReturn(null);
		ResponseEntity<List<WSCompetitionResult>> response = null;
		
		try {
			response = target.getCompetitor("competitorName");
			Assertions.fail("Must throw exception!");
		}
		catch(Exception ex) {
			Assertions.assertThat(ex instanceof CompetitorNotFound).isTrue();
		}
	}
	
	private CompetitionResultBM getCompetitionResultBM(int index) {
		CompetitionResultBM competitionResultBM = new CompetitionResultBM();
		competitionResultBM.setCompetitorBM(getCompetitorBM(index));
		competitionResultBM.setAccumulatedPoints(100+index);
		competitionResultBM.setRanking(index);
		return competitionResultBM;
	}
	
	
	private CompetitorBM getCompetitorBM(int index) {
		CompetitorBM competitorBM = new CompetitorBM();
		competitorBM.setCompetitorId(concatIndex("competitorId", index));
		competitorBM.setName(concatIndex("name", index));
		return competitorBM;
	}

	private String concatIndex(String value, int index) {
		return value.concat(String.valueOf(index));
	} 
	
}
