package com.msedcl.main.controller;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.msedcl.main.dto.FileUploadDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FileUploadController {

	@Value("${file.upload-dir}")
	private String uploadDir;

	@GetMapping("/upload")
	public String showUploadPage(Model model) {
		model.addAttribute("fileUploadDTO", new FileUploadDTO());
		return "upload";
	}

	@PostMapping("/upload")
	public String uploadFile(@ModelAttribute FileUploadDTO dto, Model model) {

		MultipartFile file = dto.getFile();

		if (file.isEmpty()) {
			model.addAttribute("error", "Please select a file");
			return "upload";
		}

		try {
			String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
			File dest = new File(uploadDir + fileName);
			file.transferTo(dest);

			model.addAttribute("success", "Uploaded: " + fileName);

		} catch (Exception e) {
			log.info(e.getMessage());
			model.addAttribute("error", "Upload failed!");
		}

		return "upload";
	}
}
