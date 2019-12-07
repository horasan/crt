package com.devo.crt.service.competition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devo.crt.common.util.CRTSettings;
import com.devo.crt.repository.competition.CompetitionResultRepository;
import com.devo.crt.service.ranking.model.CompetitionResultBM;
import com.devo.crt.service.ranking.model.CompetitionResultFileBM;
import com.devo.crt.service.ranking.model.DefaultServiceResponseBM;

@Service
public class CompetitionServiceImpl implements CompetitionService {

	@Autowired
	private CRTSettings settings;

	@Autowired
	private CompetitionResultRepository competitionResultRepository;

	@Override
	public DefaultServiceResponseBM saveCompetitionResultFile(CompetitionResultFileBM resultFile) {

		String f = settings.getCompetitionResultFileFolderName();

		competitionResultRepository.saveCompetitionResultFile(resultFile);
		
		return new DefaultServiceResponseBM(settings.getDefaultServiceSuccessMessage());
	}

	@Override
	public CompetitionResultFileBM getAllRankings() {
		return competitionResultRepository.getCompetitionResultFile();
	}

	@Override
	public List<CompetitionResultBM> getCompetitorByRanking(Integer ranking) {
		return competitionResultRepository.getCompetitorByRanking(ranking);
	}

	@Override
	public List<CompetitionResultBM> getCompetitorByAccumulatedPoints(Integer accumulatedPoints) {
		return competitionResultRepository.getCompetitorByAccumulatedPoints(accumulatedPoints);
	}


}