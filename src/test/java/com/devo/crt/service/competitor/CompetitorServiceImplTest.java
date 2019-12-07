package com.devo.crt.service.competitor;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.devo.crt.repository.competitor.CompetitorRepository;
import com.devo.crt.service.ranking.model.CompetitionResultBM;
import com.devo.crt.service.ranking.model.CompetitorBM;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class CompetitorServiceImplTest {

	@InjectMocks
	private CompetitorServiceImpl target;

	@Mock
	private CompetitorRepository mockCompetitorRepository;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetCompetitor() {

		CompetitionResultBM competitionResultBM = getCompetitionResultBM(1);
		Mockito.when(mockCompetitorRepository.findByName(ArgumentMatchers.anyString()))
				.thenReturn(Arrays.asList(competitionResultBM));

		List<CompetitionResultBM> competitor = target.getCompetitor("competitorName");

		Assertions.assertThat(competitor.size()).isEqualTo(1);

		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

		Mockito.verify(mockCompetitorRepository, Mockito.times(1)).findByName(captor.capture());
		Assertions.assertThat(captor.getValue()).isEqualTo("competitorName");

	}

	private CompetitionResultBM getCompetitionResultBM(int index) {
		CompetitionResultBM competitionResultBM = new CompetitionResultBM();

		competitionResultBM.setAccumulatedPoints(100 + index);
		competitionResultBM.setCompetitorBM(getCompetitorBM(index));
		competitionResultBM.setRanking(index);

		return competitionResultBM;
	}

	private CompetitorBM getCompetitorBM(int index) {
		CompetitorBM competitorBM = new CompetitorBM();
		competitorBM.setCompetitorId("competitorId" + index);
		competitorBM.setName("name" + index);
		return competitorBM;
	}

}
