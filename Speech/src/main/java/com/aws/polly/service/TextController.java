package com.aws.polly.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aws.polly.model.TextDetails;

@RestController
public class TextController {
	
	public List<TextDetails>  textDetails = new ArrayList<TextDetails>(); 
	
	
	 public TextController()
	    {
		 textDetails.add(new TextDetails("file1", "path1"));
		 textDetails.add(new TextDetails("file2", "path2"));
	    }
	    @RequestMapping(value="/textdetails",method=RequestMethod.GET,produces="application/json")
	    public List<TextDetails> getTextDetails()
	    {
	        return textDetails;
	    }

}
