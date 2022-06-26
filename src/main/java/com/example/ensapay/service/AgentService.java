package com.example.ensapay.service;

import com.example.ensapay.models.Agent;
import com.example.ensapay.models.Compte;
import com.example.ensapay.models.UserApp;
import com.example.ensapay.repository.AgentRepo;
import com.example.ensapay.repository.CompteRepo;
import com.example.ensapay.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional @Slf4j
public class AgentService {
    @Autowired
    private final UserRepo userRepo;
    @Autowired
    private final AgentRepo agentRepo;

    @Autowired
    private final MailService emailService;


    private final PasswordEncoder passwordEncoder;

    final String letterLower = "abcdefghijklmnopqrstuvwxyz";
    final String letterUpper= letterLower.toUpperCase();
    final String number = "0123456789";
    final String caractereSpeciaux = "!@#$%&*_?':,;~°^";
    final String passworwdCombinaison= letterLower+ letterUpper + number + caractereSpeciaux;
    public String genererPassword() {

        SecureRandom random = new SecureRandom();
        String password="";
        password+=letterLower.charAt(random.nextInt(letterLower.length()));
        password+=letterUpper.charAt(random.nextInt(letterUpper.length()));
        password+=number.charAt(random.nextInt(number.length()));
        password+=caractereSpeciaux.charAt(random.nextInt(caractereSpeciaux.length()));

        for(int i=0;i<5;i++) {
            password+=passworwdCombinaison.charAt(random.nextInt(passworwdCombinaison.length()));
        }

        return password;
    }



    public Boolean createUser(String username,String nom, String prenom, String email, String numTel) throws IOException, MessagingException {

        UserApp user=new UserApp();

        user.setNom(nom);
        user.setUsername(username);
        user.setPrenom(prenom);
        user.setEmail(email);
        user.setNumTel(numTel);

        String pass=this.genererPassword();
        System.out.println(pass);
        log.info("Password for Client generated: "+pass);


        user.setFirstAuth(true);
        user.setPassword(passwordEncoder.encode(pass));
        userRepo.save(user);

        String content="<h1> Hello Client "+ nom +" "+prenom+" and Welcome To EnsaPay  application.</h1> </br>" +
                " <h3> please use these informations to log In to your Account: </h3>" +
                "<ul>" +
                "<li style='color:blue;'> User Name :  "+email+" </li> " +
                "<li style='color:blue;'> Password : "+pass+" </li> " +
                "</ul>";
        emailService.sendEmail(email,content);
        return  true;

    }

    public UserApp getUser(String numTel) {
        log.info("Fetching user by the agent {}", numTel);
        return userRepo.findByNumTel(numTel);
    }
    public List<UserApp> getUsers() {
        log.info("Fetching all users BY agent");
        return userRepo.findAll();
    }
    public void changePassword(String uid, String newPassword) {
        Agent agent = agentRepo.findByUsername(uid);
        String encodedPassword = passwordEncoder.encode(newPassword);
        if(agent.getFirstAuth() == true){ agent.setFirstAuth(false);}
        agent.setPassword(encodedPassword);
        agentRepo.save(agent);
    }
    public Boolean agentHaschangedPassword(String username){
        Agent agent = agentRepo.findByUsername(username);

        if (agent.getFirstAuth()) return false;
        else return true;
    }
}
