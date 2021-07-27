package com.org.bank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.org.bank.Exception.InsufficientBalanceException;
import com.org.bank.Exception.UnAuthorisedAccessException;
import com.org.bank.Exception.UserDetailsNotFoundException;
import com.org.bank.Exception.Utility.ATMUtility;
import com.org.bank.model.Balance;
import com.org.bank.model.ResponseWithdrawAmount;
import com.org.bank.model.User;
import com.org.bank.repository.BalanceRepository;
import com.org.bank.repository.UserRepository;

@Service
public class BalanceService {
	@Autowired
	private BalanceRepository balanceRepository;
	@Autowired

	private UserRepository userRepository;

	private BalanceService balanceService;

	public String addBalance(Double amount, Integer userId) throws Exception {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			Balance balance = balanceRepository.findByUserId(userId);
			if (!ObjectUtils.isEmpty(balance))
				balanceRepository.save(new Balance(userId, amount + balance.getAvaiableBalance()));
			else
				balanceRepository.save(new Balance(userId, amount));
			return "amount added successfully";
		}
		throw new UnAuthorisedAccessException(ATMUtility.UNAUTHORIREDEXCEPTION);// add Exception

	}

	public Double showAvailableBalance(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		Balance balance = balanceRepository.findByUserId(userId);
		if (!ObjectUtils.isEmpty(balance)) {
			return balance.getAvaiableBalance();

		}
		throw new UserDetailsNotFoundException(ATMUtility.USERDETAILSNOTFOUNDeXCEPTION);// addException
	}

	public ResponseWithdrawAmount checkAvailabilityOfBalance(Double amount, Integer userId)
			throws UserDetailsNotFoundException, InsufficientBalanceException {
		// TODO Auto-generated method stub
		Balance balance = balanceRepository.findByUserId(userId);
		if (!ObjectUtils.isEmpty(balance))
			throw new UserDetailsNotFoundException(ATMUtility.USERDETAILSNOTFOUNDeXCEPTION);
		if (balance.getAvaiableBalance() > amount) {
			// updating the balance in balance table
			ResponseWithdrawAmount responseWithdrawAmount = balanceService.countNoOfNotes(amount,balance.getAvaiableBalance());
			balance.setAvaiableBalance(balance.getAvaiableBalance() - amount);
			balanceRepository.save(balance);
			return responseWithdrawAmount;
		}
		throw new InsufficientBalanceException(ATMUtility.InsufficientBalanceException);
	}

	private ResponseWithdrawAmount countNoOfNotes(Double amount,Double availableBalance) {

		// TODO Auto-generated method stub
		// needed to perform yet
		return null;
	}

}
