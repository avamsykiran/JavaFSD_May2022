package in.tp.jsedemo.ui;

import java.util.Random;
import java.util.Scanner;

public class ScannerAndRandomDemoApp {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		Random random = new Random();
		
		boolean shallContinue=true;
		
		while(shallContinue) {
			int n = random.nextInt(100);
			int attempts = 0;
			
			while(attempts<=10) {
				
				attempts++;
				
				System.out.println("Guess the number? ");
				int guess = scan.nextInt();
				
				if(guess==n) {
					System.out.println("You WON By "+ attempts + "attempts");
					break;
				}else if(guess<n) {
					System.out.println("TOO SMALL");
				}else {
					System.out.println("TOO BIG");
				}
			}
			
			if(attempts==10) {
				System.out.println("YOU LOST! I hide "+n);
			}
			
			System.out.println("Continue (true/false)? ");
			shallContinue = scan.nextBoolean();
		}
		
		System.out.println("GAME OVER");
	}

}
