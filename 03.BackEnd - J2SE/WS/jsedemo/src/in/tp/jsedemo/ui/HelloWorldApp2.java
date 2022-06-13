package in.tp.jsedemo.ui;

import java.util.Scanner;

public class HelloWorldApp2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] friends = new String[10];

		System.out.println("Enter ten friends names: ");

		for (int i = 0; i < 10; i++) {
			friends[i] = scanner.next();
		}

		/*
		 * for(int i=0;i<10;i++) { if(i%2==0) {
		 * System.out.println(String.format("Hello %s", friends[i])); } else {
		 * System.out.println(String.format("Hai %s", friends[i])); } }
		 */

		for (int i = 0; i < 10; i++) {
			System.out.println(String.format("%s %s", i%2==0?"Hello ":"Hai ",friends[i]));
		}
	}

}
