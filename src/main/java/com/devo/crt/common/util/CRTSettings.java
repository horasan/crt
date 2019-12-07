package com.devo.crt.common.util;

public interface CRTSettings {
	public String getDefaultServiceSuccessMessage();
	public String getCompetitionResultFileFolderName();
	public String getCompetitionResultFileHistoryFolderName();
	
	public default String getNewLineCharacter() {
		return System.getProperty("line.separator");
	}
}
