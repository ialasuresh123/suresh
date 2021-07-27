package com.org.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.bank.Exception.InsufficientBalanceException;
import com.org.bank.Exception.UnsuccessFullTransactionException;
import com.org.bank.Exception.UserDetailsNotFoundException;
import com.org.bank.model.JwtRequest;
import com.org.bank.model.JwtResponse;
import com.org.bank.model.ResponseWithdrawAmount;
import com.org.bank.model.User;
import com.org.bank.model.UserTransaction;
import com.org.bank.service.BalanceService;
import com.org.bank.service.TransactionService;
import com.org.bank.service.UserRegistractionService;
import com.org.bank.service.UserService;
import com.org.bank.utility.JWTUtility;

@RestController
public class UserController {
	@Autowired
	private JWTUtility jwtutility;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private UserService userservice;
	@Autowired
	private BalanceService balanceService;

	@GetMapping("/")
	public String home() {
		return "welcome  user";

	}

	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtrequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtrequest.getUserName(), jwtrequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("Invalid Credintials Exception");
		}
		final UserDetails userDetails = userservice.loadUserByUsername(jwtrequest.getUserName());

		final String token = jwtutility.generateToken(userDetails);
		return new JwtResponse(token);

	}

	@PostMapping("/addBalance/{userId}")
	public String addBalance(@RequestParam Double amount, @PathVariable Integer userId) throws Exception {
		return balanceService.addBalance(amount, userId);
	}

	@GetMapping("/showAvailabalance/{userId}")
	public Double showAvailableBalance(@PathVariable Integer UserId) throws Exception {
		return balanceService.showAvailableBalance(UserId);

	}

	@PostMapping("/withdraw/{userId}")
	public ResponseEntity<ResponseWithdrawAmount> withdrawAmount(@RequestParam Double amount,
			@PathVariable Integer userId) throws UserDetailsNotFoundException, InsufficientBalanceException {
		ResponseWithdrawAmount response = balanceService.checkAvailabilityOfBalance(amount, userId);
		return null;

	}

	@GetMapping("/findTransaction/{userId}")
	public ResponseEntity<List<UserTransaction>> findTransactions(@PathVariable Integer userId) {

		List<UserTransaction> transactions = transactionService.findByUserId(userId,
				PageRequest.of(0, 6, Direction.ASC, "Id"));

		return null;
	}

}
