package com.example.ensapay.Controllers;

import com.example.ensapay.models.Virement;
import com.example.ensapay.request.VirementRequest;
import com.example.ensapay.service.VirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/virement")
public class VirementController {

    @Autowired
    private VirementService virementService;

    @PostMapping("/effectuerVirement")

    public Boolean effectuerVirement(@Valid @RequestBody VirementRequest virementRequest) throws IOException {

        return virementService.effectuerVirement(virementRequest.getRibDest(),virementRequest.getRibSrc(),virementRequest.getMontant());
    }

    @GetMapping("/VirementsEnvoyer")
    public List<Virement> getVirementEnv(@Valid @RequestBody VirementRequest virementRequest) {

        return virementService.getListVirementsEnvoyer(virementRequest.getRibSrc());
    }

    @GetMapping("/viremetRecevoir")
    public List<Virement> getVirementRcv(@Valid @RequestBody VirementRequest virementRequest){
        return virementService.getListVirementsRecevoir(virementRequest.getRibDest());
    }


}