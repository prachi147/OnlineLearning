package com.model.coursesController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileUploaderController {

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(){
		return ResponseEntity.ok("working");
	}
	
}
