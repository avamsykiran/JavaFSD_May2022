package in.tp.incomestatement.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import in.tp.incomestatement.exception.InvalidTxnException;
import in.tp.incomestatement.exception.OperationFailedException;
import in.tp.incomestatement.model.Txn;
import in.tp.incomestatement.model.TxnType;
import in.tp.incomestatement.service.TxnService;
import in.tp.incomestatement.service.TxnServiceImpl;
import in.tp.incomestatement.util.KeyboardScanner;

public class TxnUI {

	public static final String DATE_FORMAT = "dd-MMM-yy";

	private TxnService txnService;

	public TxnUI() {
		try {
			this.txnService = new TxnServiceImpl();
		} catch (OperationFailedException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	public void run() {
		MenuOption menu = null;
		MenuOption[] options = MenuOption.values();

		while (menu != MenuOption.QUIT) {
			for (MenuOption option : options)
				System.out.println(option.ordinal() + "\t" + option);

			System.out.println("Choice> ");
			int choice = KeyboardScanner.readInt();

			if (choice < 0 || choice >= options.length) {
				System.out.println("Invalid choice");
				continue;
			}

			menu = options[choice];
			
			try {
				switch (menu) {
				case LIST:
					doList();
					break;
				case ADD:
					doAdd();
					break;
				case REMOVE:
					doRemove();
					break;
				case QUIT:
					System.out.println("Thank you! Bye! Have a nice time ahead");
					break;
				}
			} catch (OperationFailedException exp) {
				System.out.println(exp.getMessage());
			}
		}
	}

	private void doList() throws OperationFailedException {
		List<Txn> txns = txnService.getAll();

		if (txns == null || txns.isEmpty()) {
			System.out.println("No records found!");
		} else {
			for (Txn t : txns) {
				System.out.println(t);
			}
			
			double totalCredit =txnService.getTotalValue(txns, TxnType.CREDIT);
			double totalDebit =txnService.getTotalValue(txns, TxnType.DEBIT);
			double balance = totalCredit-totalDebit;
			
			System.out.println("Totla Credit: "+totalCredit);
			System.out.println("Totla Debit: "+totalDebit);
			System.out.println("Balance: "+balance);
		}
	}

	private void doAdd() throws OperationFailedException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

		System.out.print("Description: ");
		String desp = KeyboardScanner.readString();
		System.out.print("Type (CREDIT/DEBIT): ");
		TxnType type = TxnType.valueOf(KeyboardScanner.readString());
		System.out.println("Amount: ");
		double amount = KeyboardScanner.readDouble();
		System.out.println("Date of Txn(" + DATE_FORMAT + "): ");
		LocalDate txnDate = KeyboardScanner.readDate(formatter);

		try {
			Txn txn = txnService.add(new Txn(0, desp, amount, txnDate, type));
			System.out.println("Txn recorded with id: " + txn.getTxnId());
		} catch (InvalidTxnException e) {
			System.out.println(e.getMessage());
		}
	}

	private void doRemove() throws OperationFailedException {
		System.out.print("TxnId: ");
		int txnId = KeyboardScanner.readInt();
		txnService.deleteById(txnId);
		System.out.println("Txn removed");
	}

}
