package in.tp.jsedemo.service;

import in.tp.jsedemo.exception.BankAccountException;
import in.tp.jsedemo.model.BankAccount;

public class BankAccountService {

	public void deposite(BankAccount acc,double amount) throws BankAccountException {
		
		if(amount<=0)
			throw new BankAccountException("Deposite amount is not expected to be zero or negative");
		
		if(acc!=null) {
			acc.setBalance(acc.getBalance()+amount);	
		}
		
	}
}
