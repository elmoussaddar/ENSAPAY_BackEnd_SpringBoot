package com.example.ensapay.service;

import com.example.ensapay.models.AgentFile;
import com.example.ensapay.repository.AgentFileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AgentFileService {

    @Autowired
    private AgentFileRepo agentFileRepo;
    @Autowired
    private AdminService adminService;


    public Boolean store(MultipartFile file,String owneruid,String description) throws IOException {
        String fileName = file.getOriginalFilename();
        AgentFile fileDb = new AgentFile(owneruid,description,fileName, file.getContentType(), file.getBytes());
        agentFileRepo.save(fileDb);
        adminService.addFileToAgent(owneruid,fileName);
        return  true;
    }

    public AgentFile getFileByName(String name) {

        Optional<AgentFile> fileOptional = Optional.ofNullable(agentFileRepo.findByName(name));

        if(fileOptional.isPresent()) {
            return fileOptional.get();
        }
        return null;
    }

    public List<AgentFile> getFileList(){
        return agentFileRepo.findAll().stream().collect(Collectors.toList());
    }

}

