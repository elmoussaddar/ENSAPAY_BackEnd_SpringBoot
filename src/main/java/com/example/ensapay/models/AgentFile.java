package com.example.ensapay.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@NoArgsConstructor
@Getter
@Setter
@Table
@Entity
public class AgentFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long file_id;
    private String owneruid;
    private String description;

    private String name;

    private String type;

    @Lob
    private byte[] data;


    public AgentFile(String owneruid,String description, String name, String type, byte[] data) {
        this.owneruid = owneruid;
        this.description = description;
        this.name = name;
        this.type = type;
        this.data = data;
    }
}
