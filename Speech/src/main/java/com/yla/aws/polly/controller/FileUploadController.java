package com.yla.aws.polly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yla.aws.polly.exception.EmployeeNotFoundException;
import com.yla.mongo.model.Catalog;
import com.yla.mongo.model.Employee;
import com.yla.mongo.model.FileMongo;
import com.yla.mongo.repositories.CatalogRepository;
import com.yla.mongo.repositories.FileMongoRepository;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class FileUploadController {

	final static Logger logger = LoggerFactory.getLogger(FileUploadController.class);

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
			@RequestParam("file") MultipartFile file) throws Exception {
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

				// save the file into mongodb

				// Catalog catalog = new Catalog("123456", "Times", "New York", "2017","Man of
				// Year", "Anonymous");
				// catalogRepository.save(catalog);

				FileMongo fileMongo = new FileMongo();
				fileMongo.setFileName(name);
				fileMongoRepository.save(fileMongo);

				return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				// e.printStackTrace();
				logger.error(e.toString());
				throw new Exception(e);
				// return "You failed to upload " + name + " => " + e.getMessage();
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

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	public String getEmployee(@PathVariable("id") int id, Model model) throws Exception {
		// deliberately throwing different types of exception
		if (id == 1) {
			throw new EmployeeNotFoundException(id);
		} else if (id == 2) {
			throw new SQLException("SQLException, id=" + id);
		} else if (id == 3) {
			throw new IOException("IOException, id=" + id);
		} else if (id == 10) {
			Employee emp = new Employee();
			emp.setName("Yusuf");
			emp.setId(id);
			model.addAttribute("employee", emp);
			return "home";
		} else {
			throw new Exception("Generic Exception, id=" + id);
		}

	}

}