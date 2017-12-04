package com.aws.polly.converter;

import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.aws.polly.commands.FileMongoForm;
import com.aws.polly.model.FileMongo;

@Component
public class FileMongoFormToFileMongo implements Converter<FileMongoForm, FileMongo> {

	@Override
	public FileMongo convert(FileMongoForm fileMongoForm) {
		FileMongo fileMongo = new FileMongo();
        if (fileMongoForm.getFileName() != null  && !StringUtils.isEmpty(fileMongoForm.getFileName())) {
            fileMongo.setFileName(new ObjectId(fileMongoForm.getFileName()).toString());
        }
        fileMongo.setFileContent(fileMongoForm.getFileContent());
        return fileMongo;
	}

}
