package com.devo.crt.repository.competition;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devo.crt.common.util.CRTSettings;
import com.devo.crt.common.util.FileContentFormatter;
import com.devo.crt.restful.exception.CompetitionResultFileNotFound;
import com.devo.crt.service.ranking.model.CompetitionResultFileBM;
/**
 * Competition file repository related implementations.
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
@Repository
public class CompetitionResultRepositoryFileStoreImpl implements CompetitionResultRepository {
	
	public static int COMPETITOR_ID_INDEX = 0;
	public static int COMPETITOR_NAME_INDEX = 1;
	public static int COMPETITOR_ACCUMULATED_POINTS_INDEX = 2;
	public static int COMPETITOR_RANK_INDEX = 3;
	
	
	@Autowired
	private CRTSettings settings;
	
	@Autowired
	private FileContentFormatter fileContentFormatter; 
	
	@Override
	public void saveCompetitionResultFile(CompetitionResultFileBM resultFile) {
		//Save file to folders.
		
		String result = fileContentFormatter.convertToString(resultFile);
		
		// save string to file
		File storeDirectory = new File(getResultFileFolder());
		
		if (!storeDirectory.exists()) {
			storeDirectory.mkdir();
		}
		
		File storeFile = new File(getResultFileFolder().concat("\\").concat(getFileName()));
		
	
		if (!storeFile.exists()) {
			try {
				storeFile.createNewFile();
				
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	
		byte[] strToBytes = result.getBytes();
		 
	    try {
			Files.write(storeFile.toPath(), strToBytes, StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}

	private String getFileName() {
		return settings.getCompetitionResultFileName();
	}

	private String getResultFileFolder() {
		
		
		
		return settings.getCompetitionResultFileFolderName();
	}

	@Override
	public CompetitionResultFileBM getCompetitionResultFile() {

		String fileName = getResultFileFolder().concat("\\").concat(getFileName());
		
		File competitionResultFile = new File(fileName);
		
		if (!competitionResultFile.exists()) {
			throw new CompetitionResultFileNotFound();
		}

		StringBuilder contentBuilder = new StringBuilder();
	    try (Stream<String> stream = Files.lines( Paths.get(fileName))) 
	    {
	        stream.forEach(s -> contentBuilder.append(s).append(System.getProperty("line.separator")));
	    }
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    }

	    return fileContentFormatter.convertFromFile(contentBuilder.toString());
		
	}
}
