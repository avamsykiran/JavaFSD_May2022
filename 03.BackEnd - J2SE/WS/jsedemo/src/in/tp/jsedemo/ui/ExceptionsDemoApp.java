package in.tp.jsedemo.ui;

import in.tp.jsedemo.exception.BankAccountException;
import in.tp.jsedemo.model.BankAccount;
import in.tp.jsedemo.service.BankAccountService;

public class ExceptionsDemoApp {

	public static void main(String[] args) {
		BankAccountService bas = new BankAccountService();

		BankAccount acc1 = new BankAccount("SB000011", 5600);

		try {
			bas.deposite(null, 0);

			bas.deposite(acc1, 70000);
			System.out.println("Balance After Deposite: " + acc1.getBalance());
			
			bas.deposite(acc1, -7890);
			System.out.println("Balance After Deposite: " + acc1.getBalance());

		} catch (BankAccountException e) {
			System.out.println(e.getMessage());
		}

	}

}
