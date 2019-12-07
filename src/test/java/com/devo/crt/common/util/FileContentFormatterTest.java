package com.devo.crt.common.util;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.devo.crt.service.ranking.model.CompetitionResultFileBM;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class FileContentFormatterTest {

	
	private FileContentFormatter target = new FileContentFormatter();
	
	@Test
	public void testConvertFromString() {
		
		String rawFileContent = String.format("%s%s%s%s%s%s", 
				"Competitor1 Name1 6500 1", System.getProperty("line.separator"),
				"Competitor2 Name2 5500 2", System.getProperty("line.separator"),
				"Competitor3 Name3 3300 3", System.getProperty("line.separator"));
		
		CompetitionResultFileBM resultFile = target.convertFromString(rawFileContent);
		
		Assertions.assertThat(resultFile.getCompetitionResults().size()).isEqualTo(3);
		
		Assertions.assertThat(resultFile.getCompetitionResults().get(0).getAccumulatedPoints()).isEqualTo(6500);
		Assertions.assertThat(resultFile.getCompetitionResults().get(0).getCompetitorBM().getCompetitorId()).isEqualTo("Competitor1");
		Assertions.assertThat(resultFile.getCompetitionResults().get(0).getCompetitorBM().getName()).isEqualTo("Name1");
		Assertions.assertThat(resultFile.getCompetitionResults().get(0).getRanking()).isEqualTo(1);
		
		Assertions.assertThat(resultFile.getCompetitionResults().get(1).getAccumulatedPoints()).isEqualTo(5500);
		Assertions.assertThat(resultFile.getCompetitionResults().get(1).getCompetitorBM().getCompetitorId()).isEqualTo("Competitor2");
		Assertions.assertThat(resultFile.getCompetitionResults().get(1).getCompetitorBM().getName()).isEqualTo("Name2");
		Assertions.assertThat(resultFile.getCompetitionResults().get(1).getRanking()).isEqualTo(2);
		
		Assertions.assertThat(resultFile.getCompetitionResults().get(2).getAccumulatedPoints()).isEqualTo(3300);
		Assertions.assertThat(resultFile.getCompetitionResults().get(2).getCompetitorBM().getCompetitorId()).isEqualTo("Competitor3");
		Assertions.assertThat(resultFile.getCompetitionResults().get(2).getCompetitorBM().getName()).isEqualTo("Name3");
		Assertions.assertThat(resultFile.getCompetitionResults().get(2).getRanking()).isEqualTo(3);
		
				
		
		
	}
	
}
