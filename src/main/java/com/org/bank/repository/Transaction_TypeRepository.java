package com.org.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.bank.model.Transaction_Type;

public interface Transaction_TypeRepository extends JpaRepository<Transaction_Type,Integer> {

}
