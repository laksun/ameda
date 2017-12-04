package com.aws.polly.service;

import java.util.List;

import com.aws.polly.commands.FileMongoForm;
import com.aws.polly.model.FileMongo;

public interface FileMongoService {
	
	List<FileMongo> listAll();

	FileMongo getByName(String name);

	FileMongo saveOrUpdate(FileMongo product);

    void delete(String id);

    FileMongo saveOrUpdateFileMongoForm(FileMongoForm fileMongoForm);

}
