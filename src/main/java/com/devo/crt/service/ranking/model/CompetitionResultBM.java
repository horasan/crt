package com.devo.crt.service.ranking.model;

import lombok.Getter;

import lombok.Setter;

/**
 * Represents competition result for a competitor.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
@Getter
@Setter
public class CompetitionResultBM implements Comparable<CompetitionResultBM> {
	private CompetitorBM competitorBM;
	private Integer accumulatedPoints;
	private Integer ranking;

	/**
	 * Compares given CompetitionResultBM to itself. Returns -1: If rank of against
	 * is bigger 1: If rank of against is smaller 0: If rank of against is the same
	 */
	@Override
	public int compareTo(CompetitionResultBM against) {
		if (accumulatedPoints < against.getAccumulatedPoints()) {
			return -1;
		}

		if (accumulatedPoints > against.getAccumulatedPoints()) {
			return 1;
		}

		return 0;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s", competitorBM.getCompetitorId(), competitorBM.getName(),
				accumulatedPoints.toString(), ranking.toString());
	}

}
