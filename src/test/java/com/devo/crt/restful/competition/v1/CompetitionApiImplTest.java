package com.devo.crt.restful.competition.v1;

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

import com.devo.crt.service.competition.CompetitionService;
import com.devo.crt.service.ranking.model.CompetitionResultFileBM;
import com.devo.crt.service.ranking.model.DefaultServiceResponseBM;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class CompetitionApiImplTest {

	@InjectMocks
	private CompetitionApiImpl target;
	
	@Mock
	private CompetitionService mockRankingService;
	
	/*
	 * TODO: Helper yardimiyla cevrilecek.
	 */
	@Test
	public void testSaveCompetitionResultFile_with_Raw_File_Content() {
		
		WSCompetitionResultFileRaw rawFile = new WSCompetitionResultFileRaw();
		rawFile.setFileName("fileName");
		rawFile.setRawFileContent("...");
		
		target.saveCompetitionResultFile(rawFile);
	}
	
	/*
	 * TODO: Implementation is missing
	 * 
	 */
	@Test
	public void testSaveCompetitionResultFile() {
		
		/*
		WSCompetitionResultFile competitionResultFile = new WSCompetitionResultFile();
		List<WSCompetitionResult> competitionResults = Arrays.asList(getWSCompetitionResult(1), getWSCompetitionResult(1));
		competitionResultFile.setCompetitionResults(competitionResults);
	
		Mockito.when(mockRankingService.saveCompetitionResultFile(Matchers.any(CompetitionResultFileBM .class))).thenReturn(arg0);
		
		target.saveCompetitionResultFile(competitionResultFile);
		*/
		
	}
	
	private WSCompetitionResult getWSCompetitionResult(int index) {
		WSCompetitionResult wsCompetitionResult = new WSCompetitionResult();
		wsCompetitionResult.setAccumulatedPoints(100+index);
		wsCompetitionResult.setRanking(index);
		WSCompetitor wsCompetitor = getWSCompetitor(index);
		wsCompetitionResult.setWsCompetitor(wsCompetitor);
		return wsCompetitionResult;
	}

	private WSCompetitor getWSCompetitor(int index) {
		WSCompetitor wsCompetitor= new WSCompetitor();
		wsCompetitor.setCompetitorId("competitorId".concat(String.valueOf(index)));
		wsCompetitor.setName("name".concat(String.valueOf(index)));
		return wsCompetitor;
	}
}
