package com.example.ensapay;

import com.example.ensapay.models.Admin;
import com.example.ensapay.service.AdminService;
import com.example.ensapay.service.AgentService;
import com.example.ensapay.service.FactureService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@SpringBootApplication
public class EnsapayApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnsapayApplication.class, args);
    }

/*
    @Bean
    CommandLineRunner run(FactureService factureService, AgentService agentService) {
        return args -> {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            Date date = new Date();


            factureService.createFacture("unpaied",20.0,"paiment facture electricite",date,"LYDEC","0613085665");
            factureService.createFacture("unpaied",47.0,"paiment facture electricite",date,"LYDEC","0765432345");
            factureService.createFacture("unpaied",30.0,"paiment facture eau",date,"LYDEC","0613085665");
            factureService.createFacture("unpaied",120.0,"paiment facture eau",date,"LYDEC","0765432345");
            factureService.createFacture("unpaied",03.5,"paiment facture eau",date,"AMANDISTANGER","0613085665");
            factureService.createFacture("unpaied",40.0,"paiment facture electricite",date,"AMANDISTANGER","0613085665");
            factureService.createFacture("unpaied",57.0,"paiment facture abonement IAM",date,"IAMFACTURES","0613085665");
            factureService.createFacture("unpaied",43.0,"paiment facture abonement IAM",date,"IAMFACTURES","0765432345");
            factureService.createFacture("unpaied",99.0,"paiment facture wifi",date,"IAMFACTURES","0613085665");
            factureService.createFacture("unpaied",99.0,"paiment facture wifi",date,"IAMFACTURES","0765432345");
            factureService.createFacture("unpaied",99.0,"paiment facture electricite",date,"REDAL","0613085665");
            factureService.createFacture("unpaied",20.0,"paiment facture abonement telephone fix",date,"IAMRECHARGE","0613085665");
            factureService.createFacture("unpaied",45.0,"paiment facture abonement telephone fix",date,"IAMRECHARGE","0765432345");
            factureService.createFacture("unpaied",25.0,"paiment facture abonement telephone fix",date,"IAMRECHARGE","0613085665");
            factureService.createFacture("unpaied",27.0,"paiment facture d'eau penalite ",date,"LYDEC","0613085665");
            factureService.createFacture("unpaied",200.0,"paiment facture d'eau penalite",date,"REDAL","0613085665");


           agentService.createUser("agent123","abdelmounim","elmoussaddar","client@mail.com","06465465465");
           adminService.saveAdmin(new Admin("Admin4", "admin4", "admin4@gmail.com"));
    adminService.saveAdmin(new Admin("Admin1234", "admin1234", "admin1234@gmail.com"));
            adminService.createAgent("agent41", "agent4", "CIN", "A123"
                    , new Date(), "marrakech", "agent@mail.com", "0612454558", "az1212",
                    "az1212");
            //adminService.createAgent("Admin","agent1","agent1","CIN","A123"
            //,date,"marrakech","agent@mail.com","0612454558","az1212","az1212");

            //agentService.createUser("D0951653789656527","clienuid","client","client1","client@gmail.com","0646546");

        };
*/

   /* @Bean
    CommandLineRunner run(AgentService agentService) {
        return args -> {

            agentService.createUser("agent2", "abdelmounim", "elmoussaddar", "mounik.moussa@gmail.com", "06465465465");

        };


    }
    */

        }


