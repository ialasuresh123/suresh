package com.org.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.bank.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	org.springframework.security.core.userdetails.User findByUserName(String userName);

	

	

	

}
