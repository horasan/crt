package com.devo.crt.common.util;
/**
 * TODO: RIZA - Description is here!
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
public interface CRTSettings {
	public String getDefaultServiceSuccessMessage();
	public String getCompetitionResultFileFolderName();
	public String getCompetitionResultFileHistoryFolderName();
	
	public default String getNewLineCharacter() {
		return System.getProperty("line.separator");
	}
}
