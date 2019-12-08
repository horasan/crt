package com.devo.crt.restful.competition.v1;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.devo.crt.common.util.FileContentFormatter;
import com.devo.crt.service.competition.CompetitionService;
import com.devo.crt.service.ranking.model.DefaultServiceResponseBM;
/**
 * Unit tests for CompetitionApiImpl class.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class CompetitionApiImplTest {

	@InjectMocks
	private CompetitionApiImpl target;
	
	@Mock
	private CompetitionService mockCompetitionService;
	
	@Mock
	private FileContentFormatter mockFileContentFormatter;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
	}
	

	@Test
	public void testSaveCompetitionResultFile() {
		
		WSCompetitionResultFileRaw competitionResultFileRaw = new WSCompetitionResultFileRaw();
		competitionResultFileRaw.setFileName("fileName");
		competitionResultFileRaw.setRawFileContent("Competitor4 name4 101\r\nCompetitor3 name3 104\r\nCompetitor2 name2 102\r\nCompetitor1 name1 101");
		
		Mockito.when(mockFileContentFormatter.convertFromInputFile(ArgumentMatchers.anyString())).thenReturn(null);
		DefaultServiceResponseBM arg0 = new DefaultServiceResponseBM("message");
		Mockito.when(mockCompetitionService.saveCompetitionResultFile(ArgumentMatchers.any())).thenReturn(arg0);
		
		target.saveCompetitionResultFile(competitionResultFileRaw);
		
		Mockito.verify(mockFileContentFormatter, Mockito.times(1)).convertFromInputFile(ArgumentMatchers.anyString());
		Mockito.verify(mockCompetitionService, Mockito.times(1)).saveCompetitionResultFile(ArgumentMatchers.any());
		
		
	}
	
}
