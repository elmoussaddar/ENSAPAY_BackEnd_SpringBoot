package com.example.ensapay.Controllers;


import com.example.ensapay.models.Facture;
import com.example.ensapay.request.FactureRequest;
import com.example.ensapay.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/facture")
public class FactureController {

    @Autowired
    private FactureService factureService;

    @PostMapping("/payerFacture")
    @PreAuthorize("hasRole('CLIENT') ")
    public Boolean payerFacture(@Valid @RequestBody FactureRequest factureRequest) throws IOException {
        factureService.PayerFacture(factureRequest.getRef(),factureRequest.getOwnerphone());
        return true;
    }

    @PostMapping("/listFacturecreancier")

    public ResponseEntity<List<Facture>>  getFacturesCreancier(@Valid @RequestBody FactureRequest factureRequest) {

        return ResponseEntity.ok().body(factureService.getListFacturesOfCreancier(factureRequest.getCreancier(),factureRequest.getOwnerphone()));

    }

    @GetMapping("/listFacturecreancier/{creancier}/{ownerphone}")

    public ResponseEntity<List<Facture>>  getFacturesCreancier2(@Valid @PathVariable String creancier,@PathVariable String ownerphone) {

        return ResponseEntity.ok().body(factureService.getListFacturesOfCreancier(creancier, ownerphone));

    }
    @GetMapping("/listFacture")
    @PreAuthorize("hasRole('CLIENT') ")
    public List<Facture> getFactureList(@Valid @RequestBody FactureRequest factureRequest){
        return factureService.getListFactures(factureRequest.getOwnerphone());
    }


}
