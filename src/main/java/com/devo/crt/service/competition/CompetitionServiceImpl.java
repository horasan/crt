package com.devo.crt.service.competition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devo.crt.common.util.CRTSettings;
import com.devo.crt.repository.competition.CompetitionResultRepository;
import com.devo.crt.service.ranking.model.CompetitionResultFileBM;
import com.devo.crt.service.ranking.model.DefaultServiceResponseBM;

/**
 * Competition service operation implementations.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
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
}
