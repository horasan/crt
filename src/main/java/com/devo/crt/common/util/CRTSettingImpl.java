package com.devo.crt.common.util;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.devo.crt.CrtApplication;

/**
 * Implementations for CRT application wide settings.
 * 
 * @see CRTSettings
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */

@Component
public class CRTSettingImpl implements CRTSettings {

	private static final String DEFAULT_FILE_NAME = "CompetitionResults.txt";
	private static final String UNDEFINED_SETTING_VALUE = "<configure-me>";

	@Autowired
	private Environment env;

	@Override
	public String getDefaultServiceSuccessMessage() {
		return env.getProperty("service.response.default");
	}

	@Override
	public String getCompetitionResultFileFolderName() {
		String fileFolder = env.getProperty("parameter.crt.competition.result.file.folder.name");
		if (isSettingNotDefined(fileFolder)) {
			return getDefaultFileLocation();
		}

		return fileFolder.trim();
	}

	private boolean isSettingNotDefined(String fileFolder) {
		return Objects.isNull(fileFolder)
				|| (!Objects.isNull(fileFolder) && fileFolder.trim().equals(UNDEFINED_SETTING_VALUE));
	}

	private String getDefaultFileLocation() {

		ApplicationHome home = new ApplicationHome(CrtApplication.class);
		return home.getDir().toString();
	}

	@Override
	public String getCompetitionResultFileName() {
		String fileName = env.getProperty("parameter.crt.competition.result.file.name");
		if (isSettingNotDefined(fileName)) {
			return getDefaultFileName();
		}

		return fileName.trim();
	}

	private String getDefaultFileName() {
		return DEFAULT_FILE_NAME;
	}

}
