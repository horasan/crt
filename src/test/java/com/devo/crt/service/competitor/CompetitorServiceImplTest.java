package com.devo.crt.service.competitor;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.devo.crt.repository.competitor.CompetitorRepository;
import com.devo.crt.service.ranking.model.CompetitionResultBM;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class CompetitorServiceImplTest {

	@InjectMocks
	private CompetitorServiceImpl target;
	
	@Mock
	private CompetitorRepository mockCompetitorRepository;
	
	@Test
	public void tetsGetCompetitor() {
		/*
		List<CompetitionResultBM> arg0 = Arrays.asList(getCompetitionResultBM(1));
		Mockito.when(mockCompetitorRepository.findByName(Matchers.anyString())).thenReturn(arg0);
		
		List<CompetitionResultBM> competitor = target.getCompetitor("competitorName");
		*/
		
		
		
	}
	
}
