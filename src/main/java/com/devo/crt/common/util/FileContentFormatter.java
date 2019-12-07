package com.devo.crt.common.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devo.crt.service.ranking.model.CompetitionResultBM;
import com.devo.crt.service.ranking.model.CompetitionResultFileBM;
import com.devo.crt.service.ranking.model.CompetitorBM;

@Component
public class FileContentFormatter {

	@Autowired
	private CRTSettings settings;
	
	public String convertToString(CompetitionResultFileBM resultFile) {
		return resultFile.toString();
	}
	
	public CompetitionResultFileBM convertFromString(String fileContent) {
		CompetitionResultFileBM competitionResultFileBM = new CompetitionResultFileBM();
		
		List<String> competitorList = Arrays.asList(fileContent.split(System.getProperty("line.separator")));
		
		CompetitionResultBM competitionResultBM = null;
		CompetitorBM competitorBM = null;
		List<CompetitionResultBM> competitionResults = new ArrayList<CompetitionResultBM>();
		for(String competitorInfo : competitorList) {
			competitionResultBM = new CompetitionResultBM();
			String[] competitorPropertiesList = competitorInfo.split(" ");
			competitorBM = new CompetitorBM();
			competitorBM.setCompetitorId(competitorPropertiesList[0]);
			competitorBM.setName(competitorPropertiesList[1]);
			competitionResultBM.setAccumulatedPoints(Integer.valueOf(competitorPropertiesList[2]));
			competitionResultBM.setRanking(Integer.valueOf(competitorPropertiesList[3]));
			competitionResultBM.setCompetitorBM(competitorBM);
			competitionResults.add(competitionResultBM);
		}
		competitionResultFileBM.setCompetitionResults(competitionResults);
		return competitionResultFileBM;
	}
}
