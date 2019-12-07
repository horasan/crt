package com.devo.crt.service.ranking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devo.crt.common.util.CRTSettings;
import com.devo.crt.repository.ranking.CompetitionResultRepository;
import com.devo.crt.service.ranking.model.CompetitionResultBM;
import com.devo.crt.service.ranking.model.CompetitionResultFileBM;
import com.devo.crt.service.ranking.model.DefaultServiceResponseBM;

@Service
public class RankingServiceImpl implements RankingService {

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
	public CompetitionResultBM getCompetitorByRanking(Integer ranking) {
		return competitionResultRepository.getCompetitorByRanking(ranking);
	}


}
