package com.example.ensapay.service;

import com.example.ensapay.models.Admin;
import com.example.ensapay.models.Agent;
import com.example.ensapay.models.AgentFile;
import com.example.ensapay.models.UserApp;
import com.example.ensapay.repository.AdminRepo;
import com.example.ensapay.repository.AgentFileRepo;
import com.example.ensapay.repository.AgentRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AdminService {

    @Autowired
    private final AgentRepo agentRepo;
    @Autowired
    private final AdminRepo adminRepo;
    @Autowired
    private final AgentFileRepo agentFileRepo;

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
    public String genererUid(String email) {
        Long dateoftoday =  System.currentTimeMillis();
        String dateoftodayinms = dateoftoday.toString();

        SecureRandom random = new SecureRandom();
        String uid="";

        uid+=letterUpper.charAt(random.nextInt(letterUpper.length()));

        for(int i=0;i<3;i++) {
            uid+=number.charAt(random.nextInt(number.length()));
        }
        uid+=dateoftodayinms;

        log.info("UID of agent genarated: "+uid);
        return uid;
    }
    public Boolean createAgent(String nom, String prenom, String pieceIdentite,
                               String numPieceIdentite, Date dateNaissance, String adresse, String email,
                               String numTel, String numMatriculation,
                               String numPattente) throws IOException, MessagingException {

        Agent agent=new Agent();

        agent.setNom(nom);
        agent.setPrenom(prenom);
        agent.setPieceIdentite(pieceIdentite);
        agent.setNumPieceIdentite(numPieceIdentite);
        agent.setDateNaissance(dateNaissance);
        agent.setAdresse(adresse);
        agent.setEmail(email);
        agent.setNumTel(numTel);
        agent.setNumMatriculation(numMatriculation);
        agent.setNumPattente(numPattente);
        String uid = this.genererUid(email);
        agent.setUsername(uid);
        agent.setUsersApp(new ArrayList<>());


        String pass=this.genererPassword();
        System.out.println("Password of agent "+pass);
        log.info("Password of agent "+pass);
        //String body = "Bonjour Monsieur / Madame . \n  \n Votre mot de passe est " + pass + ". \n Bienvenue chez nous";
        //this.smtpMailSender.sendMail(agent.getUsername(), "Your Password", body);

        agent.setFirstAuth(true);
        //  smtpMailSender.sendMail(agent.getUsername(), "Your Password", body);
        agent.setPassword(passwordEncoder.encode(pass));
        agentRepo.save(agent);

        String content="<h1> Hello Agent "+ nom +" "+prenom+" and Welcome To EnsaPay  application.</h1> </br>" +
                " <h3> please use these informations to log In to your Account: </h3>" +
                "<ul>" +
                "<li style='color:blue;'> User Name :  "+uid+" </li> " +
                "<li style='color:blue;'> Password : "+pass+" </li> " +
                "</ul>";
        emailService.sendEmail(email,content);
        return  true;
    }


    public Boolean addFileToAgent(String agentUid,String fileName) throws IOException{
        Agent agent = agentRepo.findByUsername(agentUid);
        AgentFile file = agentFileRepo.findByName(fileName);
        agent.getAgentFiles().add(file);
        agentRepo.save(agent);

        return true;
    }


    public Agent getAgent(String uid) {
        log.info("Fetching agent by the admin {}", uid);
        return agentRepo.findByUsername(uid);
    }
    public Admin getAdmin(String uid) {
        log.info("Fetching admin by uid {}", uid);
        return adminRepo.findByUsername(uid);
    }



    public List<Agent> getAgents() {
        log.info("Fetching all agents by admin");
        return  agentRepo.findAll();
    }
    public List<Admin> getAdmins() {
        log.info("Fetching all Admins by admin");

        return adminRepo.findAll();
    }
    public Admin saveAdmin(Admin admin) {
        log.info("Saving new admin {} to the database", admin.getUsername());
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepo.save(admin);
    }
    public Admin checkAdminExists(String uid){
        Admin admin1 = adminRepo.findByUsername(uid);

        if (admin1 != null) return admin1;
        else return null;
    }
}
