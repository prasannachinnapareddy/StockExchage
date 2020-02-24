
  package com.cts.training.dao;
  
  import org.springframework.data.jpa.repository.JpaRepository;
  
  import com.cts.training.model.Register;
  
 public interface RegisterDAO extends JpaRepository<Register,Integer> {
  
 }
 