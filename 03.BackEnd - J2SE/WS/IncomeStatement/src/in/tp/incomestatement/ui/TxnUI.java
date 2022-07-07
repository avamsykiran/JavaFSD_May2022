package in.tp.incomestatement.ui;

import java.util.Scanner;

import in.tp.incomestatement.service.TxnService;
import in.tp.incomestatement.service.TxnServiceImpl;

public class TxnUI {
	
	private TxnService txnService;
	private Scanner scan;
	
	public TxnUI() {
		this.txnService=new TxnServiceImpl();
		this.scan=new Scanner(System.in);
	}
	
	public void run() {
		MenuOption menu =null;
		MenuOption[] options = MenuOption.values();
		
		while(menu!=MenuOption.QUIT) {
			for(MenuOption option: options)
				System.out.println(option.ordinal() +"\t"+option);
			
			System.out.println("Choice> ");
			int choice = scan.nextInt();
			
			if(choice<0 || choice>=options.length) {
				System.out.println("Invalid choice");
				continue;
			}
			
			menu = options[choice];
			
			switch(menu) {
			case LIST: doList(); break;
			case ADD:doAdd(); break;
			case REMOVE:doRemove(); break;
			case QUIT: System.out.println("Thank you! Bye! Have a nice time ahead"); break;
			}
			
		}
	}
	
	private void doList() {
		
	}
	
	private void doAdd() {
		
	}
	
	private void doRemove() {
		
	}

}
