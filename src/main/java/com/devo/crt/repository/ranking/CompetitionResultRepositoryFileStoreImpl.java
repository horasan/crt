package com.devo.crt.repository.ranking;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devo.crt.common.util.CRTSettings;
import com.devo.crt.common.util.FileContentFormatter;
import com.devo.crt.service.ranking.model.CompetitionResultBM;
import com.devo.crt.service.ranking.model.CompetitionResultFileBM;

@Repository
public class CompetitionResultRepositoryFileStoreImpl implements CompetitionResultRepository {
	
	@Autowired
	private CRTSettings settings;
	
	@Autowired
	private FileContentFormatter fileContentFormatter; 
	
	@Override
	public void saveCompetitionResultFile(CompetitionResultFileBM resultFile) {
		//Save file to folders etc.
		
		String result = fileContentFormatter.convertToString(resultFile);
		
		// save string to file
		File storeDirectory = new File(settings.getCompetitionResultFileFolderName());
		
		if (!storeDirectory.exists()) {
			storeDirectory.mkdir();
		}
		
		File storeFile = new File(settings.getCompetitionResultFileFolderName().concat("//testFile1.txt"));
		
		if (!storeFile.exists()) {
			try {
				storeFile.createNewFile();
			} catch (IOException e) {
				System.out.println("File creation error!");
			}
		}
		
		byte[] strToBytes = result.getBytes();
		 
	    try {
			Files.write(storeFile.toPath(), strToBytes, StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			//throw new Exception("File error!");
			System.out.println("File writing error!");
		}
		
	}

	@Override
	public CompetitionResultFileBM getCompetitionResultFile() {
		// TOODO: Refactor
		List<String> list = new ArrayList<>();

		String fileName = settings.getCompetitionResultFileFolderName().concat("//testFile1.txt");
		
		StringBuilder contentBuilder = new StringBuilder();
	    try (Stream<String> stream = Files.lines( Paths.get(fileName))) 
	    {
	        stream.forEach(s -> contentBuilder.append(s).append(System.getProperty("line.separator")));
	    }
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
	    
	    //return new CompetitionResultFileBM(contentBuilder.toString());
	    return fileContentFormatter.convertFromString(contentBuilder.toString());
		
	}

	@Override
	public List<CompetitionResultBM> getCompetitorByRanking(Integer ranking) {
		return getCompetitionResultFile().getCompetitionResults().stream().filter(res -> res.getRanking().equals(ranking)).collect(Collectors.toList());
	}

	@Override
	public List<CompetitionResultBM> getCompetitorByAccumulatedPoints(Integer accumulatedPoints) {
		return getCompetitionResultFile().getCompetitionResults().stream().filter(res -> res.getAccumulatedPoints().equals(accumulatedPoints)).collect(Collectors.toList());
	}
	
}
