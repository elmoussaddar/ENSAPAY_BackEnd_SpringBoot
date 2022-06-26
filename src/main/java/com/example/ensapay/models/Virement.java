package com.example.ensapay.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Virement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_virement;
    @Column(name = "montant")
    private double montant;



    private String ribsource;


    private String ribdest;

    @Column(name = "date_virement")
    private Date date_virement;
}
