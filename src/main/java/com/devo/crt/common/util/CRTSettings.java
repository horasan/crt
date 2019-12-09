package com.devo.crt.common.util;

/**
 * CRT application wide settings are provided by this class.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
public interface CRTSettings {
	public String getDefaultServiceSuccessMessage();

	public String getCompetitionResultFileFolderName();

	public default String getNewLineCharacter() {
		return System.getProperty("line.separator");
	}
}
