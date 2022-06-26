package com.example.ensapay.request;

import javax.validation.constraints.NotBlank;

public class FactureRequest {
    @NotBlank
    private String ref;

    @NotBlank
    private String creancier;
    @NotBlank
    private String ownerphone;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getCreancier() {
        return creancier;
    }

    public void setCreancier(String creancier) {
        this.creancier = creancier;
    }

    public String getOwnerphone() {
        return ownerphone;
    }

    public void setOwnerphone(String ownerphone) {
        this.ownerphone = ownerphone;
    }
}
