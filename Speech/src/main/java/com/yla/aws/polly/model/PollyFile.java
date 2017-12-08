package com.yla.aws.polly.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PollyFile")
public class PollyFile {
	String fileName;
	String fileContent;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileContent() {
		return fileContent;
	}
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

}
