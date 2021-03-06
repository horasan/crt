package com.devo.crt.common.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import com.devo.crt.repository.competition.CompetitionResultRepositoryFileStoreImpl;
import com.devo.crt.restful.exception.CompetitionResultFileIsEmpty;
import com.devo.crt.restful.exception.CompetitionResultFilePatternIsNotCorrect;
import com.devo.crt.service.ranking.model.CompetitionResultBM;
import com.devo.crt.service.ranking.model.CompetitionResultFileBM;
import com.devo.crt.service.ranking.model.CompetitorBM;

/**
 * FileContentFormatter provides functionality for processing CRT specific files
 * which are stored in file system.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
@Component
public class FileContentFormatter {

	/**
	 * Converts a CompetitionResultFileBM object to its String representation.
	 * 
	 * @return String
	 *
	 */
	public String convertToString(CompetitionResultFileBM resultFile) {
		return resultFile.toString();

	}
	
	/**
	 * Converts saved and sorted file into CompetitionResultFileBM object.
	 * 
	 * @param fileContent Raw content of saved file. 
	 *
	 */
	public CompetitionResultFileBM convertFromFile(String fileContent) {
		CompetitionResultFileBM competitionResultFileBM = new CompetitionResultFileBM();

		List<String> competitorList = Arrays.asList(fileContent.split(System.getProperty("line.separator")));

		CompetitionResultBM competitionResultBM = null;
		CompetitorBM competitorBM = null;
		List<CompetitionResultBM> competitionResults = new ArrayList<CompetitionResultBM>();

		for (String competitorInfo : competitorList) {
			competitionResultBM = new CompetitionResultBM();
			String[] competitorPropertiesList = competitorInfo.split(" ");
			competitorBM = new CompetitorBM();
			competitorBM.setCompetitorId(
					competitorPropertiesList[CompetitionResultRepositoryFileStoreImpl.COMPETITOR_ID_INDEX]);
			competitorBM
					.setName(competitorPropertiesList[CompetitionResultRepositoryFileStoreImpl.COMPETITOR_NAME_INDEX]);
			competitionResultBM.setAccumulatedPoints(Integer.valueOf(
					competitorPropertiesList[CompetitionResultRepositoryFileStoreImpl.COMPETITOR_ACCUMULATED_POINTS_INDEX]));
			competitionResultBM.setRanking(Integer
					.valueOf(competitorPropertiesList[CompetitionResultRepositoryFileStoreImpl.COMPETITOR_RANK_INDEX]));
			competitionResultBM.setCompetitorBM(competitorBM);
			competitionResults.add(competitionResultBM);
		}
		competitionResultFileBM.setCompetitionResults(competitionResults);
		return competitionResultFileBM;
	}

	/**
	 * Converts input file into CompetitionResultFileBM object.
	 * 
	 * @param fileContent Raw content of input file. 
	 *
	 */
	public CompetitionResultFileBM convertFromInputFile(String fileContent) {
		
		if (fileContent.isEmpty()) {
			throw new CompetitionResultFileIsEmpty();
		}
		
		CompetitionResultFileBM competitionResultFileBM = new CompetitionResultFileBM();

		List<String> competitorList = Arrays.asList(fileContent.split(System.getProperty("line.separator")));

		CompetitionResultBM competitionResultBM = null;
		CompetitorBM competitorBM = null;
		List<CompetitionResultBM> competitionResults = new ArrayList<CompetitionResultBM>();

		for (String competitorInfo : competitorList) {
			competitionResultBM = new CompetitionResultBM();
			String[] competitorPropertiesList = competitorInfo.split(" ");
			
			if (!isFileContentPatternCorrect(competitorPropertiesList)) {
				throw new CompetitionResultFilePatternIsNotCorrect(); 
			}
			
			competitorBM = new CompetitorBM();
			competitorBM.setCompetitorId(
					competitorPropertiesList[CompetitionResultRepositoryFileStoreImpl.COMPETITOR_ID_INDEX]);
			competitorBM
					.setName(competitorPropertiesList[CompetitionResultRepositoryFileStoreImpl.COMPETITOR_NAME_INDEX]);
			competitionResultBM.setAccumulatedPoints(Integer.valueOf(
					competitorPropertiesList[CompetitionResultRepositoryFileStoreImpl.COMPETITOR_ACCUMULATED_POINTS_INDEX]));
			competitionResultBM.setRanking(null);
			competitionResultBM.setCompetitorBM(competitorBM);
			competitionResults.add(competitionResultBM);
		}
		competitionResultFileBM.setCompetitionResults(competitionResults);
		return competitionResultFileBM;
	}

	private boolean isFileContentPatternCorrect(String[] competitorPropertiesList) {

		if (competitorPropertiesList.length != 3) {
			return false;
		}
		
		String expectedPointsAsInteger = competitorPropertiesList[CompetitionResultRepositoryFileStoreImpl.COMPETITOR_ACCUMULATED_POINTS_INDEX];
		
		if (!NumberUtils.isDigits(expectedPointsAsInteger)) {
			return false;
		}
		
		try {
			Integer.valueOf(expectedPointsAsInteger);
		}
		catch(Exception ex) {
			return false;
		}
		
		return true;
		
	}
}
