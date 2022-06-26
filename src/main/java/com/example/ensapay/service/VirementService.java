package com.example.ensapay.service;

import com.example.ensapay.models.Compte;
import com.example.ensapay.models.Virement;
import com.example.ensapay.repository.CompteRepo;
import com.example.ensapay.repository.VirementRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class VirementService {
    @Autowired
    VirementService virementService;
    @Autowired
    VirementRepo virementRepo;
    @Autowired
    CompteRepo compteRepo;
    public boolean effectuerVirement(String ribDest,String ribSrc,Double montant){
        Compte compteDest = compteRepo.findByRib(ribDest);
        Compte compteSrc = compteRepo.findByRib(ribSrc);
        Double soldeDest = compteDest.getSolde();
        Double soldeSrc = compteSrc.getSolde();
        if (montant <= soldeSrc){
            compteSrc.setSolde(soldeSrc-montant);
            compteDest.setSolde(soldeDest+montant);
            compteRepo.save(compteDest);
            compteRepo.save(compteSrc);
            return true;
        }
        else return false;


    }
    public List<Virement> getListVirementsEnvoyer(String rib){
        List<Virement> virements = new ArrayList<>();
        for (Virement vrm : virementRepo.findAll()){
            if (vrm.getRibsource().equals(rib)){
                virements.add(vrm);
            }
        }
        return virements;

    }
    public List<Virement> getListVirementsRecevoir(String rib){
        List<Virement> virements = new ArrayList<>();
        for (Virement vrm : virementRepo.findAll()){
            if (vrm.getRibdest().equals(rib)){
                virements.add(vrm);
            }
        }
        return virements;

    }
}
