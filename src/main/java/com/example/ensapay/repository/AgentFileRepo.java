package com.example.ensapay.repository;


import com.example.ensapay.models.AgentFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentFileRepo extends JpaRepository<AgentFile,Long> {
    AgentFile findByName(String name);

}
