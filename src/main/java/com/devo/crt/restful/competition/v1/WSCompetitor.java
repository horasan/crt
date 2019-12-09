package com.devo.crt.restful.competition.v1;

import com.devo.crt.service.ranking.model.CompetitorBM;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represent competitor for API layer.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WSCompetitor {

	private String competitorId;

	private String name;

	public WSCompetitor(CompetitorBM competitorBM) {
		competitorId = competitorBM.getCompetitorId();
		name = competitorBM.getName();
	}

	public CompetitorBM toBM() {
		CompetitorBM competitorBM = new CompetitorBM();
		competitorBM.setCompetitorId(competitorId);
		competitorBM.setName(name);
		return competitorBM;
	}
}
