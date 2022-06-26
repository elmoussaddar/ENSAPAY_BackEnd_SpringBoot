package com.example.ensapay.repository;

import com.example.ensapay.models.Agent;
import com.example.ensapay.models.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AgentRepo extends JpaRepository<Agent, Long> {
    Agent findByUsername(String username);
    Agent findByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}