package com.example.ensapay.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Table
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_transaction;
    @Column(name = "montant")
    private double montant;

    @OneToOne(cascade = CascadeType.ALL)

    private UserApp user_source;

    @OneToOne(cascade = CascadeType.ALL)

    private UserApp user_dest;

    @Column(name = "date_transaction",nullable = false)
    private Date date_transaction;



}
