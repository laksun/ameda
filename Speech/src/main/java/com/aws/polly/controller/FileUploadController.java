package com.aws.polly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aws.polly.model.FormDataWithFile;
import com.aws.polly.storage.StorageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class FileUploadController {

	final static Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	private final StorageService storageService;

	@Autowired
	public FileUploadController(StorageService storageService) {
		this.storageService = storageService;
	}

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

		storageService.store(file);
		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");

		return "fileUploadView";
	}

	@RequestMapping(value = "/uploadFileModelAttribute", method = RequestMethod.POST)
	public String submit(@ModelAttribute final FormDataWithFile formDataWithFile, final ModelMap modelMap) {
		logger.warn("uploadFileModelAttribute");
		modelMap.addAttribute("formDataWithFile", formDataWithFile);
		return "fileUploadView";
	}

}