package com.devo.crt.service.competition;

import static org.mockito.Mockito.times;

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

import com.devo.crt.common.util.CRTSettings;
import com.devo.crt.repository.competition.CompetitionResultRepository;
import com.devo.crt.service.ranking.model.CompetitionResultFileBM;
/**
 * Unit tests for CompetitionServiceImpl class.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class CompetitionServiceImplTest {

	@InjectMocks
	private CompetitionServiceImpl target;
	
	@Mock
	private CRTSettings mockSettings;

	@Mock
	private CompetitionResultRepository mockCompetitionResultRepository;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSaveCompetitionResultFile() {
		//settings.getCompetitionResultFileFolderName();
		Mockito.when(mockSettings.getCompetitionResultFileFolderName()).thenReturn("folderName");
		Mockito.doNothing().when(mockCompetitionResultRepository).saveCompetitionResultFile(ArgumentMatchers.any(CompetitionResultFileBM.class));
		
		Mockito.verify(mockSettings, times(1)).getCompetitionResultFileFolderName();
		Mockito.verify(mockCompetitionResultRepository, times(1)).saveCompetitionResultFile(ArgumentMatchers.any(CompetitionResultFileBM.class));
		
	}
	
}
