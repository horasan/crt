package com.devo.crt.common.util;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * This event listener is used to check required folder structure for processing
 * competition file.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */

@Component
public class CRTInitializer {

	@Autowired
	private CRTSettings settings;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {

		validateCompetitionResultFileFolder();
	}

	private void validateCompetitionResultFileFolder() {

		String competitionResultFileFolderName = settings.getCompetitionResultFileFolderName();
		System.out.println("Result file location: ".concat(competitionResultFileFolderName));
		
		String competitionResultFileName = settings.getCompetitionResultFileName();
		System.out.println("Result file name: ".concat(competitionResultFileName));
		
	}
}
