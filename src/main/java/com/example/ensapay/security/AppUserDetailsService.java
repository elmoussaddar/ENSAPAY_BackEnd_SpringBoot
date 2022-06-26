package com.example.ensapay.security;

import com.example.ensapay.models.Admin;
import com.example.ensapay.models.Agent;
import com.example.ensapay.models.UserApp;
import com.example.ensapay.repository.AdminRepo;

import com.example.ensapay.repository.AgentRepo;
import com.example.ensapay.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepo adminRepository;
    @Autowired
    private AgentRepo agentRepo;
    @Autowired
    private UserRepo userRepo;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
        Admin admin =  adminRepository.findByUsername(uid);
        Agent agent = agentRepo.findByUsername(uid);
        UserApp userApp = userRepo.findByNumTel(uid);

        if(agent==null && admin==null && userApp==null) throw new UsernameNotFoundException(uid);
        if (agent!=null) return new AppAgentDetails(agent);
        if (admin!=null) return new AppAdminDetails(admin);
        if (userApp!=null) return new AppUserDetails(userApp);

        return null;
    }
}

