package com.org.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.bank.model.Balance;

@Repository
public interface BalanceRepository extends JpaRepository<Balance,Integer>{

	Balance findByUserId(Integer userId);



}
