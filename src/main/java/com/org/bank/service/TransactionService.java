
package com.org.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.org.bank.model.UserTransaction;
import com.org.bank.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	public List<UserTransaction> findByUserId(Integer userId, PageRequest pageRequest) {
		// TODO Auto-generated method

		List<UserTransaction> transactions = transactionRepository.findByUserId(userId, pageRequest);
		return null;
	}
}
