package com.org.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.bank.Exception.UnsuccessFullTransactionException;
import com.org.bank.model.User;
import com.org.bank.service.UserRegistractionService;
import com.org.bank.service.UserService;

@RestController
public class UserRegistrationController {

	@Autowired
	UserRegistractionService userRegistrationService;

	@PostMapping("/addUser")
	public String addUserDetails(@RequestBody User user) throws UnsuccessFullTransactionException {
		return userRegistrationService.addUser(user);
	}
}
