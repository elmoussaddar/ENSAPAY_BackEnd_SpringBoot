package com.example.ensapay.service;

import com.example.ensapay.models.Compte;
import com.example.ensapay.models.Facture;
import com.example.ensapay.models.UserApp;
import com.example.ensapay.repository.CompteRepo;
import com.example.ensapay.repository.FactureRepo;
import com.example.ensapay.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class FactureService {
    @Autowired
    FactureRepo factureRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    CompteRepo compteRepo;
    final String letterLower = "abcdefghijklmnopqrstuvwxyz";
    final String letterUpper= letterLower.toUpperCase();
    final String number = "0123456789";


      public boolean PayerFacture(String ref,String phoneNum){
          Facture fct=factureRepo.findByRef(ref);
          UserApp user = userRepo.findByNumTel(phoneNum);
          Compte compte = user.getCompte();
          if (fct.getMontant_fac() <= compte.getSolde()){
              Double solde = compte.getSolde();
              compte.setSolde(solde-fct.getMontant_fac());
              compteRepo.save(compte);
              fct.setStatus("payed");
              Date today = Calendar.getInstance().getTime();

              fct.setDate_payement(today);
              factureRepo.save(fct);
              return true;
          }
          else {
              return false;
          }
      }
      public List<Facture> getListFacturesOfCreancier(String creancier,String ownerphone){
          List<Facture> factures = new ArrayList<>();
          for (Facture fct : factureRepo.findAll()){
              if (fct.getCreancier().equals(creancier)){
                  if (fct.getOwnerphone().equals(ownerphone)){
                      factures.add(fct);
                  }

              }
          }
          return factures;

      }
    public List<Facture> getListFactures(String ownerphone){
        List<Facture> factures = new ArrayList<>();
        for (Facture fct : factureRepo.findAll()){
            if (fct.getOwnerphone().equals(ownerphone)){

                    factures.add(fct);


            }
        }
        return factures;
    }
    public String genererRef() {
        Long dateoftoday =  System.currentTimeMillis();
        String dateoftodayinms = dateoftoday.toString();

        SecureRandom random = new SecureRandom();
        String ref="";

        ref+=letterUpper.charAt(random.nextInt(letterUpper.length()));


        for(int i=0;i<3;i++) {
            ref+=number.charAt(random.nextInt(number.length()));
        }
        ref+=dateoftodayinms;

        log.info("ref of facture: "+ref);
        return ref;
    }
    public void createFacture(String status,Double montant,String description,Date dateEmission,String criencier,String ownerphone) throws IOException {
        Facture facture = new Facture( status, montant, description, dateEmission, criencier, ownerphone);
        facture.setRef(genererRef());
        factureRepo.save(facture);


    }
}
