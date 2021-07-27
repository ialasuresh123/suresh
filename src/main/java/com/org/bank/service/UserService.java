package com.org.bank.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.org.bank.Exception.UnsuccessFullTransactionException;
import com.org.bank.Exception.UserDetailsNotFoundException;
import com.org.bank.Exception.Utility.ATMUtility;
import com.org.bank.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName)  {
		//User user = userRepository.findByUserName(userName);
		//if (!ObjectUtils.isEmpty(user))	
		return new User("admin", "password", new ArrayList<>());
		//return user;
		
	}

	

}
