package in.tp.is.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.tp.is.entity.Txn;
import in.tp.is.entity.TxnType;
import in.tp.is.exceptions.InvalidTxnException;
import in.tp.is.exceptions.OperationFailedException;
import in.tp.is.service.TxnService;
import in.tp.is.util.KeyboardScanner;

@Component
public class TxnUI implements CommandLineRunner {

	public static final String DATE_FORMAT = "dd-MMM-yy";

	@Autowired
	private TxnService txnService;
	
	@Override
	public void run(String... args) throws Exception {
		
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
			double totalCredit =txnService.getTotalValue(txns, TxnType.CREDIT);
			double totalDebit =txnService.getTotalValue(txns, TxnType.DEBIT);
			double balance = totalCredit-totalDebit;
			
			Consumer<Txn> a= i->{
	            if(i.getType()==TxnType.CREDIT) {
	                System.out.printf(i.getTxnId()+"\t"+i.getTxnDate()+"\t"+"%-15s %7.1f %n" ,i.getDesp(),i.getAmount());
	            }
	            else {
	                System.out.printf(i.getTxnId()+"\t"+i.getTxnDate()+"\t"+"%-15s %21.1f %n" ,i.getDesp(),i.getAmount());
	            }
	        };
	        
	        System.out.println("TxnID \tTxnDate \tDescription \t Credit \tDebit");
	        System.out.println("------------------------------------------------------------------------------------------------------------------------");
	        txns.stream().forEach(a);
	        System.out.println("------------------------------------------------------------------------------------------------------------------------");
	        System.out.printf("Totals"+ "%41.1f %13.1f %n",totalCredit,totalDebit);
	        System.out.println("------------------------------------------------------------------------------------------------------------------------");
	        System.out.printf("Balance"+ " %54.1f %n",balance);
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
