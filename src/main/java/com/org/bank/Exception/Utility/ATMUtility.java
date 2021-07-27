package com.org.bank.Exception.Utility;

public class ATMUtility {
	private ATMUtility() {
		throw new IllegalStateException("Utility class");
	}

	public static final String UNAUTHORIREDEXCEPTION = "not allowed to  access this functionality";

	public static final String UnsuccessfullTransactionExCEPTION = "transaction is unsuccefull";

	public static final String USERDETAILSNOTFOUNDeXCEPTION = "unable to find user details";
	public static final String InsufficientBalanceException = "Insufficient balance";

}
