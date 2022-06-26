package com.example.ensapay.Controllers;

import com.example.ensapay.models.Admin;
import com.example.ensapay.models.Agent;
import com.example.ensapay.models.UserApp;
import com.example.ensapay.request.AddFileRequest;
import com.example.ensapay.service.AdminService;
import com.example.ensapay.service.AgentFileService;
import com.example.ensapay.service.AgentService;
import com.example.ensapay.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/adminController")
@RequiredArgsConstructor

public class AdminController {

    private final AdminService adminService;
    private final AgentService agentService;
    private final UserService userService;

    @Autowired
    private  AgentFileService agentFileService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Admin check(@RequestBody String uid) throws IOException {

        return adminService.checkAdminExists(uid);

    }

    @GetMapping("/admin")
    public ResponseEntity<List<Admin>> getAdmins() {
        return ResponseEntity.ok().body(adminService.getAdmins());
    }


    @GetMapping("/listAgents")
    public ResponseEntity<List<Agent>>  getAgents() {
        return ResponseEntity.ok().body(
                adminService.getAgents());
    }

    @GetMapping("/listClients")
    public ResponseEntity<List<UserApp>> getClients() {
        return ResponseEntity.ok().body(agentService.getUsers());
    }




}

