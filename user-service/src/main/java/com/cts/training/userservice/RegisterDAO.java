
  package com.cts.training.userservice;
  
  import org.springframework.data.jpa.repository.JpaRepository;
  
  
 public interface RegisterDAO extends JpaRepository<Register,Integer> {
  public Register findByEmail(String email);
 }
 