package com.example.ensapay.request;

import javax.validation.constraints.NotBlank;

public class VirementRequest {
    @NotBlank
    private String ribSrc;

    @NotBlank
    private String ribDest;
    @NotBlank
    private Double montant;

    public String getRibSrc() {
        return ribSrc;
    }

    public void setRibSrc(String ribSrc) {
        this.ribSrc = ribSrc;
    }

    public String getRibDest() {
        return ribDest;
    }

    public void setRibDest(String ribDest) {
        this.ribDest = ribDest;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }
}

