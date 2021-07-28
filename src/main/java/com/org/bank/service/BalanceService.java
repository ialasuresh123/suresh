package com.org.bank.service;

import java.sql.Date;
import java.time.LocalDate;
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
import com.org.bank.model.Transaction_Type;
import com.org.bank.model.User;
import com.org.bank.model.UserTransaction;
import com.org.bank.repository.BalanceRepository;
import com.org.bank.repository.TransactionRepository;
import com.org.bank.repository.Transaction_TypeRepository;
import com.org.bank.repository.UserRepository;

@Service
public class BalanceService {
	@Autowired
	private BalanceRepository balanceRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private Transaction_TypeRepository transaction_TypeRepository;
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
			balanceService.saveTransaction(userId, "addBalance");
			return "amount added successfully";
		}
		throw new UnAuthorisedAccessException(ATMUtility.UNAUTHORIREDEXCEPTION);// add Exception

	}

	private void saveTransaction(Integer userId, String Transaction_Type) {
		// TODO Auto-generated method stub
		Transaction_Type transaction_type = new Transaction_Type();
		transaction_type.setTypeOfTransaction(Transaction_Type);
		transaction_TypeRepository.save(transaction_type);
		transactionRepository.save(new UserTransaction(transaction_type, LocalDate.now(), userId));

	}

	public Double showAvailableBalance(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		Balance balance = balanceRepository.findByUserId(userId);
		balanceService.saveTransaction(userId, "showAvailableBalance");
		if (!ObjectUtils.isEmpty(balance))
			return balance.getAvaiableBalance();

		throw new UserDetailsNotFoundException(ATMUtility.USERDETAILSNOTFOUNDeXCEPTION);// addException
	}

	public ResponseWithdrawAmount checkAvailabilityOfBalance(Integer amount, Integer userId)
			throws Exception {
		// TODO Auto-generated method stub
		Balance balance = balanceRepository.findByUserId(userId);
		if (ObjectUtils.isEmpty(balance))
			throw new UserDetailsNotFoundException(ATMUtility.USERDETAILSNOTFOUNDeXCEPTION);
		if (balance.getAvaiableBalance() > amount) {
			// updating the balance in balance table
			ResponseWithdrawAmount responseWithdrawAmount = balanceService.countNoOfNotes(amount,
					balance.getAvaiableBalance());
			balance.setAvaiableBalance(balance.getAvaiableBalance() - amount);
			balanceRepository.save(balance);
			balanceService.saveTransaction(userId, "Withdraw");
			return responseWithdrawAmount;
		}
		throw new InsufficientBalanceException(ATMUtility.InsufficientBalanceException);
	}

	private ResponseWithdrawAmount countNoOfNotes(Integer amount, Double availableBalance) throws Exception {

		// TODO Auto-generated method stub
		// needed to perform 
		if(amount/100==0)
		{
		Integer[] notes = new Integer[] { 2000, 500, 200, 100 };
		Integer[] noteCounter = new Integer[4];
		for (int i = 0; i < 4; i++) {
			if (amount >= notes[i]) {
				noteCounter[i] = amount / notes[i];
				amount = amount - noteCounter[i] * notes[i];
			}
		}
		return new ResponseWithdrawAmount(notes[3], notes[2], notes[1], notes[0]);
		}
		throw new Exception("add Amount in Multiples of 100");
	}

}
