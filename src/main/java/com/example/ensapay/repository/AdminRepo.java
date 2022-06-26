package com.example.ensapay.repository;

import com.example.ensapay.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Long> {
    Admin findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
