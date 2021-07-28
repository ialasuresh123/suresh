
package com.org.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.org.bank.Exception.UserDetailsNotFoundException;
import com.org.bank.Exception.Utility.ATMUtility;
import com.org.bank.model.UserTransaction;
import com.org.bank.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	public Optional<List<UserTransaction>> findByUserId(Integer userId, PageRequest pageRequest) throws UserDetailsNotFoundException {
		// TODO Auto-generated method

		Optional<List<UserTransaction>> transactions = transactionRepository.findByUserId(userId, pageRequest);
		if(transactions.isPresent())
		return transactions;
		throw new UserDetailsNotFoundException(ATMUtility.USERDETAILSNOTFOUNDeXCEPTION);
	}
}
