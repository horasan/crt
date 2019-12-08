package com.devo.crt.common.util;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.devo.crt.CrtApplication;

/**
 * TODO: RIZA - Description is here!
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
        System.out.println("hello initializer");
        validateCompetitionResultFileFolder();
    }

	private void validateCompetitionResultFileFolder() {
		
		if (!Objects.isNull(settings.getCompetitionResultFileFolderName())) {
			//throw new RuntimeException("Competition Result File Folder Name is not defined!");
			ApplicationHome home = new ApplicationHome(CrtApplication.class);
			System.out.println(home.getDir());
			System.out.println(home.getSource());
		}
		
		System.out.println("Competition Result File Folder Name: ".concat(settings.getCompetitionResultFileFolderName()));
		
		
	}
}
