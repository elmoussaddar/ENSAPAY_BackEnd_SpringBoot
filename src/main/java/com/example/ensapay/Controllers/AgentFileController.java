package com.example.ensapay.Controllers;


import com.example.ensapay.models.AgentFile;
import com.example.ensapay.service.AgentFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/file")
public class AgentFileController {

	@Autowired
	private AgentFileService agentFileService;
	
	@PostMapping(value = "/uploadAgentFile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

	public ResponseEntity<?>  uploadFile(@RequestPart("file") MultipartFile  file, @RequestPart("owneruid") String owneruid, @RequestPart("description") String description) throws IOException {
		agentFileService.store(file,owneruid,description);
		 return ResponseEntity.ok().body("file stored with success");
	}


	@GetMapping("/{name}")
	public ResponseEntity<AgentFile>  getFile(@PathVariable String name) {
		
		return ResponseEntity.ok().body( agentFileService.getFileByName(name));
		
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<AgentFile>>  getFileList(){

		return ResponseEntity.ok().body(agentFileService.getFileList()) ;
	}
	

}
