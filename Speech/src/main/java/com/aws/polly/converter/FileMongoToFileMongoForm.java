package com.aws.polly.converter;

import org.springframework.core.convert.converter.Converter;

import com.aws.polly.commands.FileMongoForm;
import com.aws.polly.model.FileMongo;

public class FileMongoToFileMongoForm implements Converter<FileMongo, FileMongoForm> {

	
	public FileMongoForm convert(FileMongo fileMongo) {
		FileMongoForm productForm = new FileMongoForm();
        productForm.setFileName(fileMongo.getFileName());//.toHexString());
        productForm.setFileContent(fileMongo.getFileContent());
        return productForm;
	}

}
