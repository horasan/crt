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
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.devo.crt.restful.competition.v1.WSCompetitor;
import com.devo.crt.service.competitor.CompetitorService;
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
		/*
		List<CompetitorBM> competitorList = Arrays.asList(getCompetitorBM(1), getCompetitorBM(2));
				
		Mockito.when(mockCompetitorService.getCompetitor(ArgumentMatchers.anyString())).thenReturn(competitorList);
		
		ResponseEntity<List<WSCompetitor>> response = target.getCompetitor("competitorName");
		
		Assertions.assertThat(response.getBody().size()).isEqualTo(competitorList.size());
		*/
		
	}

	/**
	 *	TODO: Validate items in API response are correctly mapped.
	 */
	@Test
	public void testGetCompetitor() {
		/*
		List<CompetitorBM> competitorList = Arrays.asList(getCompetitorBM(1), getCompetitorBM(2));
		Mockito.when(mockCompetitorService.getCompetitor(ArgumentMatchers.anyString())).thenReturn(competitorList);
		ResponseEntity<List<WSCompetitor>> response = target.getCompetitor("competitorName");
		
		List<WSCompetitor> responseWSCompetitorList = response.getBody();
		*/
		
		
		
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
