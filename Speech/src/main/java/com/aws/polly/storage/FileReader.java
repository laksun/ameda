package com.aws.polly.storage;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class FileReader {

	final static Logger logger = LoggerFactory.getLogger(FileReader.class);
	
	public static void main(String[] args) {
		String fileName = "D:\\10days.txt";
		List<String> lineList =FileReader.readFile(fileName);
		
		//lineList.forEach(lineitem ->System.out.println(lineitem));
		
		//read a pdf file
		fileName = "D:\\tmp\\academic-essay-writing-resource.pdf";
		lineList =FileReader.readPdf(fileName);
		lineList.forEach(lineitem ->System.out.println(lineitem));

	}
	
	public static List<String> readFile(String fileName){
		Path path = Paths.get(fileName);
		List<String> allLines = new ArrayList<String>();
		
		try {
			 allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		return allLines;
		
	}
	
	public static byte[] readFileintoByteArray(String fileName){
		Path path = Paths.get(fileName);
		byte[] bytes = new byte[] {};
		try {
			 bytes = Files.readAllBytes(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		
		return bytes;
		
	}
	
	public static List<String> readPdf(String fileName){
		List<String> allLines = new ArrayList<String>();
		logger.warn("readPdf");
		try {
		    PDDocument document = null;
		    document = PDDocument.load(new File(fileName));
		    document.getClass();
		    if (!document.isEncrypted()) {
		        //PDFTextStripperByArea stripper = new PDFTextStripperByArea();
		        //stripper.setSortByPosition(true);
		        PDFTextStripper Tstripper = new PDFTextStripper();
		        String st = Tstripper.getText(document);
		        allLines.add(st);
		        logger.warn("line" +st);
		    }
		    document.close();
		} catch (Exception e) {
		    e.printStackTrace();
		    logger.error(e.getMessage());
		}
		
		return allLines;
	}

}
