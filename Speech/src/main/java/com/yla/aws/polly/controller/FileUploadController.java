package com.yla.aws.polly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yla.mongo.model.Catalog;
import com.yla.mongo.model.FileMongo;
import com.yla.mongo.repositories.CatalogRepository;
import com.yla.mongo.repositories.FileMongoRepository;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class FileUploadController {

	final static Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	
	

	@RequestMapping(value = "/fileUpload", method = RequestMethod.GET)
	public String displayForm() {
		return "fileUploadForm";
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String submit(@RequestParam("file") final MultipartFile file, final ModelMap modelMap) {
		logger.warn("uploadFile");
		modelMap.addAttribute("file", file);
		return "fileUploadView";
	}

	@RequestMapping(value = "/uploadMultiFile", method = RequestMethod.POST)
	public String submit(@RequestParam("files") final MultipartFile[] files, final ModelMap modelMap) {
		logger.warn("uploadMultiFile");
		modelMap.addAttribute("files", files);
		return "fileUploadView";
	}

	@RequestMapping(value = "/uploadFileWithAdditionalData", method = RequestMethod.POST)
	public String submit(@RequestParam final MultipartFile file, @RequestParam final String name,
			@RequestParam final String email, RedirectAttributes redirectAttributes, final ModelMap modelMap) {
		logger.warn("uploadFileWithAddtionalData");
		modelMap.addAttribute("name", name);
		modelMap.addAttribute("email", email);
		modelMap.addAttribute("file", file);

		
		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");

		return "fileUploadView";
	}

	

	/**
	 * Upload single file using Spring Controller reference :
	 * https://www.journaldev.com/2573/spring-mvc-file-upload-example-single-multiple-files
	 */
	@Autowired
	CatalogRepository catalogRepository;
	
	@Autowired
	FileMongoRepository fileMongoRepository;
	
	@RequestMapping(value = "/journal/uploadFile", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {
		logger.warn("/journal/uploadFile");
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				if (name == null || "".equals(name)) {
					name = file.getName();
				}
				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.warn("Server File Location=" + serverFile.getAbsolutePath());
				
				//save the file into mongodb
				
				//Catalog catalog = new Catalog("123456", "Times", "New York", "2017","Man of Year", "Anonymous");
				//catalogRepository.save(catalog);

				try {
					FileMongo fileMongo = new FileMongo();
					fileMongo.setFileName(name);
					fileMongoRepository.save(fileMongo);
				} catch (Exception e) {
					logger.error(e.toString());
					// To the user tell that the file is not stored into Mongodb
				}
				
				return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				//e.printStackTrace();
				logger.error(e.toString());
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name + " because the file was empty.";
		}
	}

	/**
	 * Upload multiple file using Spring Controller
	 */
	@RequestMapping(value = "/journal/uploadMultipleFile", method = RequestMethod.POST)
	public @ResponseBody String uploadMultipleFileHandler(@RequestParam("name") String[] names,
			@RequestParam("file") MultipartFile[] files) {

		if (files.length != names.length)
			return "Mandatory information missing";

		String message = "";
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			String name = names[i];
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location=" + serverFile.getAbsolutePath());

				message = message + "You successfully uploaded file=" + name + "";
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		}
		return message;
	}

}