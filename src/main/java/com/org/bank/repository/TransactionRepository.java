package com.org.bank.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.bank.model.UserTransaction;

@Repository
  public interface TransactionRepository extends JpaRepository<UserTransaction,
  Integer>{
  
  Optional<List<UserTransaction>> findByUserId(Integer userId, PageRequest pageRequest);



  
  
  
 
  
  }
 