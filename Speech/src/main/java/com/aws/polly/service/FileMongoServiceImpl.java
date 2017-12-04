package com.aws.polly.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aws.polly.commands.FileMongoForm;
import com.aws.polly.converter.FileMongoFormToFileMongo;
import com.aws.polly.model.FileMongo;
import com.aws.polly.model.FileRepository;

@Service
public class FileMongoServiceImpl implements FileMongoService {
	
	private FileRepository fileRepository;
    private FileMongoFormToFileMongo fileMongoFormToFileMongo;

	
	public List<FileMongo> listAll() {
		List<FileMongo> fileMongos = new ArrayList<>();
		fileRepository.findAll().forEach(fileMongos::add); //fun with Java 8
        return fileMongos;
	}

	
	public FileMongo getByName(String name) {
		return fileRepository.findOne(name);
	}

	
	public FileMongo saveOrUpdate(FileMongo fileMongo) {
		fileRepository.save(fileMongo);
        return fileMongo;
	}

	
	public void delete(String name) {
		fileRepository.delete(name);

	}

	
	public FileMongo saveOrUpdateFileMongoForm(FileMongoForm fileMongoForm) {
		FileMongo fileMongo = saveOrUpdate(fileMongoFormToFileMongo.convert(fileMongoForm));

        System.out.println("Saved FileMongo Name: " + fileMongo.getFileName());
        return fileMongo;
	}

}
