package com.devo.crt.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Implementations for CRT application wide settings.
 * @see CRTSettings
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */

@Component
public class CRTSettingImpl implements CRTSettings {

	@Autowired
	private Environment env;

	@Override
	public String getDefaultServiceSuccessMessage() {
		return env.getProperty("service.response.default");
	}

	@Override
	public String getCompetitionResultFileFolderName() {
		return env.getProperty("parameter.crt.competition.result.file.folder.name");
	}

}
