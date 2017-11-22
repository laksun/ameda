package com.aws.polly.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TextDetails {

	public TextDetails() {
		super();
	}

	public TextDetails(String filename, String filepath) {
		super();
		this.fileName = filename;
		this.filePath = filepath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	@XmlAttribute
	private String fileName;
	@XmlAttribute
	private String filePath;

	@XmlAttribute
	private String textContent;

}
