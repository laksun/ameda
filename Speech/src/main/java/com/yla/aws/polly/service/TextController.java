package com.yla.aws.polly.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.yla.aws.polly.model.TextDetails;

@RestController
public class TextController {

	public List<TextDetails> textDetailsList = new ArrayList<TextDetails>();

	public TextController() {
		textDetailsList.add(new TextDetails("file1", "path1"));
		textDetailsList.add(new TextDetails("file2", "path2"));
	}

	@RequestMapping(value = "/textdetails", method = RequestMethod.GET, produces = "application/json")
	public List<TextDetails> getTextDetails() {
		return textDetailsList;
	}

	// add a file to the system
	@RequestMapping(value = "/text", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public List<TextDetails> processText(@RequestBody TextDetails textDetails) {
		boolean fileExist = false;

		for (TextDetails textDetail : textDetailsList) {
			if (textDetail.getFileName().equals(textDetails.getFileName())) {
				fileExist = true;
				textDetail.setFilePath(textDetails.getFilePath());
				break;
			}
		}
		if (!fileExist) {
			textDetailsList.add(textDetails);
		}

		return textDetailsList;
	}

	@RequestMapping(value = "/deletetext", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	public ResponseEntity deleteText(@RequestBody TextDetails textDetails) {
		Iterator<TextDetails> it = textDetailsList.iterator();
		while (it.hasNext()) {
			TextDetails textDetail = it.next();
			if (textDetail.getFileName().equals(textDetails.getFileName()))
				it.remove();
		}
		return new ResponseEntity(HttpStatus.OK);
	}

	

}
