
package com.org.bank.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.org.bank.Exception.UnsuccessFullTransactionException;
import com.org.bank.Exception.Utility.ATMUtility;
import com.org.bank.repository.UserRepository;
@Service
public class UserRegistractionService {
	private UserRepository userRepository;

	public String addUser(com.org.bank.model.User user) throws UnsuccessFullTransactionException { // TODO
																									// Auto-generated
																									// method stub

		if (userRepository.save(user) != null) {
			return "successfull";
		}
		throw new UnsuccessFullTransactionException(ATMUtility.UnsuccessfullTransactionExCEPTION);
	}

}
